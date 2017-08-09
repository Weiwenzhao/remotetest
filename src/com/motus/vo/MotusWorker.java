package com.motus.vo;

import java.sql.Timestamp;

/**
 * MotusWorker entity. @author MyEclipse Persistence Tools
 */

public class MotusWorker implements java.io.Serializable {

	// Fields

	private String username;
	private String name;
	private String depart;
	private Timestamp lastlogintime;

	// Constructors

	/** default constructor */
	public MotusWorker() {
	}

	/** minimal constructor */
	public MotusWorker(String username) {
		this.username = username;
	}

	/** full constructor */
	public MotusWorker(String username, String name, String depart,
			Timestamp lastlogintime) {
		this.username = username;
		this.name = name;
		this.depart = depart;
		this.lastlogintime = lastlogintime;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepart() {
		return this.depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public Timestamp getLastlogintime() {
		return this.lastlogintime;
	}

	public void setLastlogintime(Timestamp lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

}