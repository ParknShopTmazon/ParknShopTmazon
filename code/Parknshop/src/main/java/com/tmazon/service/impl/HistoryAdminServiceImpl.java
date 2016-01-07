package com.tmazon.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tmazon.dao.HistoryAdminDao;
import com.tmazon.dao.UserDao;
import com.tmazon.dao.OrderInfoDao;
import com.tmazon.dao.ProductDao;
import com.tmazon.dao.ShopDao;
import com.tmazon.domain.History;
import com.tmazon.domain.OrderInfo;
import com.tmazon.domain.Order;
import com.tmazon.domain.Product;
import com.tmazon.domain.Shop;
import com.tmazon.domain.User;
import com.tmazon.service.HistoryAdminService;
import com.tmazon.util.BasicFactory;

public class HistoryAdminServiceImpl implements HistoryAdminService{
	private HistoryAdminDao historyDao = BasicFactory.getImpl(HistoryAdminDao.class);
	private OrderInfoDao orderInfoDao = BasicFactory.getImpl(OrderInfoDao.class);
	private ProductDao productDao = BasicFactory.getImpl(ProductDao.class);
	private UserDao userDao = BasicFactory.getImpl(UserDao.class);
	private ShopDao shopDao = BasicFactory.getImpl(ShopDao.class);
	private List<History> list=new ArrayList<History>();
	public List<History> search(Date start, Date end) {
		List<Order> orders=historyDao.search(start, end);
		for(Order order:orders){
			List<OrderInfo> orderInfos=orderInfoDao.select(new OrderInfo(order.getOrderId(),null,null,null,null));
			OrderInfo orderInfo=orderInfos.get(0);
			Product product=productDao.findById(orderInfo.getProductId());
			List<User> users=userDao.select(new User(order.getUserId(),null,null,null,null));
			User user=users.get(0);
			List<Shop> shops=shopDao.select(new Shop(product.getShopId(),null,null,null,null,null));
			Shop shop=shops.get(0);
			History history=new History(orderInfo,order,shop,user,product);
			list.add(history);
		}
		return list;
	}

}
