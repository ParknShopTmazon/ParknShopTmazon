package com.tmazon.dao;

import java.util.List;

import com.tmazon.domain.Order;
import com.tmazon.domain.OrderInfo;


public interface OrderInfoDao {

	public List<OrderInfo> select(OrderInfo orderInfo);
	
	public List<Order> getOrderByShopId(Integer shopId);
	
	public List<OrderInfo> getOrderInfosByshop(Integer shopId);
	
	public boolean insert(OrderInfo orderInfo);
	
	public boolean update(OrderInfo orderInfo);
	
	public boolean delete(OrderInfo orderInfo);
	
	public boolean changeStatus(OrderInfo orderInfo);
	
	public boolean updateStatus(OrderInfo orderInfo);
	
	public boolean isBought(Integer userId, Integer productId);
	
}
