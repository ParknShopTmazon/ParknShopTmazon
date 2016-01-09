package com.tmazon.service;

import java.util.List;

import com.tmazon.domain.Comment;

public interface CommentService {

	public List<Comment> findByProductId(Integer productId);
	
	public Comment addComment(Comment comment, int orderId, int productId);
	
}
