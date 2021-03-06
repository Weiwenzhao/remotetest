package com.motus.action;

import org.apache.struts2.ServletActionContext;

import com.motus.dao.LoginDaoImpl;
import com.motus.service.LoginService;
import com.motus.vo.MotusWorker;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username = "";
	private LoginService loginService = new LoginService();
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		MotusWorker worker = new MotusWorker();
		worker = loginService.GetWorker(username);
		if(worker != null){
			ServletActionContext.getRequest().getSession().setAttribute("worker", worker);
		}
		name = worker.getName();
		String depart = worker.getDepart();
		if("03".equals(depart)){
			return "design";
		}else
		if("04".equals(depart)){
			return "plan";
		}
		if("06".equals(depart)){
			return "workerManager";
		}else{
			return "worker";
		}
		
	}
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		MotusWorker worker = null;
		worker = loginService.GetWorker(username);
		if("".equals(username)){
			this.addFieldError("username", "请输入用户名!!");
		}
		if(worker == null){
			this.addFieldError("username", "用户不存在，请重新输入用户名！！");			
		}
	}
	
}
