package com.tmazon.service.impl;

import java.util.Date;
import java.util.List;

import com.tmazon.dao.CartDao;
import com.tmazon.dao.OrderInfoDao;
import com.tmazon.dao.OrderDao;
import com.tmazon.domain.Cart;
import com.tmazon.domain.OrderInfo;
import com.tmazon.domain.Order;
import com.tmazon.domain.User;
import com.tmazon.service.OrderService;
import com.tmazon.util.BasicFactory;

public class OrderServiceImpl implements OrderService {

	private OrderDao ordersDao = BasicFactory.getImpl(OrderDao.class);
	private OrderInfoDao orderInfoDao = BasicFactory.getImpl(OrderInfoDao.class);
	private CartDao cartDao = BasicFactory.getImpl(CartDao.class);

	public List<Order> getOrder(User user, Boolean deleted) {
		return ordersDao.select(new Order(null, null, null, null, user.getUserId(), null), deleted);
	}

	public boolean addOrder(Order order, List<OrderInfo> orderInfos) {

		boolean flag = true;

		order.setOrderTime(new Date());
		order.setStatus(Order.STATUS_UNPAID);
		order.setPayType(Order.PAY_TYPE_ONLINE_PAYMENT);

		order = ordersDao.insert(order);

		for (OrderInfo orderInfo : orderInfos) {
			orderInfo.setOrderId(order.getOrderId());
			Cart cart = cartDao.findByPKId(order.getUserId(), orderInfo.getProductId());
			orderInfo.setQuantity(cart.getQuantity());
			if (orderInfoDao.insert(orderInfo)) {
				cartDao.delete(new Cart(order.getUserId(), orderInfo.getProductId(), null));
			} else {
				flag = false;
			}
		}

		return flag;

	}

	public List<OrderInfo> getOrderInfo(Integer orderId) {
		return orderInfoDao.select(new OrderInfo(orderId, null, null, null));
	}

	public Order findById(Integer id) {
		List<Order> orders = ordersDao.select(new Order(id, null, null, null, null, null), null);
		return (orders != null && !orders.isEmpty()) ? orders.get(0) : null;
	}

	public boolean changeStatus(Order order, String newStatus) {
		order.setStatus(newStatus);
		return ordersDao.update(order);
	}

	public List<OrderInfo> getOrderInfosByshop(Integer shopId) {
		return orderInfoDao.getOrderInfosByshop(shopId);
	}

}
