package com.tmazon.dao;

import java.util.List;

import com.tmazon.domain.Order;
import com.tmazon.domain.User;

public interface OrderDao {

	public List<Order> select(Order order, Boolean deleted);

	public Order insert(Order order);

	public boolean update(Order order);

	public boolean delete(Order order);
	
	public List<Order> findByUser(User user);
	
	public List<Order> findByUserANDstatus(User user, String status);

}
