package com.tmazon.service.impl;

import com.tmazon.dao.AdvertisementDao;
import com.tmazon.dao.impl.AdvertisementDaoImpl;
import com.tmazon.domain.Advertisement;
import com.tmazon.service.AdvertisementService;

public class AdvertisementServiceImpl implements AdvertisementService {

	public boolean addAd(int productID, int cost) {
		Advertisement ad=new Advertisement(1,cost,productID);
		AdvertisementDao ado=new AdvertisementDaoImpl();
		boolean result=ado.insert(ad);
		return result;
	}
	public boolean delete(int advertisementId){
		if(advertisementId>0){
				AdvertisementDao ado=new AdvertisementDaoImpl();
				ado.delete(advertisementId);
				return true;
		}
		return false;
	}
	
	public boolean modify(int advId,int cost){
		if(advId>0&&cost>0){
			Advertisement ad=new Advertisement(advId,1,cost);
			AdvertisementDao ado=new AdvertisementDaoImpl();
			boolean result=ado.update(ad);
			return result;
		}
		return false;
	}
}
