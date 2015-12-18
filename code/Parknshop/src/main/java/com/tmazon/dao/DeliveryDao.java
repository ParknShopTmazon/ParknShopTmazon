package com.tmazon.dao;

import java.util.List;

import com.tmazon.domain.Delivery;

public interface DeliveryDao {

	public List<Delivery> select(Delivery delivery);
	
}
