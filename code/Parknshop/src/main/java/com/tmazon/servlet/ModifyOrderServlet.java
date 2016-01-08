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
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
		String orderIdStr = req.getParameter("orderId");
		System.out.println("orderInfo="+orderIdStr);
		Integer orderId = -1;
		
		try {
			orderId=Integer.parseInt(orderIdStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		if(orderId == -1){
			resp.sendRedirect("shoporder");
		}
		
//		OrderInfo orderInfo = new OrderInfo(orderId, null, null, null, null);
		List<OrderInfo> orderInfoList = orderService.getOrderInfo(orderId);
		for (int i = 0; i < orderInfoList.size(); i++) {
			if(orderInfoList.get(i).getStatus().equals("paid")){
				orderInfoList.get(i).setStatus("delivering");
				orderService.modify(orderInfoList.get(i));
			}
			
		}
		resp.sendRedirect("shoporder");
		return;
	}
	
		
		
}
