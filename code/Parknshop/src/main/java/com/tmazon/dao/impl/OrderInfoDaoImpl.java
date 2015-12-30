package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.OrderInfoDao;
import com.tmazon.domain.OrderInfo;
import com.tmazon.util.DaoUtil;

public class OrderInfoDaoImpl implements OrderInfoDao {

	public List<OrderInfo> select(OrderInfo orderInfo) {

		StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM orderInfo WHERE 1=1 ");
		ArrayList<Object> params = new ArrayList<Object>();
		if (orderInfo.getOrderId() != null) {
			sqlBuilder.append("AND orderId = ? ");
			params.add(orderInfo.getOrderId());
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

		String sql = sqlBuilder.toString();
		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<OrderInfo> result = runner.query(sql, new BeanListHandler<OrderInfo>(OrderInfo.class),
					params.toArray());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean insert(OrderInfo orderInfo) {
		String sql = "INSERT INTO orderInfo VALUES (?, ?, ?, ?)";
		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.insert(sql, new BeanHandler<OrderInfo>(OrderInfo.class), orderInfo.getOrderId(),
					orderInfo.getDeliveryId(), orderInfo.getQuantity(), orderInfo.getProductId());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(OrderInfo orderInfo) {
		String sql = "UPDATE orderInfo SET deliveryId = ?,quantity = ? WHERE orderId = ? AND productId = ?";
		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.update(sql,orderInfo.getDeliveryId(), orderInfo.getProductId(), orderInfo.getOrderId(), orderInfo.getProductId());
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

}
