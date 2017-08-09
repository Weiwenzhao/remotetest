package com.motus.action;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;


import com.motus.service.DrawingService;
import com.motus.util.PDFUtil;
import com.motus.util.TwoDimensionCode;
import com.motus.vo.FileUploadTools;
import com.motus.vo.MotusDrawing;
import com.motus.vo.MotusWorker;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DrawingAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DrawingService drawingService = new DrawingService();
	private String[] drawingFileName;
	private File[] drawing;
	private String Message;
    private String pid;
    private String type;
    private int[] tid;
    private int[] num;
    private String[] dname;
    
	public int[] getNum() {
		return num;
	}
	public void setNum(int[] num) {
		this.num = num;
	}
	public String[] getDname() {
		return dname;
	}
	public void setDname(String[] dname) {
		this.dname = dname;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int[] getTid() {
		return tid;
	}
	public void setTid(int[] tid) {
		this.tid = tid;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String[] getDrawingFileName() {
		return drawingFileName;
	}
	public void setDrawingFileName(String[] drawingFileName) {
		this.drawingFileName = drawingFileName;
	}
	public File[] getDrawing() {
		return drawing;
	}
	public void setDrawing(File[] drawing) {
		this.drawing = drawing;
	}
	public DrawingService getDrawingService() {
		return drawingService;
	}
	public void setDrawingService(DrawingService drawingService) {
		this.drawingService = drawingService;
	}
	@Override
	public String execute() throws Exception {
		String paths = ServletActionContext.getRequest().getRealPath("/drawing"); //采用相对路径
		MotusWorker worker = (MotusWorker) ServletActionContext.getRequest().getSession().getAttribute("worker");
		String name = worker.getUsername();
		int len = tid.length;
		boolean flg = false;
		if(len > 0){
			for(int i=0;i<len;i++){
				System.out.println(tid[i]);
				MotusDrawing drawings = new MotusDrawing(tid[i],pid,type,dname[i],num[i]);
				String path_ab = "D://drawing/" + pid;             //图纸的存储路径 = 绝对路径 + 项目编号
				String path = paths + "\\" + pid;
				//String path_1= path + "_img";
				String fileName = String.valueOf(tid[i])+".pdf";    //文件的存储名 = 图纸编号.pdf
				String fileName_pdf =String.valueOf(tid[i])+"_pdf.pdf"; 
				File target = new File(path,fileName);                             //新建文件
				File ImgFile_Pdf = new File(path,fileName_pdf);
				File target_ab = new File(path_ab,fileName);
				FileUtils.copyFile(drawing[i], target);
				FileUtils.copyFile(drawing[i],ImgFile_Pdf);
				FileUtils.copyFile(drawing[i],target_ab);
				
				//FileUtils.copyFile(drawing[i], target_1);
				//String image = "/pdf/" + pid+"/"+fileName;                    //数据库存储路径
				//生成PDF文件的略缩图
	            PDFUtil.pdfToJPG(path,fileName_pdf ,tid[i],pid);//生成PDF文件对应的略缩图,abPath对应的是文件路径，生成略缩图之后文件删除
				//String image = fileName;
				String image = "/pdf/" + pid+"/" +fileName  ;
				drawings.setImage(image);
				drawings.setCreatBy(name);
				drawings.setUpdateBy(name);
				//生成图纸二维码
				//String encoderContent = drawings.getName()+"_" +tid[i];//设置二维码的内容
				String encoderContent = String.valueOf(tid[i]);//设置二维码的内容
				TwoDimensionCode handler = new TwoDimensionCode();
				//String imgPath = "D://drawing/"+ drawings.getPid()+"/"+encoderContent +".png";
				//String imgPath = "D://drawing/"+ drawings.getPid()+"/"+tid[i] +".png";
				String imgPath = path+"\\"+tid[i] +".png";
				
				System.out.println(imgPath);
	            handler.encoderQRCode(encoderContent, imgPath, "png",4 ); 
	            System.out.println(drawings.getTid());
				flg = drawingService.addDrawing(drawings);   //添加图纸信息
			}
		}
		if(flg == true){
			Message = "图纸上传成功！";
		}else{
			Message = "图纸上传失败,请检查图纸编号是否冲突！";
		}
		return Action.SUCCESS;



//		//motusDrawing.setMode(String.valueOf(motusDrawing.getTid()));
//		motusDrawing.setImage("/pdf/" + motusDrawing.getPid() +"/"+fileName);  //图纸的存储路径,其中pdf为tomcat对应的虚拟路径

	}
	/**
	 * 数据合法性检测
	 */
	@Override
	public void validate() {
		int  len = tid.length;   //编号数组长度
		String p = pid;
		for(int i=0;i<len;i++){
			System.out.println(tid[i]);
			System.out.println(num[i]);
			System.out.println(dname[i]);
		}
		
		if(num.length > len || num.length < len){
			this.addFieldError("tid", "图纸信息不全，请确认！");
		}
			if(dname.length > len || dname.length < len ){
				this.addFieldError("tid", "图纸信息不全，请确认！");
			}
			if(drawing.length > len || drawing.length < len){
				this.addFieldError("tid", "图纸信息不全，请确认！");
			}
	}
}
