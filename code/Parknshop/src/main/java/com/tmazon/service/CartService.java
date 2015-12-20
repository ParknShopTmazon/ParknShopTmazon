package com.tmazon.service;

import java.util.List;
import java.util.Map;

import com.tmazon.domain.Cart;
import com.tmazon.domain.User;

public interface CartService {
	
	public List<Cart> getCart(User user);
	
	public List<Map<String, Integer>> getProductIdANDQuantity(User user);

	public boolean addProduct(Integer userId, Integer productId, Integer quantity); 
	
	public boolean deleteProduct(Integer userId, Integer productId);
	
	public boolean updateProduct(Integer userId, Integer productId, Integer quantity);
	
	public boolean isExists(Integer userId, Integer productId);
}
