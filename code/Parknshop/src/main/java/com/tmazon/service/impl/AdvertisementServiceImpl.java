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
import com.tmazon.domain.ShowAd;
import com.tmazon.service.AdvertisementService;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.Page;

public class AdvertisementServiceImpl implements AdvertisementService {

	private AdvertisementDao advertisementDao = BasicFactory.getImpl(AdvertisementDao.class);
	private ProductDao productDao = BasicFactory.getImpl(ProductDao.class);
	private ShopDao shopDao =  BasicFactory.getImpl(ShopDao.class);
	public boolean addAd(Integer productId, Integer cost,String picture) 
	{
		List<Advertisement> adList = advertisementDao.select();
		for(Advertisement ad : adList)
		{
			if(ad.getProductID().intValue() == productId.intValue())
			{
				System.out.println("Advertisement update!");
				return advertisementDao.update(productId,cost,picture);
			}
		}
		
		System.out.println("Advertisement insert!");
		
		return advertisementDao.insert(productId,cost,picture);
	}
	public boolean delete(int adId)
	{
		return advertisementDao.deleteByProductId(adId);
		
	}
	/**
	 * 
	 * @param advId 
	 * @param cost >= 0
	 * @param picture
	 * @return
	 */
	public boolean modify(int adId,int cost,String picture){
		
		return advertisementDao.update(adId,cost,picture);

	}
	public Page<Product> searchByPage(String productName,String type,int curPage,int next)
	{
		List<Product> productList = productDao.selectByAdmin(productName,type);
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
	public List<ShowAd> getShowAd(List<Advertisement> adList)
	{
		List<ShowAd> showAdList = new ArrayList<ShowAd>();
		for(Advertisement ad : adList)
		{
			Product pro = productDao.findById(ad.getProductID());
			Shop shop = shopDao.findById(pro.getShopId());
			showAdList.add(new ShowAd(pro,shop,ad));
		}
		return showAdList;
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
