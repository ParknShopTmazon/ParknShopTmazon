package com.tmazon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.tmazon.domain.Order;
import com.tmazon.domain.User;
import com.tmazon.service.OrderService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.ParseUtil;

public class DeleteOrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private OrderService orderService = BasicFactory.getImpl(OrderService.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		User user = (User) req.getSession().getAttribute(AttrName.SessionScope.USER);
		if (user == null) {
			resp.sendRedirect("login");
			return;
		}
		
		// check parameter
		Integer orderId = ParseUtil.String2Integer(req.getParameter("oid"), null);
		if (orderId == null) {
			return;
		}
		
		// check if order belongs to user
		Order order = orderService.findById(orderId);
		if (!order.getUserId().equals(user.getUserId())) {
			return;
		}
		
		// check order status
		if (!Order.STATUS_NORMAL.equals(order.getStatus())) {
			return;
		}
		
		// TODO check order info status
		
		// delete order
		boolean result = orderService.changeStatus(order, Order.STATUS_DELETED);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", result);
		resp.getWriter().write(jsonObject.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
