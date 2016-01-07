package com.tmazon.dao;

import com.tmazon.domain.Comment;

import java.util.List;

public interface CommentDao {

	public List<Comment> select(Comment comment);
	
	public List<Comment> findByProductId(Integer productId);
	
	public Comment insert(Comment comment);
	
}
