package com.tmazon.dao;

import java.util.List;

import com.tmazon.domain.Shop;

public interface ShopDao {

	public List<Shop> select(Shop shop);
	
	public Shop findById(Integer id);
	
}
