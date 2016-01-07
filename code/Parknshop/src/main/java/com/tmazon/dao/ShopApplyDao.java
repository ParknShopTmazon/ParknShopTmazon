package com.tmazon.dao;

import java.util.List;

import com.tmazon.domain.Shop;
import com.tmazon.domain.User;

public interface ShopApplyDao {
	public List<Shop> getApply();
	public boolean setStatus(int id,boolean isOk);
}
