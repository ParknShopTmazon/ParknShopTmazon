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
			sqlBuilder.append("AND userId=? ");
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
	
	public List<User> search(User user){
		StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM user WHERE 1=1 ");
		ArrayList<Object> params = new ArrayList<Object>();
		if (user.getUserId() != null) {
			sqlBuilder.append("AND userId=? ");
			params.add(user.getUserId());
		}
		if (user.getName() != null) {
			sqlBuilder.append("AND name like \"%"+user.getName()+"%\"");
			//params.add(user.getName());
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
			runner.insert(sql, new BeanHandler<User>(User.class), user.getUserId(), user.getName(), user.getPassword(), user.getRole(), user.getStatus());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(String name,String status) {
		String sql = "UPDATE user SET status = ? WHERE name = ?";
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.update(sql,status,name);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(String name) {
		String sql="DELETE FROM user WHERE name = ?";
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.update(sql,name);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	public User findByName(String name) {
		List<User> list = select(new User(null, name, null, null, null));
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public List<User> findFriendsById(Integer id) {
		String sql = "SELECT * FROM user WHERE userId in (SELECT userId FROM friend WHERE friendId = ? UNION SELECT friendId FROM friend WHERE userId = ?)";
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<User> firends = runner.query(sql, new BeanListHandler<User>(User.class), id, id);
			return firends;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public boolean insertFriend(Integer userId, Integer friendId) {
		String sql = "INSERT INTO friend VALUES (?, ?)";
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.update(sql, userId, friendId);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public List<User> SearchByName(String name) {
		String sql = "SELECT * FROM user WHERE name like ?";
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<User> result = runner.query(sql, new BeanListHandler<User>(User.class), "%" + name + "%");
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteFriend(Integer userId, Integer friendId) {
		String sql = "DELETE FROM friend WHERE (userId = ? AND friendId = ?) OR (userId = ? AND friendId = ?)";
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.update(sql, userId, friendId, friendId, userId);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public User findById(Integer id) {
		List<User> list = select(new User(id, null, null, null, null));
		
		if(list.isEmpty())
			return null;
		else {
			return list.get(0);
		}
	}

	

	

}
