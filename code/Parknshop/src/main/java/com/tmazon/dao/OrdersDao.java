package com.tmazon.dao;

import java.util.List;

import com.tmazon.domain.Orders;
import com.tmazon.domain.User;

public interface OrdersDao {

	public List<Orders> select(Orders order);

	public Orders insert(Orders order);

	public boolean update(Orders order);

	public boolean delete(Orders order);
	
	public List<Orders> findByUser(User user);
	
	public List<Orders> findByUserANDstatus(User user, String status);

}
