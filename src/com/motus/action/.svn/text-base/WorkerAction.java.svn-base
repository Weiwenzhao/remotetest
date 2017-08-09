package com.motus.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.motus.service.DrawingService;
import com.motus.vo.MotusDrawing;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class WorkerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private DrawingService drawingService = new DrawingService();
	private MotusDrawing drawing = new MotusDrawing();
	private String path;
	private String Message;
	
	
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public MotusDrawing getDrawing() {
		return drawing;
	}
	public void setDrawing(MotusDrawing drawing) {
		this.drawing = drawing;
	}
	public DrawingService getDrawingService() {
		return drawingService;
	}
	public void setDrawingService(DrawingService drawingService) {
		this.drawingService = drawingService;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String execute() throws Exception {
		//判断当前图纸是否存在，通过图纸ID，获取图纸路径
		int ii = Integer.valueOf(id);
		drawing = drawingService.GetDrawing(ii);
		if(drawing != null){
			path = drawing.getImage();
			System.out.println(path);
			if(path == ""){
				Message = "文件不存在！";
			}
		}
	    return Action.SUCCESS;
	}
	/**
	 * 表单提交验证
	 */
	@Override	
	public void validate(){
		// TODO Auto-generated method stub
		boolean flag = true;
		 MotusDrawing drawingView = new MotusDrawing();
		 if("".equals(id)){
				this.addFieldError("id", "请输入图纸编号！");
			}else{
				Pattern pattern = Pattern.compile("[0-9]*"); 
				Matcher isNum = pattern.matcher(id);  
				flag = isNum.matches();
				if(flag){     //输入的是数字
					int ii = Integer.valueOf(id);
					drawingView  = drawingService.GetDrawing(ii);
					if(drawingView == null){
						this.addFieldError("id", "图纸不存在！");
					}
				}else{
					this.addFieldError("id","图纸编号错误！");
				}
		}	
	}
}
