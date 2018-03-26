package com.ribbon.model;

public class User {

	private String name;
	private String email;
	private Integer userId;
	
	
	
	public User(String name, String email, Integer userId) {
		super();
		this.name = name;
		this.email = email;
		this.userId = userId;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", userId=" + userId + "]";
	}
	

}
