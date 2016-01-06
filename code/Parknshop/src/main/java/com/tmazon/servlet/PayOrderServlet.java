package com.tmazon.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.Order;
import com.tmazon.domain.User;
import com.tmazon.service.OrderService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.ParseUtil;

import net.sf.json.JSONObject;

public class PayOrderServlet extends HttpServlet {
	
	private OrderService orderService = BasicFactory.getImpl(OrderService.class);

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(AttrName.SessionScope.USER);
		JSONObject jsonObject = new JSONObject();
		
		if (user == null) {
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "You're already offline!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		
		@SuppressWarnings("unchecked")
		Map<String, String[]> params = req.getParameterMap();
		
		String[] oidStrings = params.get("oid");
		if(oidStrings == null){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Cannot get order, please try it again!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		String orderString = oidStrings[0];
		if(orderString == null){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Cannot get order, please try it again!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		
		int orderId = ParseUtil.String2Integer(orderString, null);
		Order order = orderService.findById(orderId);
		if(order == null){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Cannot get order, please try it again!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		
		if(!order.getUserId().equals(user.getUserId())){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "You don't have this order!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		
		// TODO pay
		
		if(orderService.changeStatus(order, Order.STATUS_NORMAL)){
			jsonObject.put("result", true + "");
			jsonObject.put("errMsg", "");
		}else {
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Failed!");
		}
		
		resp.getWriter().write(jsonObject.toString());
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	
}
