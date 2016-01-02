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
import com.tmazon.domain.OrderInfo;
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
	
		StringBuilder sqlBuilder1 = new StringBuilder("select orders.orderId,payType,orders.status,orderTime,deliveryTime,dealTime,userId,addressId "
				+ "from product,orderInfo,orders where product.productId=orderInfo.productId "
				+ "and orders.orderId=orderInfo.orderId and shopId=1");
		
		StringBuilder sqlBuilder2 = new StringBuilder("select orders.orderId,deliveryId,quantity,orderInfo.productId,waybill "
				+ "from product,orderInfo,orders where product.productId=orderInfo.productId "
				+ "and orders.orderId=orderInfo.orderId and shopId=1;");
		
		
//		String sqlByShopId1 = sqlBuilder1.append(shopId).append(";").toString();
		
		String sqlByShopId1 = sqlBuilder1.toString();
		String sqlByShopId2 = sqlBuilder2.toString();
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
	    
		try {
			List<Order> orders= runner.query(sqlByShopId1, new BeanListHandler<Order>(Order.class));
			List<OrderInfo> orderInfos= runner.query(sqlByShopId1, new BeanListHandler<OrderInfo>(OrderInfo.class));
			
			System.out.println("#################");
			System.out.println(orders.size());
			for(int i=0;i<orders.size();i++){
				System.out.println(orders.get(i).toString());
			}
			
			for(int i=0;i<orders.size();i++){
				List<OrderInfo> orderInfoById = new ArrayList<OrderInfo>();
				for(int j=0;j<orderInfos.size();j++){
					if(orders.get(i).getOrderId() == orderInfos.get(j).getOrderId()){
						orderInfoById.add(orderInfos.get(j));
					}
				}
				orders.get(i).setOrderInfo(orderInfoById);
				System.out.println(orders.get(i).toString());
				System.out.println(orders.get(i).getOrderInfo().size());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		
		
		req.getRequestDispatcher("/WEB-INF/shopowner/shop_order.jsp").forward(req, resp);
	}
}
