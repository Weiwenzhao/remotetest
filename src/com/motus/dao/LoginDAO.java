package com.motus.dao;

import com.motus.vo.MotusWorker;

public interface LoginDAO {
	public MotusWorker GetWorker(String username);
	
}
