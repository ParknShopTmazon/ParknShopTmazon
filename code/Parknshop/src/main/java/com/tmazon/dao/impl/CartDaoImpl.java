package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.CartDao;
import com.tmazon.domain.Cart;
import com.tmazon.domain.User;
import com.tmazon.util.DaoUtil;

public class CartDaoImpl implements CartDao {

	public List<Cart> select(Cart cart) {
		StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM cart WHERE 1=1 ");
		ArrayList<Object> params = new ArrayList<Object>();
		if(cart.getUserId() != null){
			sqlBuilder.append("AND user_id = ? ");
			params.add(cart.getUserId());
		}
		if(cart.getProductId() != null){
			sqlBuilder.append("AND product_id = ? ");
			params.add(cart.getProductId());
		}
		if(cart.getQuantity() != null){
			sqlBuilder.append("AND quantity = ? ");
			params.add(cart.getQuantity());
		}
		
		String sql = sqlBuilder.toString();
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<Cart> result = runner.query(sql, new BeanListHandler<Cart>(Cart.class), params);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean insert(Cart cart) {
		String sql = "INSERT INTO cart VALUES (?, ?, ?)";
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.insert(sql, new BeanHandler<Cart>(Cart.class));
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Cart cart) {
		
		String sql = "UPDATE cart SET quantity = ? WHERE user_id = ? AND product_id = ?";
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.update(sql, cart.getQuantity(), cart.getUserId(), cart.getProductId());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Cart cart) {
		
		String sql = "DELETE FROM cart WHERE user_id = ? AND product_id = ?";
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.update(sql, cart.getUserId(), cart.getProductId());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public List<Cart> findByUser(User user) {
		
		List<Cart> list = findByUserId(user.getUserId());
		
		return list;
	}

	public List<Cart> findByUserId(Integer userId) {
		
		List<Cart> list = select(new Cart(userId, null, null));
		
		return list;
	}

	public Cart findByPKId(Integer userId, Integer productId) {
		
		List<Cart> list = select(new Cart(userId, productId, null));
		
		if(list.isEmpty())
			return null;
		else {
			return list.get(0);
		}
	}

}
