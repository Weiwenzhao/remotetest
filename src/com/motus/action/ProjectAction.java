package com.motus.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.motus.service.ProjectService;
import com.motus.vo.MotusAttach;
import com.motus.vo.MotusProject;
import com.motus.vo.MotusWorker;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProjectAction extends ActionSupport implements ModelDriven<MotusProject>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MotusProject project = new MotusProject();
	private String info;
	
	

	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	ProjectService projectService = new ProjectService();
		public ProjectService getProjectService() {
		return projectService;
	}
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
		@Override
		public String execute() throws Exception {
			// TODO Auto-generated method stub
			boolean flag = false;
			
			flag = projectService.addProject(project);
			if(flag){
				info="项目添加成功！";
			}else{
				info="项目添加失败！";
				return Action.INPUT;
			}
			return Action.SUCCESS;
		}
		public MotusProject getProject() {
			return project;
		}
		public void setProject(MotusProject project) {
			this.project = project;
		}
		/**
		 * 参数合法性检测
		 */
		@Override
		public void validate() {
			// TODO Auto-generated method stub
			//MotusProject projectExist = null;
//			if(project.getPid()!= null ){
//				 projectExist = projectService.GetProject(project.getPid());
//			}
//			
//			if(projectExist != null){
//				this.addFieldError("project", "项目已存在，请重新确认！");
//			}
			if("".equals(project.getPid())){
				this.addFieldError("project", "请输入项目编号!");
			}
			if( "".equals(project.getPname())){
				this.addFieldError("pname", "请输入项目名称！！");
			}
		}
		/**
		 * 添加附件信息
		 * @return
		 */
		private String attname;
		private File attachment;
		private String attachmentFileName;
		private String attcomment;
		public String getAttcomment() {
			return attcomment;
		}
		public void setAttcomment(String attcomment) {
			this.attcomment = attcomment;
		}
		public String getAttname() {
			return attname;
		}
		public void setAttname(String attname) {
			this.attname = attname;
		}
		public File getAttachment() {
			return attachment;
		}
		public void setAttachment(File attachment) {
			this.attachment = attachment;
		}
		public String getAttachmentFileName() {
			return attachmentFileName;
		}
		public void setAttachmentFileName(String attachmentFileName) {
			this.attachmentFileName = attachmentFileName;
		}
		public String AddAttachment() throws IOException{
			//String paths = ServletActionContext.getRequest().getRealPath("/drawing"); //采用相对路径
			//String path = paths + "\\" + project.getPid();
			String filepath = "D://drawing/" + project.getPid();
			File target = new File(filepath,attachmentFileName);  
			FileUtils.copyFile(attachment, target);
		   
		    
			boolean flag = false;
			String att_info = "";
			MotusWorker worker = (MotusWorker) ServletActionContext.getRequest().getSession().getAttribute("worker");
			MotusAttach att = new MotusAttach();
			att.setPid(project.getPid());
			att.setAname(attname);
			att.setCreateby(worker.getName());
			att.setUpdateby(worker.getName());
			att.setComment(attcomment);
			String attpath = "/pdf/" + project.getPid()+"/"+attachmentFileName;
			att.setPath(attpath);
			flag = projectService.addAtt(att);   //添加附件
			if(flag){
				att_info = "附件添加成功！";
			}else{
				att_info = "附件添加失败！";
			}
			return SUCCESS;
			
		}
		/**
		 * 删除附加信息
		 */
		private int attid;
		public int getAttid() {
			return attid;
		}
		public void setAttid(int attid) {
			this.attid = attid;
		}
		public String DeldAttachment(){
			projectService.DelAtt(attid);
			return SUCCESS;
			
		}
		public MotusProject getModel() {
			// TODO Auto-generated method stub
			return project;
		}
	
}
