package com.tmazon.service.impl;

import java.util.List;

import com.tmazon.dao.OverviewNumberDao;
import com.tmazon.dao.impl.OverviewNumberDaoImpl;
import com.tmazon.domain.User;
import com.tmazon.service.OverviewNumberService;

public class OverviewNumberServiceImpl implements OverviewNumberService {


	public int getShopOwnerNumber() {
		OverviewNumberDao s=new OverviewNumberDaoImpl();
		List<User> l=null;
		l=s.getShopOwner();
		//System.out.println(110);
		
		return l.size();
	}

	public int getCustomerNumber() {
		OverviewNumberDao s=new OverviewNumberDaoImpl();
		List<User> l=null;
		l=s.getCustomerOwner();
		
		return l.size();
	}

}
