package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.CommentDao;
import com.tmazon.domain.Comment;
import com.tmazon.util.DaoUtil;

public class CommentDaoImpl implements CommentDao {

	public List<Comment> select(Comment comment) {
		StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM comment WHERE 1=1 ");
		ArrayList<Object> params = new ArrayList<Object>();
		if (comment.getUserId() != null) {
			sqlBuilder.append("AND userId = ? ");
			params.add(comment.getUserId());
		}
		if (comment.getCommentId() != null) {
			sqlBuilder.append("AND commentId = ? ");
			params.add(comment.getCommentId());
		}
		if (comment.getCommentTime() != null) {
			sqlBuilder.append("AND commentTime = ? ");
			params.add(comment.getCommentTime());
		}
		if (comment.getContent() != null) {
			sqlBuilder.append("AND content = ? ");
			params.add(comment.getContent());
		}
		if (comment.getProductId() != null) {
			sqlBuilder.append("AND productId = ? ");
			params.add(comment.getProductId());
		}
		if (comment.getShopScore() != null) {
			sqlBuilder.append("AND shopScore = ? ");
			params.add(comment.getShopScore());
		}
		if (comment.getProductScore() != null) {
			sqlBuilder.append("AND productScore = ? ");
			params.add(comment.getProductScore());
		}
		if (comment.getDeliveryScore() != null) {
			sqlBuilder.append("AND deliveryScore = ? ");
			params.add(comment.getDeliveryScore());
		}
		if (comment.getReplyId() != null) {
			sqlBuilder.append("AND replyId = ? ");
			params.add(comment.getReplyId());
		}

		String sql = sqlBuilder.toString();
		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<Comment> result = runner.query(sql, new BeanListHandler<Comment>(Comment.class), params.toArray());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Comment> findByProductId(Integer productId) {
		return select(new Comment(null, null, productId, null, null));
	}

	public Comment insert(Comment comment) {
		String sql = "INSERT INTO comment(userId,productId,content,commentTime,shopScore,productScore,deliveryScore,replyId) VALUES (?, ?, ?, ?, ?,?,?,?)";
		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.insert(sql, new BeanHandler<Comment>(Comment.class), comment.getUserId(), comment.getProductId(),
					comment.getContent(), comment.getCommentTime(),comment.getShopScore(),comment.getProductScore(),comment.getDeliveryScore(), comment.getReplyId());
			
			List<Comment> list = select(comment);
			if(list.isEmpty()){
				return null;
			}else {
				return list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
