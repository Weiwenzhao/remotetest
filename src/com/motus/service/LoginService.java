package com.motus.service;

import com.motus.dao.LoginDaoImpl;
import com.motus.vo.MotusWorker;

public class LoginService {

	
		LoginDaoImpl login = new LoginDaoImpl();
		/**
		 * login 默认构造函数
		 */
		public LoginService() {
			// TODO Auto-generated constructor stub
			System.out.println("login默认构造函数");
		}
		/**
		 * 获取工人信息
		 * @return
		 */
		public MotusWorker GetWorker(String username){
			MotusWorker worker = new MotusWorker();
			worker = login.GetWorker(username);
			//int count = login.GetWorker(username);
			return worker;
		}
}
