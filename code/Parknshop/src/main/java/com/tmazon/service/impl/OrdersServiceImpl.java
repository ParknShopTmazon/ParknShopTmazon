package com.tmazon.service.impl;

import java.util.Date;
import java.util.List;

import com.tmazon.dao.CartDao;
import com.tmazon.dao.OrderInfoDao;
import com.tmazon.dao.OrdersDao;
import com.tmazon.domain.Cart;
import com.tmazon.domain.OrderInfo;
import com.tmazon.domain.Orders;
import com.tmazon.domain.User;
import com.tmazon.service.OrdersService;
import com.tmazon.util.BasicFactory;

public class OrdersServiceImpl implements OrdersService {

	private OrdersDao ordersDao = BasicFactory.getImpl(OrdersDao.class);
	private OrderInfoDao orderInfoDao = BasicFactory.getImpl(OrderInfoDao.class);
	private CartDao cartDao = BasicFactory.getImpl(CartDao.class);

	public List<Orders> getOrder(User user) {
		return ordersDao.select(new Orders(null, null, null, null, user.getUserId(), null));
	}

	public boolean addOrder(Orders order, List<OrderInfo> orderInfos) {

		boolean flag = true;

		order.setOrderTime(new Date());
		order.setStatus(Orders.STATUS_UNPAID);

		order = ordersDao.insert(order);

		for (OrderInfo orderInfo : orderInfos) {
			orderInfo.setOrderId(order.getOrderId());
			if (orderInfoDao.insert(orderInfo)) {
				cartDao.delete(new Cart(order.getUserId(), orderInfo.getProductId(), null));
			} else {
				flag = false;
			}
		}

		return flag;

	}

	public List<OrderInfo> getOrderInfo(Integer orderId) {
		return orderInfoDao.select(new OrderInfo(orderId, null, null, null, null));
	}

}
