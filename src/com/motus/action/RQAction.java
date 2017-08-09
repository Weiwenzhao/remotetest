package com.motus.action;

import org.apache.struts2.ServletActionContext;


import com.motus.util.TwoDimensionCode;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class RQAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[] tids;
	
	
	public int[] getTids() {
		return tids;
	}
	public void setTids(int[] tids) {
		this.tids = tids;
	}
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//String data = ServletActionContext.getRequest().getParameter("tids");
		System.out.println(tids);
		for(int i=0;i<tids.length;i++){
			String encoderContent = String.valueOf(tids[i]);//设置二维码的内容
			TwoDimensionCode handler = new TwoDimensionCode();
			String imgPath = "D://drawing/"+ encoderContent +".png";  
            handler.encoderQRCode(encoderContent, imgPath, "png" );  
	}
		String Message = "操作成功！";
		return Action.SUCCESS;
}
}