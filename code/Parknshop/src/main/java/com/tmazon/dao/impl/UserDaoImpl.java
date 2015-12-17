package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.UserDao;
import com.tmazon.domain.User;
import com.tmazon.util.DaoUtil;

public class UserDaoImpl implements UserDao {

	public List<User> select(User user) {
		StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM user WHERE 1=1 ");
		ArrayList<Object> params = new ArrayList<Object>();
		if (user.getUserId() != null) {
			sqlBuilder.append("AND user_id=? ");
			params.add(user.getUserId());
		}
		if (user.getName() != null) {
			sqlBuilder.append("AND name=? ");
			params.add(user.getName());
		}
		if (user.getPassword() != null) {
			sqlBuilder.append("AND password=? ");
			params.add(user.getPassword());
		}
		if (user.getRole() != null) {
			sqlBuilder.append("AND role=? ");
			params.add(user.getRole());
		}
		if (user.getStatus() != null) {
			sqlBuilder.append("AND status=? ");
			params.add(user.getStatus());
		}
		
		String sql = sqlBuilder.toString();
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<User> result = runner.query(sql, new BeanListHandler<User>(User.class), params.toArray());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean insert(User user) {
		String sql = "INSERT INTO user VALUES (?, ?, ?, ?, ?)";
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.insert(sql, new BeanHandler<User>(User.class));
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public User findByName(String name) {
		List<User> list = select(new User(null, name, null, null, null));
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	

}
