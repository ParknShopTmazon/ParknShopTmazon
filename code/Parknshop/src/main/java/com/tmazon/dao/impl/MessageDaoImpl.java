package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.MessageDao;
import com.tmazon.domain.Message;
import com.tmazon.util.DaoUtil;

public class MessageDaoImpl implements MessageDao {

	public List<Message> findByIds(Integer userId, Integer friendId) {
		String sql = "SELECT * FROM message WHERE userId = ? AND friendId = ?";
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<Message> result = runner.query(sql, new BeanListHandler<Message>(Message.class), userId, friendId);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean insert(Message message) {
		String sql = "INSERT INTO message VALUES (null, ?, ?, ?, ?, now())";
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.insert(sql, new BeanHandler<Message>(Message.class), message.getUserId(), message.getFriendId(), message.getContent(), message.getIsUnread());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateUnreadByIds(Integer userId, Integer friendId, Boolean isUnread) {
		String sql = "UPDATE message SET isUnread = ? WHERE userId = ? AND friendId = ?";
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.update(sql, isUnread, userId, friendId);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
