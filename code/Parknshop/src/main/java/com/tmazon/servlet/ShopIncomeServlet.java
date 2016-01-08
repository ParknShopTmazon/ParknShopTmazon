package com.tmazon.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.domain.Delivery;
import com.tmazon.domain.Order;
import com.tmazon.domain.OrderInfo;
import com.tmazon.service.DeliveryService;
import com.tmazon.service.OrderService;
import com.tmazon.service.ProductService;
import com.tmazon.util.BasicFactory;

public class ShopIncomeServlet extends HttpServlet {

	private OrderService orderService = BasicFactory.getImpl(OrderService.class);
	private ProductService productService = BasicFactory.getImpl(ProductService.class);
	private DeliveryService deliveryService = BasicFactory.getImpl(DeliveryService.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer shopId =1;
		System.out.println(shopId);
		List<OrderInfo> orderInfos = orderService.getOrderInfosByshop(shopId);
		for (OrderInfo info :orderInfos) {
			info.setOrder(orderService.findById(info.getOrderId()));
			info.setProduct(productService.getProductById(info.getProductId()));
			info.setDelivery(deliveryService.select(new Delivery(info.getDeliveryId(), null, null, null)).get(0));
		}
		
//		Order order = orderService.findById(id)
		Double cost = 0.00;
		Integer quantity = 0;
		Double price = 0.00;
		
		String startTimeStr ="2015-12-01";
		String endTimeStr = "2015-12-31";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		Date startTime = null;
		Date endTime = null;
		try {
			startTime = dateFormat.parse(startTimeStr);
			endTime =dateFormat.parse(endTimeStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<OrderInfo> orderInfosBySearch = new ArrayList<OrderInfo>();
		for(OrderInfo info : orderInfos){
//			if(info.getStatus().equals(OrderInfo.STATUS_CONFIRM_RECEIPT)||info.getStatus().equals(OrderInfo.STATUS_DELETED)){
//				quantity = info.getQuantity();
//				price = info.getProduct().getDiscountPrice();
//				cost +=quantity * price;
//			}
			if(info.getDealTime().after(startTime)&&info.getDealTime().before(endTime)){
				orderInfosBySearch.add(info);
				quantity = info.getQuantity();
				price = info.getProduct().getDiscountPrice();
				cost += quantity*price;
			}
		}
		
		
		req.setAttribute("orderInfoList", orderInfosBySearch);
		req.getRequestDispatcher("/WEB-INF/shopowner/shop_income.jsp").forward(req, resp);
	}
}
