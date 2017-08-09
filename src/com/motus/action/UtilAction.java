package com.motus.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.motus.service.DrawingService;
import com.motus.service.ProjectService;
import com.motus.vo.MotusAttach;
import com.motus.vo.MotusDrawing;
import com.motus.util.*;
import com.motus.vo.MotusProject;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.faces.taglib.html_basic.InputSecretTag;

public class UtilAction extends ActionSupport{

	private ProjectService projectService = new ProjectService();
	private DrawingService drawingService = new DrawingService();
	private List<MotusProject> project = new ArrayList<MotusProject>();
	private List<MotusAttach> attachment = new ArrayList<MotusAttach>();
	private List<MotusDrawing> drawing = new ArrayList<MotusDrawing>();
	private MotusProject projectInfo = new MotusProject();
	private String data;
	private String id;
	
	
	public MotusProject getProjectInfo() {
		return projectInfo;
	}
	public void setProjectInfo(MotusProject projectInfo) {
		this.projectInfo = projectInfo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public List<MotusDrawing> getDrawing() {
		return drawing;
	}
	public void setDrawing(List<MotusDrawing> drawing) {
		this.drawing = drawing;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public DrawingService getDrawingService() {
		return drawingService;
	}
	public void setDrawingService(DrawingService drawingService) {
		this.drawingService = drawingService;
	}
	public List<MotusProject> getProject() {
		return project;
	}
	public void setProject(List<MotusProject> project) {
		this.project = project;
	}
	public ProjectService getProjectService() {
		return projectService;
	}
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 获取所有的项目信息
	 * @return
	 */
	public String GetProject(){
		project = projectService.GetProjectItem();
		return "success" ;
	}
	/**
	 * 获取项目信息
	 * @return
	 */
	public String GetProjectInfo(){
		projectInfo = projectService.GetProjectInfo(id);
		return "success" ;
	}
	/**
	 * 获取对应项目编号的图纸信息
	 */
	public String GetDrawing(){
		drawing = drawingService.GetDrawingItem(id);
		return "success";
	}
	/**
	 * 获取对应项目对应的附件
	 */
	public String GetAttach(){
		attachment =projectService.getAttachment(id);
		return "success";
	}
	public List<MotusAttach> getAttachment() {
		return attachment;
	}
	public void setAttachment(List<MotusAttach> attachment) {
		this.attachment = attachment;
	}

	/**
	 * 下载对应项目的二维码
	 */
	private String contentType;  
	private long contentLength;  
	private String contentDisposition;  
	private InputStream inputStream; 	
	 public String getContentType() {  
	        return contentType;  
	    }  
	    public long getContentLength() {  
	        return contentLength;  
	    }  
	    public String getContentDisposition() {  
	        return contentDisposition;  
	    } 
	public InputStream getInputStream() {  
	        return inputStream;  
	    }  
	//最终压缩后的zip文件的路径，传递给通用的下载Action
    private String fileName;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public InputStream  DownloadRQImage() throws IOException{
		JSONArray jsonarray = JSONArray.fromObject(data);   //获取json对象
		int len = jsonarray.size();                        //获取数组大小
		fileName = "D://drawing/drawing_zip.zip";
		
	     //ZipOutputStream zos=new ZipOutputStream(new FileOutputStream(zipFile)); 
	   ////  FileInputStream input=null;  
	    // int temp = 0 ; 
	     File[] files = new File[len];
	     System.out.println(jsonarray);
	     String _imgFileName ;
	   for(int i=0;i<len;i++){
			String ii = (String) jsonarray.get(i);
			int tid = Integer.valueOf(ii);
			MotusDrawing drawing = drawingService.GetDrawing(tid);
			String partName = drawing.getName();
			//path = path + drawing.getPid();
			//_imgFileName = "D:/drawing/" +drawing.getPid()+ "/	"+drawing.getName()+"_"+tid +".png";
			_imgFileName = "D:/drawing/" +drawing.getPid()+ "/"+tid +".png";
			//_imgFileName = new String(_imgFileName.getBytes("ISO-8859-1"),"UTF-8");
			File file = new  File(_imgFileName.trim());
			
			if(file.exists()) {
                files[i] = file;
            }
			 
	   }
	 	 ZipFileUtil.compressFiles2Zip(files,fileName);
	 	 fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
	 	 System.out.println(fileName);
	 	 HttpServletResponse response = ServletActionContext.getResponse();
	        //attachment,以附件的方式下载文件,会打开保存文件对话框;inline,以内联的方式下载,浏览器会直接打开文件
	       response.setHeader("Content-Disposition", "attachment;fileName="
	                  + java.net.URLEncoder.encode(fileName,"UTF-8"));//java.net.URLEncoder.encode(fileName,"UTF-8")  编码转换，解决乱码
	          
	        //如果fileName是相对路径
	        //return ServletActionContext.getServletContext().getResourceAsStream(fileName);
	        //如果fileName是绝对路径
	        return new BufferedInputStream(new FileInputStream(fileName));
			//fileName = drawing.getName()+"_"+tid +".png";
//			fileName = drawing.getName()+"_"+tid;
//			fileName = java.net.URLDecoder.decode(fileName, "utf-8");
//			//fileName = new String(fileName.getBytes("GBK"),"ISO-8859-1");
//	        File files = new File(path + "\\" + fileName +".png");
//	        input = new FileInputStream(files); 
//	        zos.putNextEntry(new ZipEntry(files.getName()+File.separator+fileName));//将文件加入到Entry中  
//	        
//	        while(input.read()!=-1){ // 读取内容    
//                zos.write(temp) ;    // 压缩输出    
//            }  
//			}
//	    input.close();  
//	    zos.close();  
//	    contentType="application/x-zip-compressed";//设定文件类型为.zip文件  
//	    contentDisposition="attachment;filename=RQProject_drawing.zip";//设定文件名为test.zip  
//	    inputStream=new FileInputStream(zipFile); //定义流  
//	    System.out.println(inputStream);  
//	    contentLength=inputStream.available();  
	      
	 	 //return "success";  
	}
	
}