package com.newlecture.web.entity;

public class Role {
	
	private String id;
	private String description;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(String id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", description=" + description + "]";
	}
	
	

}
