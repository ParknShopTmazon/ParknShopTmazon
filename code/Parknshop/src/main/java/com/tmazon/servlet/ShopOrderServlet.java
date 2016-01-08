package com.tmazon.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.domain.Delivery;
import com.tmazon.domain.Order;
import com.tmazon.domain.OrderInfo;
import com.tmazon.domain.Product;
import com.tmazon.domain.Shop;
import com.tmazon.service.DeliveryService;
import com.tmazon.service.OrderService;
import com.tmazon.service.ProductService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.DaoUtil;

public class ShopOrderServlet extends HttpServlet {

	private OrderService orderService = BasicFactory.getImpl(OrderService.class);
	private ProductService productService = BasicFactory.getImpl(ProductService.class);
	private DeliveryService deliveryService = BasicFactory.getImpl(DeliveryService.class);
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String shopIdStr=(String) req.getSession().getAttribute(AttrName.SessionScope.SHOPID);
        Integer shopId =Integer.parseInt(shopIdStr);
        Map<Integer, List<OrderInfo>> orderInfoMap =new HashMap<Integer, List<OrderInfo>>();
        List<Integer> intList = new ArrayList<Integer>();
		System.out.println("shopId="+shopId);
		List<OrderInfo> orderInfos = orderService.getOrderInfosByshop(shopId);
		for (OrderInfo info :orderInfos) {
			info.setOrder(orderService.findById(info.getOrderId()));
			info.setProduct(productService.getProductById(info.getProductId()));
			info.setDelivery(deliveryService.select(new Delivery(info.getDeliveryId(), null, null, null)).get(0));
			
		}
		for (OrderInfo orderInfo : orderInfos) {
			List<OrderInfo> orderInfos2=null;
			if(orderInfoMap.get(orderInfo.getOrderId())==null){
				intList.add(orderInfo.getOrderId());
				orderInfos2 =new ArrayList<OrderInfo>();
				orderInfoMap.put(orderInfo.getOrderId(), orderInfos2);
			}else{
				List<OrderInfo> list = orderInfoMap.get(orderInfo.getOrderId());
				list.add(orderInfo);
				orderInfoMap.put(orderInfo.getOrderId(), list);
			}
		}
		List<Order> orderList = new ArrayList<Order>();
		for (Integer id : intList) {
			Order order = orderService.findById(id);
			order.setOrderInfo(orderInfoMap.get(id));
			orderList.add(order);
		}
		
		orderList.sort(new Comparator<Order>() {

			public int compare(Order o1, Order o2) {
				return o2.getOrderTime().compareTo(o1.getOrderTime());
			}
		});
		
		req.setAttribute("orderList", orderList);
		req.getRequestDispatcher("/WEB-INF/shopowner/shop_order.jsp").forward(req, resp);
	}
}
