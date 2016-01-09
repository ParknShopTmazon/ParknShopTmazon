package com.tmazon.service.impl;

import java.util.Date;
import java.util.List;

import com.tmazon.dao.CommentDao;
import com.tmazon.dao.OrderInfoDao;
import com.tmazon.dao.UserDao;
import com.tmazon.domain.Comment;
import com.tmazon.domain.OrderInfo;
import com.tmazon.domain.User;
import com.tmazon.service.CommentService;
import com.tmazon.util.BasicFactory;

public class CommentServiceImpl implements CommentService {
	
	private CommentDao commentDao = BasicFactory.getImpl(CommentDao.class);
	private UserDao userDao = BasicFactory.getImpl(UserDao.class);
	private OrderInfoDao orderInfoDao = BasicFactory.getImpl(OrderInfoDao.class);

	public List<Comment> findByProductId(Integer productId) {
		List<Comment> comments = commentDao.findByProductId(productId);
		for(Comment comment : comments){
			User user = userDao.findById(comment.getUserId());
			comment.setUserName(user.getName());
		}
		return comments;
	}

	public Comment addComment(Comment comment, int orderId, int productId) {
		
		comment.setCommentTime(new Date());
		
		comment = commentDao.insert(comment);
		OrderInfo orderInfo = new OrderInfo(orderId, null, null, productId, OrderInfo.STATUS_COMMENTED);
		orderInfoDao.updateStatus(orderInfo);
		
		return comment;
	}

}
