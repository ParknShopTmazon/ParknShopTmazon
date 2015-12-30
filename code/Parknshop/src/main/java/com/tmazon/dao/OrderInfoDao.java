package com.tmazon.dao;

import java.util.List;

import com.tmazon.domain.OrderInfo;


public interface OrderInfoDao {

	public List<OrderInfo> select(OrderInfo orderInfo);
	
	public boolean insert(OrderInfo orderInfo);
	
	public boolean update(OrderInfo orderInfo);
	
	public boolean delete(OrderInfo orderInfo);
	
}
