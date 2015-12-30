package com.tmazon.service;

import java.util.List;

import com.tmazon.domain.OrderInfo;
import com.tmazon.domain.Order;
import com.tmazon.domain.User;

public interface OrderService {

	public List<Order> getOrder(User user);
	
	public List<OrderInfo> getOrderInfo(Integer orderId);
	
	public boolean addOrder(Order order, List<OrderInfo> orderInfos);
	
	public Order findById(Integer id);
	
}
