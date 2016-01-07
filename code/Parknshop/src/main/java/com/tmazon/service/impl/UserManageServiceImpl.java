package com.tmazon.service.impl;

import java.util.List;

import com.tmazon.dao.UserDao;
import com.tmazon.domain.User;
import com.tmazon.service.UserManageService;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.Page;

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
	public Page<User> page(User user,int curPage , int next)
	{
		List<User> userList = search(user);
		Page<User> userPage = new Page<User>();
		userPage.page(userList,curPage,next);
		return userPage;
	}
	public Page<User> pageList(List<User> userList,int curPage , int next)
	{
		Page<User> userPage = new Page<User>();
		userPage.page(userList,curPage,next);
		return userPage;
	}
	
}
