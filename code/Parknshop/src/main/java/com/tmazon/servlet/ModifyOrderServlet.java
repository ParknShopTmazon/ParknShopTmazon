package com.tmazon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.dao.OrderInfoDao;
import com.tmazon.domain.OrderInfo;
import com.tmazon.service.OrderInfoService;
import com.tmazon.service.OrderService;
import com.tmazon.util.BasicFactory;

public class ModifyOrderServlet extends HttpServlet {

	private OrderService orderService = BasicFactory.getImpl(OrderService.class);
	private OrderInfoService orderInfoService = BasicFactory.getImpl(OrderInfoService.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer orderId = 1;
		
//		OrderInfo orderInfo = new OrderInfo(orderId, null, null, null, null);
		List<OrderInfo> orderInfoList = orderService.getOrderInfo(orderId);
		for (int i = 0; i < orderInfoList.size(); i++) {
			if(orderInfoList.get(i).getStatus().equals("paid")){
				orderInfoList.get(i).setStatus("delivering");
				orderInfoService.modify(orderInfoList.get(i));
			}
		}
		req.getRequestDispatcher("/WEB-INF/shopowner/shop_order.jsp").forward(req, resp);
		return;
	}
}
