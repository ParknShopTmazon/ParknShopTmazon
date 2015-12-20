package com.tmazon.service.impl;

import com.tmazon.dao.ShopDao;
import com.tmazon.domain.Shop;
import com.tmazon.service.ShopService;
import com.tmazon.util.BasicFactory;

public class ShopServiceImpl implements ShopService {
	
	private ShopDao shopDao = BasicFactory.getImpl(ShopDao.class);

	public Shop findById(Integer id) {

		return shopDao.findById(id);

	}

}
