package com.tmazon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.tmazon.domain.Order;
import com.tmazon.domain.OrderInfo;
import com.tmazon.domain.Product;
import com.tmazon.domain.Shop;
import com.tmazon.domain.User;
import com.tmazon.service.OrderService;
import com.tmazon.service.ProductService;
import com.tmazon.service.ShopService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.ParseUtil;

public class ChangeOrderInfoStatusServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProductService productService = BasicFactory.getImpl(ProductService.class);
	private OrderService orderService = BasicFactory.getImpl(OrderService.class);
	private ShopService shopService = BasicFactory.getImpl(ShopService.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// check if login
		User user = (User) req.getSession().getAttribute(AttrName.SessionScope.USER);
		if (user == null) {
			resp.sendRedirect("login");
			return;
		}
		
		// check parameter "oid" "pid" "newStatus"
		Integer orderId = ParseUtil.String2Integer(req.getParameter("oid"), null);
		Integer productId = ParseUtil.String2Integer(req.getParameter("pid"), null);
			String newStatus = req.getParameter("newStatus");
		if (orderId == null || productId == null || newStatus == null) {
			resp.sendRedirect("index");
			return;
		}
		
		// check if orderInfo exists
		OrderInfo orderInfo = orderService.getOrderInfo(orderId, productId);
		if (orderInfo == null) {
			resp.sendRedirect("index");
			return;
		}
		
		// check if user sell product
		if (user.getRole().equals(User.ROLE_SHOP_OWNER)) {
			Product product = productService.getProductById(orderInfo.getProductId());
			Shop shop = shopService.findById(product.getShopId());
			if (shop.getOwner().equals(user.getUserId())) {
				boolean result = orderService.changeStatus(orderInfo, newStatus, User.ROLE_SHOP_OWNER);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("success", result);
				resp.getWriter().write(jsonObject.toString());
				return;
			}
		}
		
		// check if user buy product
		Order order = orderService.findById(orderInfo.getOrderId());
		if (order.getUserId().equals(user.getUserId())) {
			boolean result = orderService.changeStatus(orderInfo, newStatus, User.ROLE_CUSTOMER);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("success", result);
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		
		resp.sendRedirect("index");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
