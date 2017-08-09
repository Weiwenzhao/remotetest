package com.motus.util;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;

import org.apache.commons.io.FileUtils;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;

public class PDFUtil {
	 static final int wdFormatPDF = 17;// PDF 格式   
	 /**
	  * 将word装换成PDF
	  * @param sfileName    word文件地址
	  * @param toFileName    生成的pdf文件地址
	  */
     public void wordToPDF(String sfileName,String toFileName){   
         System.out.println("启动Word...");     
         long start = System.currentTimeMillis();     
         ActiveXComponent app = null; 
         Dispatch doc = null; 
         try {     
             app = new ActiveXComponent("Word.Application");  
             
             app.setProperty("Visible", new Variant(false)); 
             
             Dispatch docs = app.getProperty("Documents").toDispatch();  
//         doc = Dispatch.call(docs,  "Open" , sourceFile).toDispatch();  
             doc = Dispatch.invoke(docs,"Open",Dispatch.Method,new Object[] {                   
                sfileName, new Variant(false),new Variant(true) }, new int[1]).toDispatch();              
             System.out.println("打开文档..." + sfileName); 
             System.out.println("转换文档到PDF..." + toFileName);     
             File tofile = new File(toFileName);     
             if (tofile.exists()) {     
                 tofile.delete();     
             }       
//         Dispatch.call(doc, "SaveAs",  destFile,  17);                   
             Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {               
                 toFileName, new Variant(17) }, new int[1]);   
             long end = System.currentTimeMillis();     
             System.out.println("转换完成..用时：" + (end - start) + "ms.");               
         } catch (Exception e) { 
             e.printStackTrace(); 
             System.out.println("========Error:文档转换失败：" + e.getMessage());     
         } finally { 
             Dispatch.call(doc,"Close",false); 
             System.out.println("关闭文档"); 
             if (app != null)     
                 app.invoke("Quit", new Variant[] {});     
             } 
           //如果没有这句话,winword.exe进程将不会关闭 
            ComThread.Release();    
     } 
     
//     public static void main(String[] args) { 
//         TestUtil d = new TestUtil(); 
//         d.wordToPDF("D:\\work\\1111.docx", "d:\\work\\1111.pdf"); 
//     } 
     
     /**
      * 将PDF文件生成为JPG格式
      */
     public static void pdfToJPG(String path,String fileName ,int tid,String pid)throws IOException {
    	// 加载PDF文件输入流
    	 String inputFile = path +"\\"+fileName;
         File file = new File(inputFile);
         
         //图片生成路径
         //String img_path = "D://drawing/" + pid + "/" + tid + "_temp.jpg";
         String img_path = path + "\\" + tid + ".jpg";
         //File imp_jpg = new File(img_path);
         RandomAccessFile raf = new RandomAccessFile(file, "r");
         FileChannel channel = raf.getChannel();
         
       //这句代码通道建立了map映射,如果要删除file那么得接触映射
         ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0,channel.size());
         PDFFile pdffile = new PDFFile(buf);
         int totalpage =pdffile.getNumPages();  //PDF 文件的页数
         
         for (int i = 1; i <= totalpage; i++) {
        	 if (i == 1) {
                 // 以图片的形式来描绘首页
                 PDFPage page = pdffile.getPage(i);
                 Rectangle rect = new Rectangle(0, 0, (int) page.getBBox().getWidth(), (int) page.getBBox().getHeight());
                 // generate the image
                 // 生成图片
                 Image img = page.getImage(rect.width, rect.height, // width &
                     // height
                     rect, // clip rect
                     null, // null for the ImageObserver
                     true, // fill background with white
                     true // block until drawing is done
                     );
                 BufferedImage tag = new BufferedImage(rect.width, rect.height,BufferedImage.TYPE_INT_RGB);
                 tag.getGraphics().drawImage(img.getScaledInstance(rect.width, rect.height, Image.SCALE_SMOOTH), 0, 0, rect.width, rect.height,null);
                // FileOutputStream out = new FileOutputStream( "D:\\drawing\\pdf_12"+ ".jpg"); // 输出到文件流
                 FileOutputStream out = new FileOutputStream(img_path); // 输出到文件流
                 JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
                 encoder.encode(tag); // JPEG编码
                 // 关闭输出流
                 out.close();
                 break;
        	 }
         }
         buf.clear();
         channel.close();
         raf.close();
         unmap(buf);
         file.delete();
     }
     //解除map映射
     public static <T> void unmap(final Object buffer) {
         AccessController.doPrivileged(new PrivilegedAction<T>(){
             public T run() {
                 try {
                     Method getCleanerMethod = buffer.getClass().getMethod("cleaner", new Class[0]);
                     getCleanerMethod.setAccessible(true);
                     sun.misc.Cleaner cleaner = (sun.misc.Cleaner) getCleanerMethod.invoke(buffer, new Object[0]);
                     cleaner.clean();
                 } catch(Exception e) {
                     e.printStackTrace();
                 }
                 return null;
             }
         });
     }
}
