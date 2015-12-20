package com.tmazon.domain;

public class User {

	public static final String ROLE_CUSTOMER = "customer";
	public static final String ROLE_SHOP_OWNER = "shop_owner";
	
	public static final String STATUS_NORMAL = "normal";
	public static final String STATUS_BLACK = "black";
	
	private Integer userId;
	private String name;
	private String password;
	private String role;
	private String status;
	
	public User() {
	}
	
	public User(Integer userId, String name, String password, String role,
			String status) {
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.role = role;
		this.status = status;
	}
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer id) {
		this.userId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
