package com.tmazon.service;

import java.util.List;

import com.tmazon.domain.OrderInfo;
import com.tmazon.domain.Orders;
import com.tmazon.domain.User;

public interface OrdersService {

	public List<Orders> getOrder(User user);
	
	public List<OrderInfo> getOrderInfo(Integer orderId);
	
	public boolean addOrder(Orders order, List<OrderInfo> orderInfos);
	
}
