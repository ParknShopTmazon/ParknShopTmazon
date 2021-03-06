package com.tmazon.servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.tmazon.domain.Address;
import com.tmazon.domain.Delivery;
import com.tmazon.domain.Order;
import com.tmazon.domain.OrderInfo;
import com.tmazon.domain.Product;
import com.tmazon.domain.Shop;
import com.tmazon.domain.User;
import com.tmazon.service.AddressService;
import com.tmazon.service.DeliveryService;
import com.tmazon.service.OrderService;
import com.tmazon.service.ProductService;
import com.tmazon.service.ShopService;
import com.tmazon.service.UserService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.ParseUtil;

public class OrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private OrderService orderService = BasicFactory
			.getImpl(OrderService.class);
	private ProductService productService = BasicFactory
			.getImpl(ProductService.class);
	private DeliveryService deliveryService = BasicFactory
			.getImpl(DeliveryService.class);
	private ShopService shopService = BasicFactory.getImpl(ShopService.class);
	private AddressService addressService = BasicFactory
			.getImpl(AddressService.class);
	private UserService userService = BasicFactory.getImpl(UserService.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		User user = (User) req.getSession().getAttribute(
				AttrName.SessionScope.USER);
		if (user == null) {
			resp.sendRedirect("login");
			return;
		}

		// get parameters
		String type = req.getParameter("type");
		Integer orderId = ParseUtil.String2Integer(req.getParameter("oid"),
				null);
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
				} else if (type.equals("shopOwnerShow")) {
					shopOwnerShow(req, resp, orderId);
				}
			}
		}
	}

	private void shopOwnerShow(HttpServletRequest req,
			HttpServletResponse resp, Integer orderId) throws ServletException,
			IOException {

		User user = (User) req.getSession().getAttribute(
				AttrName.SessionScope.USER);

		Order order = orderService.findById(orderId);
		if (order == null) {
			return;
		}

		List<OrderInfo> orderInfos = orderService.getOrderInfo(orderId);
		order.setOrderInfos(orderInfos);
		
		boolean exist = false;
		for (int i = 0; i < orderInfos.size(); ++i) {

			OrderInfo orderInfo = orderInfos.get(i);
			
			Product product = productService.getProductById(orderInfo
					.getProductId());
			orderInfo.setProduct(product);

			Shop shop = shopService
					.findById(orderInfo.getProduct().getShopId());
			orderInfo.getProduct().setShop(shop);

			if (shop.getOwner().equals(user.getUserId())) {
				exist = true;
			} else {
				orderInfos.set(i, null);
				continue;
			}

			Delivery delivery = deliveryService.select(
					new Delivery(orderInfo.getDeliveryId(), null, null, null))
					.get(0);
			orderInfo.setDelivery(delivery);

			//
			orderInfo.setColor("");
			orderInfo.setSize("/");
			orderInfo.setProductUrl("productInfo?pid="
					+ orderInfo.getProductId());
		}
		
		if (!exist) {
			return;
		}

		Address address = addressService.findById(order.getAddressId());
		order.setAddress(address);
		
		order.setUserName(userService.findById(order.getUserId()).getName());

		JSONObject jsonObject = JSONObject.fromObject(order);
		resp.getWriter().write(jsonObject.toString());

	}

	private void comment(HttpServletRequest req, HttpServletResponse resp,
			Integer orderId) throws ServletException, IOException {

		show(req, resp, orderId);
	}

	private void show(HttpServletRequest req, HttpServletResponse resp,
			Integer orderId) throws ServletException, IOException {

		User user = (User) req.getSession().getAttribute(
				AttrName.SessionScope.USER);

		Order order = orderService.findById(orderId);
		if (order == null || !order.getUserId().equals(user.getUserId())) {
			return;
		}

		Address address = addressService.findById(order.getAddressId());
		order.setAddress(address);

		List<OrderInfo> orderInfos = orderService.getOrderInfo(orderId);
		order.setOrderInfos(orderInfos);
		for (OrderInfo orderInfo : orderInfos) {

			Product product = productService.getProductById(orderInfo
					.getProductId());
			orderInfo.setProduct(product);

			Delivery delivery = deliveryService.select(
					new Delivery(orderInfo.getDeliveryId(), null, null, null))
					.get(0);
			orderInfo.setDelivery(delivery);

			Shop shop = shopService
					.findById(orderInfo.getProduct().getShopId());
			orderInfo.getProduct().setShop(shop);

			//
			orderInfo.setColor("");
			orderInfo.setSize("/");
			orderInfo.setProductUrl("productInfo?pid="
					+ orderInfo.getProductId());
		}

		JSONObject jsonObject = JSONObject.fromObject(order);
		resp.getWriter().write(jsonObject.toString());
	}

	private void certain(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
	}

	private void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		User user = (User) req.getSession().getAttribute(
				AttrName.SessionScope.USER);

		List<Order> orders = orderService.getOrder(user, false);
		for (Order order : orders) {

			List<OrderInfo> orderInfos = orderService.getOrderInfo(order
					.getOrderId());
			order.setOrderInfos(orderInfos);
			for (OrderInfo orderInfo : orderInfos) {

				Product product = productService.getProductById(orderInfo
						.getProductId());
				orderInfo.setProduct(product);

				Delivery delivery = deliveryService.select(
						new Delivery(orderInfo.getDeliveryId(), null, null,
								null)).get(0);
				orderInfo.setDelivery(delivery);

				//
				orderInfo.setColor("");
				orderInfo.setSize("/");
				orderInfo.setProductUrl("productInfo?pid="
						+ orderInfo.getProductId());
			}
		}

		Collections.reverse(orders);

		JSONArray jsonArray = JSONArray.fromObject(orders);
		resp.getWriter().write(jsonArray.toString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
