package com.tmazon.service;

import java.util.List;

import com.tmazon.domain.Advertisement;
import com.tmazon.domain.Product;
import com.tmazon.domain.Shop;
import com.tmazon.util.Page;

public interface AdvertisementService {
	public boolean addAd(Integer productId, Integer cost,String picture) ;
	public boolean delete(int adId);
	public boolean modify(int adId,int cost,String picture);
	public Page<Product> searchByPage(String productName,String type,int curPage,int next);
	public List<Shop> getShopList(List<Product> productList);
	public Page<Advertisement> getAdPage(List<Advertisement> adList,int curPage,int next);
	public List<Advertisement> getAdList();
}
