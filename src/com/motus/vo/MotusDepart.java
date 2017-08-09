package com.motus.vo;

/**
 * MotusDepart entity. @author MyEclipse Persistence Tools
 */

public class MotusDepart implements java.io.Serializable {

	// Fields

	private String id;
	private String name;

	// Constructors

	/** default constructor */
	public MotusDepart() {
	}

	/** minimal constructor */
	public MotusDepart(String id) {
		this.id = id;
	}

	/** full constructor */
	public MotusDepart(String id, String name) {
		this.id = id;
		this.name = name;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}