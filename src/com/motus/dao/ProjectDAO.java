package com.motus.dao;

import java.util.List;

import com.motus.vo.MotusAttach;
import com.motus.vo.MotusProject;

public interface ProjectDAO {
	public boolean AddProject(MotusProject project);
	public void DelProject(MotusProject project);
	public MotusProject GetProject(String id);
	public void UpdateProject(MotusProject project);
	public List GetProjectItem();
	public List getAttachment(String id);
	public boolean AddAtt(MotusAttach att);
}
