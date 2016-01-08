package com.tmazon.service.impl;

import com.tmazon.dao.OrderInfoDao;
import com.tmazon.domain.OrderInfo;
import com.tmazon.service.OrderInfoService;
import com.tmazon.util.BasicFactory;

public class OrderInfoServiceImpl implements OrderInfoService{

	private OrderInfoDao ordersInfoDao = BasicFactory.getImpl(OrderInfoDao.class);
	public boolean modify(OrderInfo orderInfo) {

		boolean isSuccess = ordersInfoDao.update(orderInfo);
		return isSuccess;
	}

	
}
