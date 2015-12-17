package com.tmazon.service.impl;

import java.util.List;

import com.tmazon.dao.CartDao;
import com.tmazon.dao.UserDao;
import com.tmazon.domain.Cart;
import com.tmazon.domain.User;
import com.tmazon.service.CartService;
import com.tmazon.util.BasicFactory;

public class CartServiceImpl implements CartService {
	
	private CartDao cartDao = BasicFactory.getImpl(CartDao.class);

	public List<Cart> getCart(User user) {
		
		List<Cart> list = cartDao.select(new Cart(user.getUserId(), null, null));
		
		
		return null;
	}

	public boolean addProduct(Integer productId, int count) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteProduct(Integer productId, int count) {
		// TODO Auto-generated method stub
		return false;
	}

}
