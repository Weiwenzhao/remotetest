package com.motus.vo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileUploadTools {
	private File uploadFile[];  //定义上传的文件数组
	private String uploadFileFileName[];//定义上传的文件的名字数组
	private String uploadFileContype[];
	private String pid;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public File[] getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File[] uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	public String[] getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String[] uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	public String[] getUploadFileContype() {
		return uploadFileContype;
	}
	public void setUploadFileContype(String[] uploadFileContype) {
		this.uploadFileContype = uploadFileContype;
	}
	public String beginUpload() throws IOException{
		 for(int i=0;i< uploadFile.length;++i){
			 String path = "D://drawing/1/" + pid; //图纸的存储路径 = 绝对路径 + 项目编号
			 File target = new File(path,uploadFileFileName[i]);         //文件
			 FileUtils.copyFile(uploadFile[i], target);
		 }
		return "success";
		
	}
}
