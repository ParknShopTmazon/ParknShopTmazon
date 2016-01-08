package com.tmazon.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tmazon.dao.AdvertisementDao;
import com.tmazon.dao.ProductDao;
import com.tmazon.dao.ShopDao;
import com.tmazon.dao.impl.AdvertisementDaoImpl;
import com.tmazon.domain.Advertisement;
import com.tmazon.domain.Product;
import com.tmazon.domain.Shop;
import com.tmazon.service.AdvertisementService;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.Page;

public class AdvertisementServiceImpl implements AdvertisementService {

	AdvertisementDao advertisementDao = BasicFactory.getImpl(AdvertisementDao.class);
	ProductDao productDao = BasicFactory.getImpl(ProductDao.class);
	ShopDao shopDao =  BasicFactory.getImpl(ShopDao.class);
	public boolean addAd(Integer productId, Integer cost,String picture) 
	{
		boolean result=advertisementDao.insert(productId,cost,picture);
		return result;
	}
	public boolean delete(int adId)
	{
		return advertisementDao.deleteById(adId);
		
	}
	/**
	 * 
	 * @param advId 
	 * @param cost >= 0
	 * @param picture
	 * @return
	 */
	public boolean modify(int adId,int cost,String picture){
		
		return advertisementDao.update(new Advertisement(adId,null,cost,picture));

	}
	public Page<Product> searchByPage(String productName,String type,int curPage,int next)
	{
		Product product = new Product();
		product.setName(productName);
		product.setCategory(type);
		List<Product> productList = productDao.select(product);
		Page<Product> productPage = new Page<Product>();
		productPage.setPageSize(5);
		productPage.page(productList,curPage,next);
		return productPage;
	}
	public Page<Advertisement> getAdPage(List<Advertisement> adList,int curPage,int next)
	{
		Page<Advertisement> adPage = new Page<Advertisement>();
		adPage.setPageSize(5);
		adPage.page(adList,curPage,next);
		return adPage;
	}
	public List<Advertisement> getAdList()
	{
		return advertisementDao.select();
	}
	public List<Shop> getShopList(List<Product> productList)
	{
		List<Shop> shopList = new ArrayList<Shop>();
		if(productList == null)
		{
			return null;
		}
		else
		{
			for(Product product : productList)
			{
				shopList.add(shopDao.findById(product.getShopId()));
			}
			return shopList;
		}
		
		
	}
}
