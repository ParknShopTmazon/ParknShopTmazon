package com.tmazon.dao;

import java.util.List;

import com.tmazon.domain.Cart;
import com.tmazon.domain.User;

public interface CartDao {

	public List<Cart> select(Cart cart);
	
	public boolean insert(Cart cart);
	
	public boolean update(Cart cart);
	
	public boolean delete(Cart cart);
	
	public List<Cart> findByUser(User user);
	
	public List<Cart> findByUserId(Integer userId);
	
	public Cart findByPKId(Integer userId, Integer productId);
	
}
