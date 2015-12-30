package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.OrdersDao;
import com.tmazon.domain.Orders;
import com.tmazon.domain.User;
import com.tmazon.util.DaoUtil;

public class OrdersDaoImpl implements OrdersDao {

	public List<Orders> select(Orders order) {
		StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM orders WHERE 1=1 ");
		ArrayList<Object> params = new ArrayList<Object>();
		if (order.getOrderId() != null) {
			sqlBuilder.append("AND orderId = ? ");
			params.add(order.getOrderId());
		}
		if (order.getOrderTime() != null) {
			sqlBuilder.append("AND orderTime = ? ");
			params.add(order.getOrderTime());
		}
		if (order.getPayType() != null) {
			sqlBuilder.append("AND payType = ? ");
			params.add(order.getPayType());
		}
		if (order.getStatus() != null) {
			sqlBuilder.append("AND status = ? ");
			params.add(order.getStatus());
		}
		if (order.getUserId() != null) {
			sqlBuilder.append("AND userId = ? ");
			params.add(order.getUserId());
		}
		if (order.getAddressId() != null) {
			sqlBuilder.append("AND addressId = ? ");
			params.add(order.getAddressId());
		}

		String sql = sqlBuilder.toString();
		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<Orders> result = runner.query(sql, new BeanListHandler<Orders>(Orders.class), params.toArray());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Orders insert(Orders order) {
		String sql = "INSERT INTO orders VALUES (?, ?, ?, ?, ?, ?)";
		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			Orders orders = runner.insert(sql, new BeanHandler<Orders>(Orders.class), order.getOrderId(), order.getPayType(),
					order.getStatus(), order.getOrderTime(), order.getUserId(), order.getAddressId());
			return orders;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean update(Orders order) {
		String sql = "UPDATE orders SET status = ? WHERE orderId = ?";
		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.update(sql, order.getStatus(), order.getOrderId());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Orders order) {
		String sql = "DELETE FROM orders WHERE orderId = ?";
		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.update(sql, order.getOrderId());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Orders> findByUser(User user) {
		
		return select(new Orders(null, null, null, null, user.getUserId(),null));
	}

	public List<Orders> findByUserANDstatus(User user, String status) {
		return select(new Orders(null, null, status, null, user.getUserId(), null));
	}

}
