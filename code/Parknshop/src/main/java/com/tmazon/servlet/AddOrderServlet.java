package com.tmazon.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.Order;
import com.tmazon.domain.OrderInfo;
import com.tmazon.domain.User;
import com.tmazon.service.OrderService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.ParseUtil;

import net.sf.json.JSONObject;

public class AddOrderServlet extends HttpServlet {
	
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
		Order order = new Order();
		
		Set<String> keys = params.keySet();
		int dataSize = (keys.size() - 1) /2;
		
		String addressString = params.get("address_id")[0];
		
		int addressId = ParseUtil.String2Integer(addressString, null);
		
		List<OrderInfo> orderInfos = new ArrayList<OrderInfo>();
		for(int i = 0; i < dataSize; i++){
			OrderInfo orderInfo = new OrderInfo();
			int productId = ParseUtil.String2Integer(params.get("options[" + i + "][product_id]")[0], null);
			int deliveryId = ParseUtil.String2Integer(params.get("options[" + i + "][delivery_id]")[0], null);
			orderInfo.setProductId(productId);
			orderInfo.setDeliveryId(deliveryId);
			orderInfos.add(orderInfo);
		}
		
		order.setAddressId(addressId);
		order.setUserId(user.getUserId());
		
		order = orderService.addOrder(order, orderInfos);
		
		if(order != null){
			jsonObject.put("result", true + "");
			jsonObject.put("errMsg", "");
			jsonObject.put("orderId", order.getOrderId());
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
