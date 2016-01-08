package com.tmazon.domain;

import java.util.List;

public class User {

	public static final String ROLE_CUSTOMER = "customer";
	public static final String ROLE_SHOP_OWNER = "shop_owner";
	public static final String ROLE_ADMIN = "admin";
	
	public static final String STATUS_NORMAL = "normal";
	public static final String STATUS_BLACK = "black";
	
	/**
	 * min characters of user name and password
	 */
	public static final int CHAR_MIN = 6;
	/**
	 * max characters of user name and password
	 */
	public static final int CHAR_MAX = 20;
	
	private Integer userId;
	private String name;
	private String password;
	private String role;
	private String status;
	private List<User> friends;
	
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
	
	public boolean isNamePasswordValid() {
		return (name != null && password != null && name.length() >= CHAR_MIN && name.length() <= CHAR_MAX
				&& password.length() >= CHAR_MIN && password.length() <= CHAR_MAX);
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	
	@Override
	public int hashCode() {
		return userId == null ? -1 : userId.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof User) {
			User other = (User) obj;
			if (userId != null) {
				return userId.equals(other.userId);
			}
		}
		return false;
	}
	
}
