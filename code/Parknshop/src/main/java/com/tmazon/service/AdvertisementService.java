package com.tmazon.service;

public interface AdvertisementService {
	public boolean addAd(int cost,int productID);
	public boolean delete(int advertisementId);
	public boolean modify(int id,int cost);
}
