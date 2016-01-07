package com.tmazon.service.impl;

import com.tmazon.service.ShopApplyService;
import com.tmazon.util.BasicFactory;

import java.util.ArrayList;
import java.util.List;

import com.tmazon.dao.ShopApplyDao;
import com.tmazon.dao.UserDao;
import com.tmazon.domain.Shop;
import com.tmazon.domain.User;

public class ShopApplyServiceImpl implements ShopApplyService{
	
	private ShopApplyDao shopApplyDao = BasicFactory.getImpl(ShopApplyDao.class);
	private UserDao userDao = BasicFactory.getImpl(UserDao.class);
	public List<Shop> getApply() {
		// TODO Auto-generated method stub
		return shopApplyDao.getApply();
	}

	public boolean setStatus(int id, boolean isOk) {
		// TODO Auto-generated method stub
		return shopApplyDao.setStatus(id, isOk);
	}
	
	public List<User> searchForOwner(List<Shop> shopList)
	{
		
		List<User> userList = new ArrayList<User>();
		for(Shop shop : shopList)
		{
			userList.add(userDao.findById(shop.getShopId()));
		}
		return userList;
	}
}
