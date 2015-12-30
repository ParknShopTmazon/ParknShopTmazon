package com.tmazon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.tmazon.domain.Delivery;
import com.tmazon.domain.Order;
import com.tmazon.domain.OrderInfo;
import com.tmazon.domain.Product;
import com.tmazon.domain.User;
import com.tmazon.service.DeliveryService;
import com.tmazon.service.OrderService;
import com.tmazon.service.ProductService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.ParseUtil;

public class OrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private OrderService orderService = BasicFactory.getImpl(OrderService.class);
	private ProductService productService = BasicFactory.getImpl(ProductService.class);
	private DeliveryService deliveryService = BasicFactory.getImpl(DeliveryService.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		User user = (User) req.getSession().getAttribute(AttrName.SessionScope.USER);
		if (user == null) {
			resp.sendRedirect("login");
			return;
		}
		
		// get parameters
		String type = req.getParameter("type");
		Integer orderId = ParseUtil.String2Integer(req.getParameter("oid"), null);
		if (type != null) {
			
			if (type.equals("list")) {
				list(req, resp);
			} else if (type.equals("certain")) {
				certain(req, resp);
			} else if (orderId != null) {
			
				if (type.equals("show")) {
					show(req, resp, orderId);
				} else if (type.equals("comment")) {
					comment(req, resp, orderId);
				}
			}
		}
	}
	
	private void comment(HttpServletRequest req, HttpServletResponse resp, Integer orderId) throws ServletException, IOException {
		
		show(req, resp, orderId);
	}

	private void show(HttpServletRequest req, HttpServletResponse resp, Integer orderId) throws ServletException, IOException {

		User user = (User) req.getSession().getAttribute(AttrName.SessionScope.USER);
		
		Order order = orderService.findById(orderId);
		if (order == null || !order.getUserId().equals(user.getUserId())) {
			return;
		}
		
		List<OrderInfo> orderInfos = orderService.getOrderInfo(orderId);
		order.setOrderInfos(orderInfos);
		for (OrderInfo orderInfo : orderInfos) {
			
			Product product = productService.getProductById(orderInfo.getProductId());
			orderInfo.setProduct(product);
			
			Delivery delivery = deliveryService.select(new Delivery(orderInfo.getDeliveryId(), null, null, null)).get(0);
			orderInfo.setDelivery(delivery);
			
			//
			orderInfo.setColor("");
			orderInfo.setSize("/");
			orderInfo.setProductUrl("productInfo?pid=" + orderInfo.getProductId());
		}
		
		JSONObject jsonObject = JSONObject.fromObject(order);
		resp.getWriter().write(jsonObject.toString());
	}

	private void certain(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = (User) req.getSession().getAttribute(AttrName.SessionScope.USER);
		
		List<Order> orders = orderService.getOrder(user);
		for (Order order : orders) {
			
			List<OrderInfo> orderInfos = orderService.getOrderInfo(order.getOrderId());
			order.setOrderInfos(orderInfos);
			for (OrderInfo orderInfo : orderInfos) {
				
				Product product = productService.getProductById(orderInfo.getProductId());
				orderInfo.setProduct(product);
				
				Delivery delivery = deliveryService.select(new Delivery(orderInfo.getDeliveryId(), null, null, null)).get(0);
				orderInfo.setDelivery(delivery);
				
				//
				orderInfo.setColor("");
				orderInfo.setSize("/");
				orderInfo.setProductUrl("productInfo?pid=" + orderInfo.getProductId());
			}
		}
		
		JSONArray jsonArray = JSONArray.fromObject(orders);
		resp.getWriter().write(jsonArray.toString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
