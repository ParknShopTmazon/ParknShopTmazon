package com.tmazon.service.impl;

import java.util.Date;
import java.util.List;

import com.tmazon.dao.CommentDao;
import com.tmazon.domain.Comment;
import com.tmazon.service.CommentService;
import com.tmazon.util.BasicFactory;

public class CommentServiceImpl implements CommentService {
	
	private CommentDao commentDao = BasicFactory.getImpl(CommentDao.class);

	public List<Comment> findByProductId(Integer productId) {
		return commentDao.findByProductId(productId);
	}

	public Comment addComment(Comment comment) {
		
		comment.setCommentTime(new Date());
		
		return commentDao.insert(comment);
	}

}
