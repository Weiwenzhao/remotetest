package com.motus.dao;

import java.util.List;

import com.motus.vo.MotusAttach;
import com.motus.vo.MotusProject;

public class ProjectDaoImpl extends BaseDao implements ProjectDAO {

	public boolean AddProject(MotusProject project) {
		// TODO Auto-generated method stub
		return super.Add(project);
	}

	public void DelProject(MotusProject project) {
		// TODO Auto-generated method stub
		super.Del(project);
	}

	public MotusProject GetProject(String id) {
		// TODO Auto-generated method stub
		return (MotusProject) super.Get(MotusProject.class, id);
	}

	public void UpdateProject(MotusProject project) {
		// TODO Auto-generated method stub
		super.Update(project);
	}
	public List<MotusProject> GetProjectItem() {
		// TODO Auto-generated method stub
		return super.GetProjectItem();
	}
	public List<MotusAttach> getAttachment(String id) {
		// TODO Auto-generated method stub
		return super.getAttachment(id);
	}

	public boolean AddAtt(MotusAttach att) {
		// TODO Auto-generated method stub
		return super.Add(att);
	}

	public void DelAtt(int attid) {
		// TODO Auto-generated method stub'
		MotusAttach at = (MotusAttach) super.Get(MotusAttach.class, attid);
		if(at != null){
			super.Del(at);
		}
		
	}
}
