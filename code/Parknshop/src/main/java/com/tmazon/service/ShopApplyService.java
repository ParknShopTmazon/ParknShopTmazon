package com.tmazon.service;

import java.util.List;

import com.tmazon.domain.Shop;
import com.tmazon.domain.User;
import com.tmazon.util.Page;

public interface ShopApplyService {
	
	public List<Shop> getApply();
	
	public boolean setStatus(int id, boolean isOk);
	
	public List<User> searchForOwner(List<Shop> shopList);
	
	public Page<Shop> page(List<Shop> shopList,int curPage,int next);
}
