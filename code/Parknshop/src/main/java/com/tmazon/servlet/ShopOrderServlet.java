package com.tmazon.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.domain.Order;
import com.tmazon.domain.OrderInfo;
import com.tmazon.domain.Product;
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
		
//		Integer shopId = (Integer) req.getSession().getAttribute(AttrName.SessionScope.SHOPID);
		Integer shopId =1;
		StringBuilder sqlBuilder1 = new StringBuilder("select orders.orderId,payType,"
				+ "orders.status,orderTime,deliveryTime,dealTime,userId,addressId "
				+ "from product,orderInfo,orders where product.productId=orderInfo.productId "
				+ "and orders.orderId=orderInfo.orderId and shopId=");
		
		StringBuilder sqlBuilder2 = new StringBuilder("select orderInfo.orderId,orderInfo.deliveryId,"
				+ "orderInfo.quantity,orderInfo.productId,orderInfo.waybill "
				+ "from product,orderInfo,orders where product.productId=orderInfo.productId "
				+ "and orders.orderId=orderInfo.orderId and shopId=");
		
		StringBuilder sqlBuidler3 = new StringBuilder("select product.productId,shopId,name,price,"
				+ "discountPrice,category,stockNum,soldNum,description,picture,product.status "
				+ "from product,orderInfo,orders where product.productId=orderInfo.productId "
				+ "and orders.orderId=orderInfo.orderId and shopId=");

		
		String endSql = " group by orders.orderId;";
		
		
		
//		String sqlByShopId1 = sqlBuilder1.append(shopId).append(";").toString();
		
		String sqlByShopId1 = sqlBuilder1.append(shopId).append(endSql).toString();
		String sqlByShopId2 = sqlBuilder2.append(shopId).toString();
		String sqlByShopId3 = sqlBuidler3.append(shopId).append(endSql).toString();
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
	    
		List<List<Object>> orderList = new ArrayList<List<Object>>();
		
		List<Object> orderIdList = new ArrayList<Object>(); 
		List<Object> statusList = new ArrayList<Object>();
		List<Object> orderTimeList = new ArrayList<Object>();
		try {
			List<Order> orders= runner.query(sqlByShopId1, new BeanListHandler<Order>(Order.class));
			List<OrderInfo> orderInfos= runner.query(sqlByShopId2, new BeanListHandler<OrderInfo>(OrderInfo.class));
			List<Product> productInfos= runner.query(sqlByShopId3, new BeanListHandler<Product>(Product.class));
			
			System.out.println("#################");
			System.out.println("product = "+productInfos.size());
			
			for(int i=0;i<orders.size();i++){
				  
				System.out.println(orders.get(i).toString());
			}
			
			for(int i=0;i<orderInfos.size();i++){
				System.out.println(orderInfos.get(i).toString());
			}
			
			for(int i=0;i<productInfos.size();i++){
				System.out.println(productInfos.get(i).toString());
			}
			
            for(int i=0;i<orders.size();i++){
				
//				orderIdList.add(orders.get(i).getOrderId());
//				statusList.add(orders.get(i).getStatus());
//				orderTimeList.add(orders.get(i).getOrderTime());
//				orderList.add(orderIdList);
//				orderList.add(statusList);
//				orderList.add(orderTimeList);
				
				List<Object> orderOneList = new ArrayList<Object>();
				orderOneList.add(orders.get(i).getOrderId());
				orderOneList.add(orders.get(i).getStatus());
				orderOneList.add(orders.get(i).getOrderTime());
				
				List<OrderInfo> orderInfoById = new ArrayList<OrderInfo>();
				
				for(int j=0;j<orderInfos.size();j++){
					for(int k=0;k<productInfos.size();k++){
						if(orders.get(i).getOrderId() == orderInfos.get(j).getOrderId() && 
								orderInfos.get(j).getProductId() == productInfos.get(k).getProductId()){
							   
							List<Object> orderOneList2 = new ArrayList<Object>();
								orderOneList2.add(orderInfos.get(j).getDeliveryId());
								orderOneList2.add(orderInfos.get(j).getQuantity());
								orderOneList2.add(productInfos.get(k).getName());
								orderOneList2.add(productInfos.get(k).getPrice());
								orderOneList2.add(productInfos.get(k).getDiscountPrice());
								orderOneList2.add(productInfos.get(k).getPicture());
							   orderOneList.add(orderOneList2);
						}
					}
				}
				
				orderList.add(orderOneList);	
				
//				orders.get(i).setOrderInfo(orderInfoById);
//				System.out.println(orders.get(i).getOrderInfo().size());
//				System.out.println(orders.get(i).toString());
			}
			
//			for(int i=0;i<orderList.size();i++){
//				for(int j=0;j<orderList.get(i).size();j++){
//					
//                    if(j<3){
//                    	System.out.println(orderList.get(i).get(j));
//					}
//                    else{
//                    	for(int k=0;k<orderList.get(i).get(j).)
//                    }
//				}
//				
//				
//			}
			
				

			
			req.setAttribute("orderList", orderList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		
		
		req.getRequestDispatcher("/WEB-INF/shopowner/shop_order.jsp").forward(req, resp);
	}
}
