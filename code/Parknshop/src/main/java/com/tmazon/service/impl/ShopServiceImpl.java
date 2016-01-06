package com.tmazon.service.impl;

import java.util.List;

import com.tmazon.dao.ShopDao;
import com.tmazon.domain.Product;
import com.tmazon.domain.Shop;
import com.tmazon.service.ShopService;
import com.tmazon.util.BasicFactory;

public class ShopServiceImpl implements ShopService {
	
	private ShopDao shopDao = BasicFactory.getImpl(ShopDao.class);

	public Shop findById(Integer id) {

		return shopDao.findById(id);

	}

	public boolean register(Shop shop) {
		return shopDao.insert(shop);
	}
	
	public boolean isShopExist(Shop shop) {
		List<Shop> list = shopDao.select(shop);
		return list != null && !list.isEmpty();
	}
	
	public boolean insert(Shop shop) {
		// TODO Auto-generated method stub
		return shopDao.insert(shop);
	}

	public boolean delete(Shop shop) {
		
		return shopDao.delete(shop);
	}
}
