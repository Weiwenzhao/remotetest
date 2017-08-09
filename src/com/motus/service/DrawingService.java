package com.motus.service;

import java.io.File;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;

import net.sf.json.JSONObject;

import com.motus.dao.DrawingDaoImpl;
import com.motus.dao.PartDaoImpl;
import com.motus.util.TwoDimensionCode;
import com.motus.vo.MotusDepart;
import com.motus.vo.MotusDrawing;

public class DrawingService {
	public DrawingService() {
		// TODO Auto-generated constructor stub
	
	}
	DrawingDaoImpl drawingDao = new DrawingDaoImpl();
	String msg = "操作成功！";
	/**
	 * 添加图纸，零件信息
	 * @param drawing
	 */
	public boolean addDrawing(MotusDrawing drawing){
		
		String partid  = String.valueOf(drawing.getPid());//项目编号
		
		//零件编号 = 项目编号+ 生产类型 +图纸编号 + 数量
		partid = partid + drawing.getType()+ drawing.getTid();
		int num = drawing.getNum(); //生产零件的数量
		
		//获取系统当前时间
		Timestamp now = new Timestamp(System.currentTimeMillis()); 
		drawing.setCreatTime(now);
		drawing.setUpdateTime(now);
		drawing.setMode(drawing.getPid() +drawing.getType() + drawing.getTid());
		PartDaoImpl partDao = new PartDaoImpl();
		boolean flag = false;
		 //图纸冲突检测
	     if(drawingDao.GetDrawing(drawing.getTid()) != null){
	    	 if(drawing.getMode().equals(drawingDao.GetDrawing(drawing.getTid()).getMode())){
	    		 return false;   //存在图纸是否存在
	    	 }
	    	 
	     }
	   
           
		flag = drawingDao.AddDrawing(drawing);//添加图纸
		if(flag){     //添加图纸信息
			for(int i=0;i<num;i++){
				MotusDepart part = new  MotusDepart();
				part.setId(partid + i);
				part.setName(drawing.getName()+i);
				flag = partDao.AddPart(part);        //通过图纸信息，添加零件信息
				}
			}	
		return flag;
	}
	/**
	 * 图纸单一性检测，判断图纸是否存在
	 * @param drawing
	 */
	public boolean SearchDrawing(int id){
		MotusDrawing drawingExist = null;
		drawingExist = drawingDao.GetDrawing(id);
		if(drawingExist != null){
			return true;   //图纸存在，返回存true 
		}else{
			return false; //图纸不存在，返回false
		}
	}
	/**
	 * 通过图纸编号获取图纸信息，包括图纸的地址
	 * @param id
	 * @return
	 */
	public MotusDrawing GetDrawing(int id){
		MotusDrawing drawing = new MotusDrawing();
		drawing = drawingDao.GetDrawing(id);
		return drawing;
	}
	/**
	 * 批量添加图纸信息
	 * @param data
	 * @param type 
	 * @param pid 
	 * @param type2 
	 * @param name 
	 */
	public String AddMotusDrawing(String data,String pid, String type) {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(pid);
		boolean flg_add= true;
		JSONObject jsonobject = JSONObject.fromObject(data);
		Iterator iterator = jsonobject.keys();
		while(iterator.hasNext() && flg_add){
		      String 	key = (String) iterator.next();
		      String    value = jsonobject.getString(key);
		      JSONObject object = JSONObject.fromObject(value);
		      MotusDrawing drawing = (MotusDrawing)JSONObject.toBean(object,MotusDrawing.class);//创建上传对象
		      
		      //String path = "D://drawing/" + drawing.getPid(); //图纸的存储路径 = 绝对路径 + 项目编号
		      String drawingId = pid + String.valueOf(drawing.getTid());
		      //drawing.setTid(Integer.valueOf(drawingId));
		      drawing.setPid(pid);
		      drawing.setType(type);
		      drawing.setMode(drawingId);
		      Timestamp now = new Timestamp(System.currentTimeMillis()); 
		      drawing.setCreatTime(now);
		      /** 
		       * 图纸冲突检测
		       */
		       if(drawingDao.GetDrawing(drawing.getTid()) != null){
		    	   MotusDrawing drawingExit = drawingDao.GetDrawing(drawing.getTid());
		    	   if(drawingExit.getMode().equals(drawing.getMode())){
		       			msg = "请重新确认图纸编号！";
		       			return   msg;
		      }
		       }
		       flg_add = drawingDao.AddDrawing(drawing);
				//File target = new File(path,drawingFileName);         //文件
//				String fileName = String.valueOf(motusDrawing.getTid())+".pdf";    //文件的存储名 = 图纸编号.pdf
//				File target = new File(path,fileName);         //文件
//				FileUtils.copyFile(drawing, target);
//				//motusDrawing.setMode(String.valueOf(motusDrawing.getTid()));
//				motusDrawing.setImage("/pdf/" + motusDrawing.getPid() +"/"+fileName);  //图纸的存储路径,其中pdf为tomcat对应的虚拟路径
//				flg = drawingService.addDrawing(motusDrawing);
//		      flg_add = drawingDao.AddDrawing(drawing);
		}
		return msg;
	}
	/**
	 * 获取所有图纸信息
	 * @return
	 */
	public List<MotusDrawing> GetDrawingItem(String id){
		List<MotusDrawing> list = drawingDao.GetDrawingItem( id);
		return list;
		
	}
}
