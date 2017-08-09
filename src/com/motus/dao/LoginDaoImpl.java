package com.motus.dao;

import com.motus.vo.MotusWorker;

public class LoginDaoImpl extends BaseDao implements LoginDAO {
	
	/**
	 * 获取登录用户信息
	 */
	public MotusWorker GetWorker(String username) {
		// TODO Auto-generated method stub
		return (MotusWorker) super.Get(MotusWorker.class, username);
		//return  (MotusWorker) super.GetUser(username);
	}

}
