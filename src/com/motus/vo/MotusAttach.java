package com.motus.vo;

import java.sql.Timestamp;

/**
 * MotusAttach entity. @author MyEclipse Persistence Tools
 */

public class MotusAttach implements java.io.Serializable {

	// Fields

	private Integer aid;
	private String pid;
	private String aname;
	private Timestamp createtime;
	private String createby;
	private Timestamp updatetime;
	private String updateby;
	private String path;
	private String comment;
	private String reverse1;
	private String reverse2;
	private String version;

	// Constructors

	/** default constructor */
	public MotusAttach() {
	}

	/** minimal constructor */
	public MotusAttach(String pid) {
		this.pid = pid;
	}

	/** full constructor */
	public MotusAttach(String pid, String aname, Timestamp createtime,
			String createby, Timestamp updatetime, String updateby,
			String path, String comment, String reverse1, String reverse2,
			String version) {
		this.pid = pid;
		this.aname = aname;
		this.createtime = createtime;
		this.createby = createby;
		this.updatetime = updatetime;
		this.updateby = updateby;
		this.path = path;
		this.comment = comment;
		this.reverse1 = reverse1;
		this.reverse2 = reverse2;
		this.version = version;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getCreateby() {
		return this.createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getUpdateby() {
		return this.updateby;
	}

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getReverse1() {
		return this.reverse1;
	}

	public void setReverse1(String reverse1) {
		this.reverse1 = reverse1;
	}

	public String getReverse2() {
		return this.reverse2;
	}

	public void setReverse2(String reverse2) {
		this.reverse2 = reverse2;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}