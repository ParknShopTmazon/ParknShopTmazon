package com.tmazon.service.impl;

import com.tmazon.dao.UserDao;
import com.tmazon.service.UserService;
import com.tmazon.util.BasicFactory;

public class UserServiceImpl implements UserService {

	private UserDao userDao = BasicFactory.getImpl(UserDao.class);
	
}
