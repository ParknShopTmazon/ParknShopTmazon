package com.tmazon.service;

import java.util.List;

import com.tmazon.domain.Shop;

public interface ShopService {

	public List<Shop> select(Shop shop);
	
	public Shop findById(Integer id);
	
	public boolean register(Shop shop);
	
	public boolean isShopExist(Shop shop);
	
	public boolean insert(Shop shop);
	
	public boolean delete(Shop shop);
	
	public boolean update(Shop shop);
	
	public List<Shop> selectInLike(Shop shop);
	
}
