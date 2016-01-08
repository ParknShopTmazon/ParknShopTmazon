package com.tmazon.service.impl;

import java.util.Date;
import java.util.List;

import com.tmazon.dao.CommentDao;
import com.tmazon.dao.UserDao;
import com.tmazon.domain.Comment;
import com.tmazon.domain.User;
import com.tmazon.service.CommentService;
import com.tmazon.util.BasicFactory;

public class CommentServiceImpl implements CommentService {
	
	private CommentDao commentDao = BasicFactory.getImpl(CommentDao.class);
	private UserDao userDao = BasicFactory.getImpl(UserDao.class);

	public List<Comment> findByProductId(Integer productId) {
		List<Comment> comments = commentDao.findByProductId(productId);
		for(Comment comment : comments){
			User user = userDao.findById(comment.getUserId());
			comment.setUserName(user.getName());
		}
		return comments;
	}

	public Comment addComment(Comment comment) {
		
		comment.setCommentTime(new Date());
		
		return commentDao.insert(comment);
	}

}
