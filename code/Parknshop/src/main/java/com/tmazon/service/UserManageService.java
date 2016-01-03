package com.tmazon.service;

import java.util.List;

import com.tmazon.domain.User;

public interface UserManageService {
	
	public List<User> search(User user);
	
	public boolean update(String name,String status);
	
	public boolean delete(String name);
}
