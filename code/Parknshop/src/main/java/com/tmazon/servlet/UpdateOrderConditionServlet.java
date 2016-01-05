package com.tmazon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.domain.User;
import com.tmazon.service.OrderService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;

public class UpdateOrderConditionServlet extends HttpServlet {

	private OrderService orderService = BasicFactory.getImpl(OrderService.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = (User) req.getSession().getAttribute(AttrName.SessionScope.USER);
		if (user == null) {
			resp.sendRedirect("login");
			return;
		}
		
		String shopId=(String) req.getSession().getAttribute(AttrName.SessionScope.SHOPID);
		if(shopId == null){
			resp.sendRedirect("myshop");
			return;
		}
		
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}
