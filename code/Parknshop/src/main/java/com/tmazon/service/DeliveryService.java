package com.tmazon.service;

import java.util.List;

import com.tmazon.domain.Delivery;

public interface DeliveryService {

	public List<Delivery> select(Delivery delivery);
	
	public List<Delivery> getAllDelivery();
	
}
