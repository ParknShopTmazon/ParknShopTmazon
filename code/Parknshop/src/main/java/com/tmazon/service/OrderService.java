package com.tmazon.service;

import java.util.List;

import com.tmazon.domain.OrderInfo;
import com.tmazon.domain.Order;
import com.tmazon.domain.User;

public interface OrderService {

	public List<Order> getOrder(User user, Boolean deleted);
	
	public List<OrderInfo> getOrderInfo(Integer orderId);
	
	public OrderInfo getOrderInfo(Integer orderId, Integer productId);
	
	public List<OrderInfo> getOrderInfosByshop(Integer shopId);
	
	public Order addOrder(Order order, List<OrderInfo> orderInfos);
	
	public Order findById(Integer id);
	
	public boolean changeStatus(Order order, String newStatus);
	
	public boolean changeOrderinfoStatus(OrderInfo orderInfo, String newStatus);
	
	public OrderInfo getOrderInfoByPK(Integer orderId, Integer productId);
	
	public boolean changeStatus(OrderInfo orderInfo, String newStatus, String role);
	
}
