package com.motus.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.struts2.ServletActionContext;

import com.motus.service.DrawingService;
import com.motus.util.ExcelUtil;
import com.motus.util.PDFUtil;
import com.motus.util.TwoDimensionCode;
import com.motus.vo.MotusDrawing;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ExportExcel extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String[] chkbox;          //选中文件的复选框
	private int[] id;                 //对应的图纸编号
	private InputStream excelStream;  //文件输出流变量  
	private String excelFileName;     //下载文件名  
	private int pid;                  //获取的项目编号
	/**
	 * setter and getter
	 * @return
	 */
	public String[] getChkbox() {
		return chkbox;
	}
	public void setChkbox(String[] chkbox) {
		this.chkbox = chkbox;
	}
	public int[] getId() {
		return id;
	}
	public void setId(int[] id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public DrawingService getDrawingService() {
		return drawingService;
	}
	public void setDrawingService(DrawingService drawingService) {
		this.drawingService = drawingService;
	}
	public String getExcelFileName() {
		return excelFileName;
	}
	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	public void setExcelFileName(String excelFileName) throws UnsupportedEncodingException {
		this.excelFileName = new String(excelFileName.getBytes("ISO-8859-1"),"UTF-8");
	}
	DrawingService drawingService =  new DrawingService();

	public InputStream getExcelStream() {
		return excelStream;
	}

	/**
	 * 打印生成excel表格信息
	 * @return
	 * @throws IOException
	 */
	public String CreateExcel() throws IOException{
		String path = ServletActionContext.getRequest().getRealPath("/drawing"); //采用相对路径

		BufferedImage bufferImg = null;        //二维码信息
		BufferedImage bufferImg2 = null;       //略缩图信息
		int len = chkbox.length; //获取需要打印的图纸信息长度
		int j = 0;               //通过复选框获取到对应图纸信息的id
		int k = 1;               //id信息下标值
		HttpServletResponse response = ServletActionContext.getResponse();
		
		//创建图纸略缩图信息
		for(int i = 1; i<len+1;i++){
        	j = Integer.valueOf(chkbox[i-1]);  
        	MotusDrawing drawing = drawingService.GetDrawing(id[j]);  //获取对应的图纸信息
        //	String _imgPath = drawing.getImage();           //文件的数据库存储路径
        //	String[] real = _imgPath.split("pdf");
        	//String abPath = "D://drawing" + real[1] + "pdf";     //文件的绝对路径，D://drawing/项目编号/图纸
        	
        	//新建临时文件，用以生成略缩图图片
           // String temp_path = "D://drawing/temp_"+ drawing.getTid() +".pdf";
           // File src_File = new File(abPath);         //获取文件
          //  File temp_File = new File(temp_path);      //新建临时文件
            //通过JVM读取java.io.tmpdir属性取得临时文件夹
            //File targetDir = new File(System.getProperty("java.io.tmpdir"));
          //  
           // FileUtils.copyFile(src_File, temp_File);   //复制文件
          //PDFUtil.pdfToJPG("D://drawing/20170626_img/4_img.pdf"); 
        	//PDFUtil.pdfToJPG(temp_path,fileName,drawing.getTid(),drawing.getPid());//生成PDF文件对应的略缩图,abPath对应的是文件路径，生成略缩图之后文件删除
        }
		
		//创建workBook对象 ，对应表单
		HSSFWorkbook wb = new HSSFWorkbook();  
		//创建sheet 
		HSSFSheet sheet = wb.createSheet("项目信息");
		//wb.setSheetName(0, "项目信息",(short)1);
		//画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）  
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();  
            
//        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();  //二维码图片二进制字节流
//        ByteArrayOutputStream byteArrayOut2 = new ByteArrayOutputStream(); //图纸信息略缩图
//        bufferImg = ImageIO.read(new File("D://drawing/123.png"));          //图纸字节流
//        bufferImg2 = ImageIO.read(new File("D://drawing/pdf_12.jpg"));      //略缩图字节流
//        ImageIO.write(bufferImg, "png", byteArrayOut);
//        ImageIO.write(bufferImg2, "png", byteArrayOut2);
            
        //anchor主要用于设置图片的属性  
        //HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,(short) 2, 2, (short) 5, 14);     
        //anchor.setAnchorType(3); 
        //插入图片
        //patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
            
		    //创建行row:添加表头0行 
		    HSSFRow row = sheet.createRow(0);
		    HSSFCellStyle style = wb.createCellStyle();   
		    style.setFillBackgroundColor((short)13);
		    style.setAlignment(HSSFCellStyle.ALIGN_CENTER); //居中  
		    HSSFFont font = wb.createFont();  //设置字体
		    font.setFontName("黑体");
		    font.setFontHeightInPoints((short) 16);//设置字体大小
		    style.setFont(font);
		    //设置表格的列款
		    sheet.setColumnWidth(0, 3766); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		    sheet.setColumnWidth(1, 3766); 
		    sheet.setColumnWidth(2, 3766); 
		    sheet.setColumnWidth(3, 3766); 
		    sheet.setColumnWidth(4, 3766); 
		    sheet.setColumnWidth(5, 3766); 
		   //创建单元格 ，表格头
		    HSSFCell cell = row.createCell(0);     //第一个单元格 
		    cell.setCellValue("项目");        
		    cell.setCellStyle(style);       
		    cell = row.createCell(1);          
		    cell.setCellValue("名称"); 
		    cell.setCellStyle(style); 
		    cell = row.createCell(2); 
		    cell.setCellValue("图纸"); 
		    cell.setCellStyle(style); 
		    cell = row.createCell(3);          
		    cell.setCellValue("时间"); 
		    cell.setCellStyle(style); 
		    cell = row.createCell(4);         
		    cell.setCellValue("生产数量"); 
		    cell.setCellStyle(style); 
		    cell = row.createCell(5);
		    cell.setCellValue("二维码"); 
		    cell.setCellStyle(style); 
		   
		    for(int i=1;i<len+1;i++){
				j = Integer.valueOf(chkbox[i-1]);
				
				MotusDrawing drawing = drawingService.GetDrawing(id[j]);  //获取对应的图纸信息对象
				
				ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();  //二维码图片二进制字节流
				ByteArrayOutputStream byteArrayOut2 = new ByteArrayOutputStream(); //图纸信息略缩图
				//bufferImg = ImageIO.read(new File("D://drawing/"+drawing.getPid()+"/"+drawing.getTid()+".png"));          //图纸字节流
			    //bufferImg2 = ImageIO.read(new File("D://drawing/"+drawing.getPid()+"/" + drawing.getTid()+"_temp.jpg"));      //略缩图字节流
				bufferImg = ImageIO.read(new File(path+"\\"+drawing.getPid()+"\\"+drawing.getTid()+".png"));          //图纸字节流
				bufferImg2 = ImageIO.read(new File(path+"\\"+drawing.getPid()+"\\"+drawing.getTid()+".jpg"));      //略缩图字节流
				ImageIO.write(bufferImg, "png", byteArrayOut);
			    ImageIO.write(bufferImg2, "png", byteArrayOut2);
		        //创建行 
				if(i>1){
					k = k+13;
				}
				row = sheet.createRow(k); 
		        //创建单元格并且添加数据 ,对应到具体的数据单元格
		        row.createCell(0).setCellValue(drawing.getPid());   //项目名称 
				//cell = row.createCell(0);
				//cell.setCellValue(drawing.getPid());
		        row.createCell(1).setCellValue(drawing.getName());   //图纸名称
		        cell = row.createCell(1);
		        cell.setCellValue(drawing.getName());
		        cell.setCellStyle(style);
		        //row.createCell(2).setCellValue(drawing.getTid());    //图纸编号
		        cell = row.createCell(2);
		        cell.setCellValue(drawing.getTid());
		        //cell.setCellStyle(style);
		        // row.createCell(3).setCellValue(drawing.getCreatTime());  //开始时间
		        cell = row.createCell(3);
		        cell.setCellValue(drawing.getCreatTime());
		        CreationHelper createHelper = wb.getCreationHelper();  
		        CellStyle cellStyle = wb.createCellStyle();  
		        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));  
		        cell.setCellStyle(cellStyle);
		        //row.createCell(4).setCellValue(drawing.getNum());      //数量
		        cell = row.createCell(4);
		        cell.setCellValue(drawing.getNum());
		        cell.setCellStyle(style);
		        
		        HSSFClientAnchor anchor = new HSSFClientAnchor(700, 0, 0, 0,(short)0, (k+1), (short) 3, (k+12));
		        HSSFClientAnchor anchor1 = new HSSFClientAnchor(255, 0, 0, 0,(short)3, (k+1), (short)6, (k+12));
		        anchor.setAnchorType(3); 
		        anchor1.setAnchorType(3);
	            //插入图片
	            patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
	            patriarch.createPicture(anchor1, wb.addPicture(byteArrayOut2.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
		    }
		
		   //将文件存到流中
		    ByteArrayOutputStream os = new ByteArrayOutputStream();
		    wb.write(os);   //写入文件到workbook中
		    byte[] fileContent = os.toByteArray();  
            ByteArrayInputStream is = new ByteArrayInputStream(fileContent);
            excelFileName = "项目图纸信息";//设置文件下载名
           // response.setHeader( "Content-Disposition", "attachment;filename=\""+ new String(excelFileName.getBytes( "gb2312" ), "ISO8859-1" )+ ".xls" + "\"" ); 
            excelStream = is;
            return SUCCESS;
}
	/**
	 * 数据合法性检测
	 */
	@Override
	public void validate() {
		super.validate();
			
	}
}