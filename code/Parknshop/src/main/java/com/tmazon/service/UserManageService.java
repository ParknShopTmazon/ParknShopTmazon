package com.tmazon.service;

import java.util.List;

import com.tmazon.domain.User;
import com.tmazon.util.Page;

public interface UserManageService {
	
	public List<User> search(User user);
	
	public boolean update(String name,String status);
	
	public boolean delete(String name);
	
	public Page<User> page(User user,int curPage , int next);
}
