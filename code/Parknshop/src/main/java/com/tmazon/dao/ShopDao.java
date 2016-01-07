package com.tmazon.dao;

import java.util.List;

import com.tmazon.domain.Shop;

public interface ShopDao {

    public List<Shop> select(Shop shop);
	
    public boolean insert(Shop shop);
	
	public boolean update(Shop shop);
	
	public boolean delete(Shop shop);
	
	public Shop findById(Integer id);
	
	public List<Shop> selectInLike(Shop shop);
}
