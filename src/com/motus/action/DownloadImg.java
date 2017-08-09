package com.motus.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.motus.service.DrawingService;
import com.motus.util.ZipFileUtil;
import com.motus.vo.MotusDrawing;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadImg extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DrawingService drawingService =  new  DrawingService();
	private String[] chkbox;
	private int[] id;
	private String fileName;
	public DrawingService getDrawingService() {
		return drawingService;
	}
	public void setDrawingService(DrawingService drawingService) {
		this.drawingService = drawingService;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) throws UnsupportedEncodingException {
		   this.fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
	}
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

	public InputStream getFileInputStream() throws Exception {
		// TODO Auto-generated method stub
		 HttpServletResponse response = ServletActionContext.getResponse();
		// TODO Auto-generated method stub
		String fileName_zip = "D:/drawing/drawing_zip.zip";  //定义压缩文件的地址
		String path = "D:\\drawing";
		fileName = "drawing_zip.zip";
		int  len = chkbox.length;
		File[] files = new File[len];
		String _imgFileName ;
		int j ;
		
		for(int i=0;i<len;i++){
			j = Integer.valueOf(chkbox[i]);
			MotusDrawing drawing = drawingService.GetDrawing(id[j]);
			String partName = drawing.getName();    //零件名称
			_imgFileName = "D:/drawing/" +drawing.getPid()+ "/"+id[j]+".png";   //图纸对应二维码地址
			File file = new  File(_imgFileName.trim());    //新建文件
			if(file.exists()) {
                files[i] = file;
            }
		}
		   ZipFileUtil.compressFiles2Zip(files,fileName_zip);     //将文件存放到文件夹
		   System.out.println(path);
		   System.out.println(fileName);
	 	   System.out.println(fileName_zip);
	 	   System.out.println(path +"\\"+fileName);
	        //attachment,以附件的方式下载文件,会打开保存文件对话框;inline,以内联的方式下载,浏览器会直接打开文件
	       //InputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
	       //FileInputStream inputStream  = new FileInputStream(path +"\\"+fileName);
	 	   FileInputStream inputStream  = new FileInputStream(fileName_zip);
	      // response.setHeader("Content-Disposition", "attachment;fileName="+java.net.URLEncoder.encode(fileName,"UTF-8"));
	       
	      return  inputStream;
	      
	}
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
}
