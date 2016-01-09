package com.tmazon.service.impl;

import java.util.Date;
import java.util.List;

import com.tmazon.dao.CartDao;
import com.tmazon.dao.OrderInfoDao;
import com.tmazon.dao.ProductDao;
import com.tmazon.dao.ShopDao;
import com.tmazon.dao.OrderDao;
import com.tmazon.domain.Cart;
import com.tmazon.domain.OrderInfo;
import com.tmazon.domain.Product;
import com.tmazon.domain.Order;
import com.tmazon.domain.User;
import com.tmazon.service.OrderService;
import com.tmazon.util.BasicFactory;

public class OrderServiceImpl implements OrderService {

	private OrderDao ordersDao = BasicFactory.getImpl(OrderDao.class);
	private ProductDao productDao = BasicFactory.getImpl(ProductDao.class);
	
	private OrderInfoDao orderInfoDao = BasicFactory
			.getImpl(OrderInfoDao.class);
	private CartDao cartDao = BasicFactory.getImpl(CartDao.class);

	public List<Order> getOrder(User user, Boolean deleted) {
		return ordersDao.select(
				new Order(null, null, null, null, user.getUserId(), null),
				deleted);
	}

	public Order addOrder(Order order, List<OrderInfo> orderInfos) {

		boolean flag = true;

		order.setOrderTime(new Date());
		order.setStatus(Order.STATUS_NORMAL);
		order.setPayType(Order.PAY_TYPE_ONLINE_PAYMENT);

		order = ordersDao.insert(order);

		for (OrderInfo orderInfo : orderInfos) {
			orderInfo.setOrderId(order.getOrderId());
			Cart cart = cartDao.findByPKId(order.getUserId(),
					orderInfo.getProductId());
			Product product = productDao.findById(orderInfo.getProductId());
			int stockNum = product.getStockNum();
			int quantity = cart.getQuantity();
			if(stockNum < quantity){
				cart.setQuantity(stockNum);
			}
			orderInfo.setQuantity(cart.getQuantity());
			orderInfo.setStatus(OrderInfo.STATUS_UNPAID);
			if (orderInfo.getQuantity() != 0) {
				if(orderInfoDao.insert(orderInfo)){
					int soldNum = product.getSoldNum() + 0;
					product.setStockNum(product.getStockNum() - cart.getQuantity());
					product.setSoldNum(soldNum + cart.getQuantity());
					productDao.updateStockNum(product);
					cartDao.delete(new Cart(order.getUserId(), orderInfo
							.getProductId(), null));
				}else {
					flag = false;
				}
			}
		}

		if (flag) {
			return order;
		} else {
			return null;
		}

	}

	public List<OrderInfo> getOrderInfo(Integer orderId) {
		return orderInfoDao.select(new OrderInfo(orderId, null, null, null,
				null));
	}

	public Order findById(Integer id) {
		List<Order> orders = ordersDao.select(new Order(id, null, null, null,
				null, null), null);
		return (orders != null && !orders.isEmpty()) ? orders.get(0) : null;
	}

	public boolean changeStatus(Order order, String newStatus) {
		order.setStatus(newStatus);
		return ordersDao.update(order);
	}

	public List<OrderInfo> getOrderInfosByshop(Integer shopId) {
		return orderInfoDao.getOrderInfosByshop(shopId);
	}

	public boolean changeOrderinfoStatus(OrderInfo orderInfo, String newStatus) {
		orderInfo.setStatus(newStatus);
		return orderInfoDao.updateStatus(orderInfo);
	}

	public OrderInfo getOrderInfoByPK(Integer orderId, Integer productId) {
		List<OrderInfo> orderInfos = orderInfoDao.select(new OrderInfo(orderId, null, null, productId, null));
		if(orderInfos.isEmpty()){
			return null;
		}else {
			return orderInfos.get(0);
		}
	}
	
	public boolean changeStatus(OrderInfo orderInfo, String newStatus,
			String role) {
		
		boolean canChange = false;
		
		if (User.ROLE_SHOP_OWNER.equals(role)) {
			if (OrderInfo.STATUS_ON_DELIVERY.equals(newStatus)
					&& OrderInfo.STATUS_PAID.equals(orderInfo.getStatus())
					|| OrderInfo.STATUS_DELETED.equals(newStatus)
					&& OrderInfo.STATUS_UNPAID.equals(orderInfo.getStatus())) {
				canChange = true;
			}
		} else if (User.ROLE_CUSTOMER.equals(role)) {
			if (OrderInfo.STATUS_CONFIRM_RECEIPT.equals(newStatus)
					&& OrderInfo.STATUS_ON_DELIVERY.equals(orderInfo
							.getStatus())) {
				canChange = true;
			}
		} else if (User.ROLE_ADMIN.equals(role)) {
			if (OrderInfo.STATUS_PAID.equals(newStatus)
					&& OrderInfo.STATUS_UNPAID.equals(orderInfo.getStatus())) {
				canChange = true;
			}
		}

		orderInfo.setStatus(newStatus);
		return canChange? orderInfoDao.updateStatus(orderInfo) : false;
	}
	
	public OrderInfo getOrderInfo(Integer orderId, Integer productId) {
		List<OrderInfo> list = orderInfoDao.select(new OrderInfo(orderId, null, null, productId, null));
		return (list != null && !list.isEmpty())? list.get(0) : null;
	}

	public boolean isBought(Integer userId, Integer productId) {
		return orderInfoDao.isBought(userId, productId);
	}

	public  boolean modify(OrderInfo orderInfo){

			boolean isSuccess = orderInfoDao.update(orderInfo);
			return isSuccess;
	}
}
