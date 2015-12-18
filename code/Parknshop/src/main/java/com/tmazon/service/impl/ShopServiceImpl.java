package com.tmazon.service.impl;

import com.tmazon.domain.Shop;
import com.tmazon.service.ShopService;
import com.tmazon.util.BasicFactory;

public class ShopServiceImpl implements ShopService {
	
	private ShopService shopService = BasicFactory.getImpl(ShopService.class);

	public Shop findById(Integer id) {

		return shopService.findById(id);

	}

}
