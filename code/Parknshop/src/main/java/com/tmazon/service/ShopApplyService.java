package com.tmazon.service;

import java.util.List;

import com.tmazon.domain.Shop;
import com.tmazon.domain.User;

public interface ShopApplyService {
	
	public List<Shop> getApply();
	
	public boolean setStatus(int id, boolean isOk);
	
	public List<User> searchForOwner(List<Shop> shopList);
}
