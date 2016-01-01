package com.tmazon.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.domain.Order;
import com.tmazon.domain.Shop;
import com.tmazon.service.OrderService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.DaoUtil;

public class ShopOrderServlet extends HttpServlet {

	private OrderService orderService = BasicFactory.getImpl(OrderService.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer shopId = (Integer) req.getSession().getAttribute(AttrName.SessionScope.SHOPID);
		String sqlShopId="select orderId from orderInfo,product where orderInfo.productId=product.productId and product.shopId="+shopId;
		StringBuilder sqlBuilder = new StringBuilder("select * from orders where orderId=");
		List<Order> orderList = new ArrayList<Order>();
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
	    
//		try {
//			Integer orderIds[]= runner.query(sqlShopId, );
//			for(int i=0;i<orderIds.length;i++){
//				sqlBuilder.append(orderIds[i]).toString();
//				Order order = runner.
//				orderList.
//				
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			
//		}
		req.getRequestDispatcher("/WEB-INF/shopowner/shop_order.jsp").forward(req, resp);
	}
}
