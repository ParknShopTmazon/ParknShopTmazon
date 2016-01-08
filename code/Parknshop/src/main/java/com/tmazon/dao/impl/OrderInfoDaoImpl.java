package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.OrderInfoDao;
import com.tmazon.domain.Order;
import com.tmazon.domain.OrderInfo;
import com.tmazon.util.DaoUtil;
import com.tmazon.util.RateUtil;

public class OrderInfoDaoImpl implements OrderInfoDao {

	public List<OrderInfo> select(OrderInfo orderInfo) {

		StringBuilder sqlBuilder = new StringBuilder(
				"SELECT * FROM orderInfo WHERE 1=1 ");
		ArrayList<Object> params = new ArrayList<Object>();
		if (orderInfo.getOrderId() != null) {
			sqlBuilder.append("AND orderId = ? ");
			params.add(orderInfo.getOrderId());
		}
		if (orderInfo.getWaybill() != null) {
			sqlBuilder.append("AND waybill = ? ");
			params.add(orderInfo.getWaybill());
		}
		if (orderInfo.getDeliveryId() != null) {
			sqlBuilder.append("AND deliveryId = ? ");
			params.add(orderInfo.getDeliveryId());
		}
		if (orderInfo.getQuantity() != null) {
			sqlBuilder.append("AND quantity = ? ");
			params.add(orderInfo.getQuantity());
		}
		if (orderInfo.getProductId() != null) {
			sqlBuilder.append("AND productId = ? ");
			params.add(orderInfo.getProductId());
		}
		if (orderInfo.getStatus() != null) {
			sqlBuilder.append("AND status = ? ");
			params.add(orderInfo.getStatus());
		}

		String sql = sqlBuilder.toString();
		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<OrderInfo> result = runner.query(sql,
					new BeanListHandler<OrderInfo>(OrderInfo.class),
					params.toArray());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean insert(OrderInfo orderInfo) {
		String sql = "INSERT INTO orderInfo VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.insert(sql, new BeanHandler<OrderInfo>(OrderInfo.class),
					orderInfo.getOrderId(), orderInfo.getDeliveryId(),
					orderInfo.getQuantity(), orderInfo.getProductId(),
					orderInfo.getStatus(), orderInfo.getDeliveryTime(),
					orderInfo.getDealTime(), null, orderInfo.getWaybill());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(OrderInfo orderInfo) {
		String sql = "UPDATE orderInfo SET status=? WHERE orderId = ? AND productId = ?";
		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.update(sql, orderInfo.getStatus(), orderInfo.getOrderId(),
					orderInfo.getProductId());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(OrderInfo orderInfo) {
		String sql = "DELETE FROM orders WHERE orderId = ? AND productId = ?";
		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.update(sql, orderInfo.getOrderId(), orderInfo.getProductId());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Order> getOrderByShopId(Integer shopId) {
		StringBuilder sqlBuilder = new StringBuilder(
				"select * from product,orderinfo,orders where shopId = ? AND orderinfo.productId = product.productId AND orders.orderId = orderinfo.orderId group by orders.orderId");
		ArrayList<Object> params = new ArrayList<Object>();
		if (shopId != null) {
			params.add(shopId);
		} else {
			return null;
		}

		String sql = sqlBuilder.toString();
		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<Order> result = runner.query(sql, new BeanListHandler<Order>(
					Order.class), params.toArray());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<OrderInfo> getOrderInfosByshop(Integer shopId) {

		StringBuilder sqlBuilder = new StringBuilder(
				"select * from product,orderinfo where shopId = ? AND orderinfo.productId = product.productId");
		ArrayList<Object> params = new ArrayList<Object>();
		if (shopId != null) {
			params.add(shopId);
		} else {
			return null;
		}

		String sql = sqlBuilder.toString();
		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<OrderInfo> result = runner.query(sql,
					new BeanListHandler<OrderInfo>(OrderInfo.class),
					params.toArray());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean changeStatus(OrderInfo orderInfo) {
		String sql = "UPDATE orderInfo SET status = ? WHERE orderId = ? AND productId = ?";
		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			int row = runner.update(sql, orderInfo.getStatus(),
					orderInfo.getOrderId(), orderInfo.getProduct());
			return row > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateStatus(OrderInfo orderInfo) {
		StringBuilder sqlBuilder = new StringBuilder(
				"UPDATE orderInfo SET status = ? ");
		if (OrderInfo.STATUS_ON_DELIVERY.equals(orderInfo.getStatus())) {
			sqlBuilder.append(", deliveryTime = now() ");
		} else if (OrderInfo.STATUS_CONFIRM_RECEIPT.equals(orderInfo
				.getStatus())) {
			sqlBuilder.append(", dealTime = now(), rate = '"
					+ RateUtil.getRate() + "' ");
		}
		sqlBuilder.append("WHERE orderId = ? AND productId = ?");
		String sql = sqlBuilder.toString();
		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			int rows = runner.update(sql, orderInfo.getStatus(),
					orderInfo.getOrderId(), orderInfo.getProductId());
			return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean isBought(Integer userId, Integer productId) {

		String sql = "select * from orders,orderinfo where orders.userId = ? and orderinfo.productId = ? and orders.orderId = orderinfo.orderId "
				+ "and (orderinfo.status = ? or orderinfo.status = ?)";
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(userId);
		params.add(productId);
		params.add(OrderInfo.STATUS_CONFIRM_RECEIPT);
		params.add(OrderInfo.STATUS_DELETED);

		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<OrderInfo> result = runner.query(sql,
					new BeanListHandler<OrderInfo>(OrderInfo.class),
					params.toArray());
			return !result.isEmpty();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

}
