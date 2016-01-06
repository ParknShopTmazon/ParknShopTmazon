package com.tmazon.service;

import com.tmazon.domain.Shop;

public interface ShopService {

	public Shop findById(Integer id);
	
	public boolean register(Shop shop);
	
	public boolean isShopExist(Shop shop);
	
	public boolean insert(Shop shop);
	
	public boolean delete(Shop shop);
	
}
