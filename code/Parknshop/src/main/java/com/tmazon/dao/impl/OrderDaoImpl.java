package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.OrderDao;
import com.tmazon.domain.Order;
import com.tmazon.domain.User;
import com.tmazon.util.DaoUtil;

public class OrderDaoImpl implements OrderDao {

	public List<Order> select(Order order, Boolean deleted) {
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
		if (deleted != null){
			if (deleted) {
				sqlBuilder.append("AND status = '" + Order.STATUS_DELETED +  "' ");
			} else {
				sqlBuilder.append("AND status <> '" + Order.STATUS_DELETED +  "' ");
			}
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
			List<Order> result = runner.query(sql, new BeanListHandler<Order>(Order.class), params.toArray());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Order insert(Order order) {
		String sql = "INSERT INTO orders(payType,status,orderTime,userId,addressId) VALUES (?, ?, ?, ?, ?)";
		System.out.println(sql);
		
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(order.getPayType());
		params.add(order.getStatus());
		params.add(order.getOrderTime());
		params.add(order.getUserId());
		params.add(order.getAddressId());

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.insert(sql, new BeanHandler<Order>(Order.class),params.toArray());
			List<Order> result = select(order, null);
			if(result.isEmpty())
				return null;
			return result.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean update(Order order) {
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

	public boolean delete(Order order) {
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

	public List<Order> findByUser(User user) {
		
		return select(new Order(null, null, null, null, user.getUserId(),null), null);
	}

	public List<Order> findByUserANDstatus(User user, String status) {
		return select(new Order(null, null, status, null, user.getUserId(), null), null);
	}

	public Order findByOrderId(Integer orderId){
		
		List<Order> orderList = select(new Order(orderId,null,null,null,null,null), null);
		return orderList.isEmpty()? null:orderList.get(0);
	}
}
