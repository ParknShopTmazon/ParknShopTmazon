package com.tmazon.service;

import java.util.List;

import com.tmazon.domain.User;

public interface UserService {

	public boolean register(User user);
	
	public boolean isUserExist(User user);
	
	public User findByName(String name);
	
	public void getFriends(User user);
	
	public boolean addFriend(User user, User friend);
	
	public List<User> searchUsersByName(String name);
}
