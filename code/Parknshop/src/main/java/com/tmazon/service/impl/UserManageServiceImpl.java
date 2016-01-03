package com.tmazon.service.impl;

import java.util.List;

import com.tmazon.dao.UserDao;
import com.tmazon.domain.User;
import com.tmazon.service.UserManageService;
import com.tmazon.util.BasicFactory;

public class UserManageServiceImpl implements UserManageService{
	
	private UserDao userDao = BasicFactory.getImpl(UserDao.class);
	
	public List<User> search(User user) {
		return userDao.search(user);
	}

	public boolean update(String name, String status) {
		return userDao.update(name, status);
	}

	public boolean delete(String name) {
		return userDao.delete(name);
	}
}
