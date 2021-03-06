package com.motus.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.motus.vo.MotusAttach;
import com.motus.vo.MotusDrawing;
import com.motus.vo.MotusProject;
import com.motus.vo.MotusWorker;
import com.motus.dao.HibernateSessionFactory;
public abstract class BaseDao {
	/**
	 * 添加数据
	 */
	@SuppressWarnings("finally")
	protected  boolean Add(Object object){
		Transaction tran = null ;
		boolean flg = false;
		//获取session
		Session session = HibernateSessionFactory.getSession();
		try{
			//开始事务
			tran = session.beginTransaction();
			//持久化操作
			session.save(object);
			//提交事务
			tran.commit();
			flg = true;
		}catch(Exception e){
			if(tran != null){
				tran.rollback();
			}
			e.printStackTrace();
			flg = false;
		}finally{
			session.close();
			return flg;
		}
	}
	/**
	 * 加载数据
	 * @param cla
	 * @param id
	 * @return
	 */
	 protected Object Get(Class cla,Serializable id){
		 Object object = null;

		 Session session = HibernateSessionFactory.getSession();
		try{
			object = session.get(cla, id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return object;
	 }
	 /**
	  * 
	  * @param cla
	  * @param id
	  * @return
	  */
	 protected MotusDrawing GetDrawing(Class cla,Serializable id){
		 MotusDrawing drawing = null;
		Session session = HibernateSessionFactory.getSession();
		try{
			drawing = (MotusDrawing) session.get(cla, id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return drawing;
	 }
	 /**
	  * 
	  */
	 protected List<MotusWorker> GetUser(String username){
		//获取session对象
		 Session session = HibernateSessionFactory.getSession();
		
		 //编写HQL语句
		 //String hql = "form MotusProject";
		 String hql = "select * from motus_worker where username ='" + username + "';";
		 
			 session.beginTransaction();
			//创建Query对象
			// Query query = session.createQuery(hql);
			 SQLQuery query = session.createSQLQuery(hql); //运行正常
			 List<MotusWorker> list = query.list();
		return  list;
	 }
	 /**
	  * 删除数据
	  * @param object
	  */
	 protected void Del(Object object){
		 	Transaction tran = null ;
			//获取session
			Session session = HibernateSessionFactory.getSession();
			try{
				//开始事务
				tran = session.beginTransaction();
				//持久化操作
				session.delete(object);
				//提交事务
				tran.commit();
			}catch(Exception e){
				if(tran != null){
					tran.rollback();
				}
				e.printStackTrace();
			}finally{
				session.close();
			}
	 }
	 /**
	  * 更新数据
	  * @param object
	  */
	 protected void Update(Object object){
		 	Transaction tran = null ;
			//获取session
			Session session = HibernateSessionFactory.getSession();
			try{
				//开始事务
				tran = session.beginTransaction();
				//持久化操作
				session.update(object);
				//提交事务
				tran.commit();
			}catch(Exception e){
				if(tran != null){
					tran.rollback();
				}
				e.printStackTrace();
			}finally{
				session.close();
			}
	 }
	 /**
	  * 获取登录部门信息
	  */
	 protected List<MotusProject> GetProjectItem(){
		 //获取session对象
		 Session session = HibernateSessionFactory.getSession();
		
		 //编写HQL语句
		 //String hql = "form MotusProject";
		 String hql = "select * from java.motus_project";
		 
			 session.beginTransaction();
			//创建Query对象
			// Query query = session.createQuery(hql);
			 SQLQuery query = session.createSQLQuery(hql); //运行正常
			 List<MotusProject> list = query.list();
		return list;
	 }
	 /**
	  * 查看对应项目图纸信息
	  */
	 protected List<MotusDrawing> GetDrawingItem(String pid){
		 //获取session对象
		 Session session = HibernateSessionFactory.getSession();
		
		 //编写HQL语句
		 //String hql = "form MotusProject";
		 String hql = "select * from motus_drawing where pid = '"+pid+"';";
		 
			 session.beginTransaction();
			//创建Query对象
			// Query query = session.createQuery(hql);
			 SQLQuery query = session.createSQLQuery(hql); //运行正常
			 //Query query = session.createSQLQuery(hql).addEntity(MotusDrawing.class);
			 //query.setParameter(0, pid);
			 List<MotusDrawing> list = query.list();
			 return list;
	 }
	 /**
	  * 查看对应项目附件
	  */
	 protected List<MotusAttach> getAttachment(String pid){
		 //获取session对象
		 Session session = HibernateSessionFactory.getSession();
		
		 //编写HQL语句
		 //String hql = "form MotusProject";
		 String hql = "select * from motus_attach where pid = '"+pid+"';";
		 
			 session.beginTransaction();
			//创建Query对象
			 SQLQuery query = session.createSQLQuery(hql); //运行正常
			 List<MotusAttach> list = query.list();
			 return list;
	 }
}
