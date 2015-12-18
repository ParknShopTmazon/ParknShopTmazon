package com.tmazon.service;

import java.util.List;
import java.util.Map;

import com.tmazon.domain.Cart;
import com.tmazon.domain.Product;
import com.tmazon.domain.User;

public interface CartService {
	
	public List<Cart> getCart(User user);
	
	public List<Map<String, Integer>> getProductIdANDQuantity(User user);

	public boolean addProduct(Integer userId, Integer productId, int count); 
	
	public boolean deleteProduct(Integer userId, Integer productId, int count);
	
}
