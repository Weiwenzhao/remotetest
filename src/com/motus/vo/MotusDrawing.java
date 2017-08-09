package com.motus.vo;

import java.sql.Timestamp;

/**
 * MotusDrawing entity. @author MyEclipse Persistence Tools
 */

public class MotusDrawing implements java.io.Serializable {

	// Fields

	private Integer tid;
	private String pid;
	private String type;
	private String mode;
	private String name;
	private Timestamp creatTime;
	private Timestamp updateTime;
	private String creatBy;
	private String updateBy;
	private Integer num;
	private String image;

	// Constructors

	/** default constructor */
	public MotusDrawing() {
	}

	/** minimal constructor */
	public MotusDrawing(Integer tid, String pid, String type, String mode,
			String name, Integer num) {
		this.tid = tid;
		this.pid = pid;
		this.type = type;
		this.mode = mode;
		this.name = name;
		this.num = num;
	}

	/** full constructor */
	public MotusDrawing(Integer tid, String pid, String type, String mode,
			String name, Timestamp creatTime, Timestamp updateTime,
			String creatBy, String updateBy, Integer num, String image) {
		this.tid = tid;
		this.pid = pid;
		this.type = type;
		this.mode = mode;
		this.name = name;
		this.creatTime = creatTime;
		this.updateTime = updateTime;
		this.creatBy = creatBy;
		this.updateBy = updateBy;
		this.num = num;
		this.image = image;
	}

	// Property accessors

	public MotusDrawing(int tid, String pid, String type, String name, int num) {
		// TODO Auto-generated constructor stub
		this.tid = tid;
		this.pid = pid;
		this.type = type;
		this.name = name;
		this.num = num;
		
	}

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMode() {
		return this.mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreatBy() {
		return this.creatBy;
	}

	public void setCreatBy(String creatBy) {
		this.creatBy = creatBy;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}