package com.tmazon.service.impl;

import com.tmazon.dao.RateDao;
import com.tmazon.service.OverviewAdminService;
import com.tmazon.util.BasicFactory;

public class OverviewAdminServiceImpl implements OverviewAdminService{

	private RateDao rateDao = BasicFactory.getImpl(RateDao.class);
	public double getRate()
	{
		return rateDao.getRate();
	}
	
	
	
	
	
}
