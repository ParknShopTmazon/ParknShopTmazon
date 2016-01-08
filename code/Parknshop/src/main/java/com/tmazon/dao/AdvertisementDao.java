package com.tmazon.dao;

import java.util.List;
import com.tmazon.domain.Advertisement;

public interface AdvertisementDao {
	
	public List<Advertisement> select();
	
	public boolean insert(Integer productId,Integer cost, String picture);
	
	public boolean update(Advertisement advertisement);
	
	public boolean deleteById(int  adId);
	
}
