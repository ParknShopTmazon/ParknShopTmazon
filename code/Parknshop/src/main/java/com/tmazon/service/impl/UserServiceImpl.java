package com.tmazon.service.impl;

import java.util.List;

import com.tmazon.dao.UserDao;
import com.tmazon.domain.User;
import com.tmazon.service.UserService;
import com.tmazon.util.BasicFactory;

public class UserServiceImpl implements UserService {

	private UserDao userDao = BasicFactory.getImpl(UserDao.class);

	public boolean register(User user) {
		return userDao.insert(user);
	}

	public boolean isUserExist(User user) {
		List<User> list = userDao.select(user);
		return list != null && !list.isEmpty();
	}

	public User findByName(String name) {
		return userDao.findByName(name);
	}
	
}
