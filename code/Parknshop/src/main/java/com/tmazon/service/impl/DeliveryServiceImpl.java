package com.tmazon.service.impl;

import java.util.List;

import com.tmazon.dao.DeliveryDao;
import com.tmazon.domain.Delivery;
import com.tmazon.service.DeliveryService;
import com.tmazon.util.BasicFactory;

public class DeliveryServiceImpl implements DeliveryService {
	
	private DeliveryDao deliveryDao = BasicFactory.getImpl(DeliveryDao.class);

	public List<Delivery> select(Delivery delivery) {
		return deliveryDao.select(delivery);
	}

	public List<Delivery> getAllDelivery() {
		return select(new Delivery());
	}

	public List<Delivery> getAllCompany() {
		return deliveryDao.getAllCompany();
	}

}
