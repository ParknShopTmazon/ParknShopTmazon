package com.tmazon.service;

import java.util.List;

import com.tmazon.domain.Cart;
import com.tmazon.domain.User;

public interface CartService {
	
	public List<Cart> getCart(User user);

	public boolean addProduct(Integer productId, int count); 
	
	public boolean deleteProduct(Integer productId, int count);
	
}
