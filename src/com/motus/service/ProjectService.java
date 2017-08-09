package com.motus.service;

import java.sql.Timestamp;
import java.util.List;

import com.motus.dao.ProjectDaoImpl;
import com.motus.vo.MotusAttach;
import com.motus.vo.MotusDrawing;
import com.motus.vo.MotusProject;

public class ProjectService {
	
	ProjectDaoImpl projectDao = new ProjectDaoImpl();
	/**
	 * 项目信息逻辑处理类
	 * @param project
	 */
	public boolean addProject(MotusProject project) {
		// TODO Auto-generated method stub
		
		return projectDao.AddProject(project);
	}
	
	public MotusProject GetProject(String id){
		MotusProject project = new MotusProject();
		project = projectDao.GetProject(id);
		return project;
		
	}
	/**
	 * 项目单一性检测，判断项目是否存在
	 * @param drawing
	 */
	public boolean SearchProject(String id){
		MotusProject projectExist = null;
		projectExist = projectDao.GetProject(id);
		if(projectExist != null){
			return true;   //图纸存在，返回存true 
		}else{
			return false; //图纸不存在，返回false
		}
	}
	/**
	 * 获取所有项目信息
	 * @return
	 */
	public List<MotusProject> GetProjectItem(){
		List<MotusProject> list = projectDao.GetProjectItem();
		return list;
		
	}
	/**
	 * 获取项目对应的附件信息
	 * @param id
	 * @return
	 */
	public List<MotusAttach> getAttachment(String id) {
		List<MotusAttach> list = projectDao.getAttachment(id);
		return list;
	}

	public boolean addAtt(MotusAttach att) {
		// TODO Auto-generated method stub
		//获取系统当前时间
		Timestamp now = new Timestamp(System.currentTimeMillis()); 
		att.setCreatetime(now);
		att.setUpdatetime(now);
		att.setVersion("1.1");
		return projectDao.AddAtt(att);
	}
	/**
	 * 获取项目信息
	 * @return
	 */
	public MotusProject GetProjectInfo(String id) {
		// TODO Auto-generated method stub
		
		return projectDao.GetProject(id);
	}
	/**
	 * 删除附件
	 * @param attid
	 */
	public void DelAtt(int attid) {
		// TODO Auto-generated method stub
		projectDao.DelAtt(attid);
	}
}
