package com.tmazon.service;

import com.tmazon.domain.User;

public interface UserService {

	public boolean register(User user);
	
	public boolean isUserExist(User user);
	
	public User findByName(String name);
}
