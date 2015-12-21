package com.tmazon.dao;

import java.util.List;
import com.tmazon.domain.Advertisement;

public interface AdvertisementDao {
	
	public List<Advertisement> select();
	
	public boolean insert(Advertisement advertisement);
	
	public boolean update(Advertisement advertisement);
	
	public boolean delete(int  id);
	
}
