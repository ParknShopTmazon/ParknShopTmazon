package com.tmazon.service.impl;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.tmazon.dao.HistoryAdminDao;
import com.tmazon.dao.OrderDao;
import com.tmazon.dao.UserDao;
import com.tmazon.dao.OrderInfoDao;
import com.tmazon.dao.ProductDao;
import com.tmazon.dao.RateDao;
import com.tmazon.dao.ShopDao;
import com.tmazon.domain.History;
import com.tmazon.domain.OrderInfo;
import com.tmazon.domain.Order;
import com.tmazon.domain.Product;
import com.tmazon.domain.Shop;
import com.tmazon.domain.User;
import com.tmazon.service.HistoryAdminService;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.Page;
import com.tmazon.util.RateUtil;

public class HistoryAdminServiceImpl implements HistoryAdminService{
	private HistoryAdminDao historyAdminDao = BasicFactory.getImpl(HistoryAdminDao.class);
	private OrderInfoDao orderInfoDao = BasicFactory.getImpl(OrderInfoDao.class);
	private ProductDao productDao = BasicFactory.getImpl(ProductDao.class);
	private UserDao userDao = BasicFactory.getImpl(UserDao.class);
	private ShopDao shopDao = BasicFactory.getImpl(ShopDao.class);
	private OrderDao orderDao = BasicFactory.getImpl(OrderDao.class);
	private RateDao rateDao = BasicFactory.getImpl(RateDao.class);
	public List<History> search(Date start, Date end) {
		List<History> list=new ArrayList<History>();
		List<OrderInfo> orderInfoList=historyAdminDao.search(start, end);
		for(OrderInfo orderInfo : orderInfoList){
			
			Order order = orderDao.findByOrderId(orderInfo.getOrderId());
			User user=userDao.findById(order.getUserId());
			Product product=productDao.findById(orderInfo.getProductId());
			Shop shop = shopDao.findById(product.getShopId());
			History history=new History(orderInfo,shop,user,product);
			list.add(history);
		}
		return list;
	}
	public Page<History> page(List<History> historyList,int curPage,int next)
	{
		Page<History> historyPage = new Page<History>();
		historyPage.page(historyList,curPage,next);
		return historyPage;
	}
	public double getIncome(List<History> historyList)
	{
		double costSum = 0.0;
		for(History history : historyList)
		{
			costSum += (history.getCost()*history.getRate());
		}
		return costSum;
	}
}
