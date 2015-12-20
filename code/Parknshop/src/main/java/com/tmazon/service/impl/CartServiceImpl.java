package com.tmazon.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tmazon.dao.CartDao;
import com.tmazon.domain.Cart;
import com.tmazon.domain.User;
import com.tmazon.service.CartService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;

public class CartServiceImpl implements CartService {
	
	private CartDao cartDao = BasicFactory.getImpl(CartDao.class);
	
	public List<Cart> getCart(User user) {
		
		List<Cart> list = cartDao.select(new Cart(user.getUserId(), null, null));
		
		return list;
	}
	
	public List<Map<String, Integer>> getProductIdANDQuantity(User user) {
		
		List<Cart> carts = getCart(user);
		List<Map<String, Integer>> result = new ArrayList<Map<String,Integer>>();
		
		Cart cart;
		Map<String, Integer> map;
		for(int i = 0, size = carts.size(); i < size; i++){
			cart = carts.get(i);
			map = new HashMap<String, Integer>();
			
			map.put(AttrName.CartServiceImplMapGet.PRODUCT_ID, cart.getProductId());
			map.put(AttrName.CartServiceImplMapGet.QUANTITY, cart.getQuantity());
			
			result.add(map);
		}
		
		return result;
	}


	public boolean addProduct(Integer userId, Integer productId, Integer quantity) {
		
		return cartDao.insert(new Cart(userId, productId, quantity));
	}

	public boolean deleteProduct(Integer userId, Integer productId) {
		
		return cartDao.delete(new Cart(userId, productId, null));
	}

	public boolean updateProduct(Integer userId, Integer productId, Integer quantity) {
		
		return cartDao.update(new Cart(userId, productId, quantity));
	}

	public boolean isExists(Integer userId, Integer productId) {
		
		List<Cart> list = cartDao.select(new Cart(userId, productId, null));
		
		if(list.isEmpty())
			return false;
		
		return true;
	}

}
