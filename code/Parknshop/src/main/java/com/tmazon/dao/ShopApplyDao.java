package com.tmazon.dao;

import java.util.List;

import com.tmazon.domain.Shop;

public interface ShopApplyDao {
	public List<Shop> getApply();
	public boolean setStatus(int id,boolean isOk);
	
}
