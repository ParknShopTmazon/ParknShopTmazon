package com.tmazon.service.impl;

import java.util.List;

import com.tmazon.dao.ProfitDao;
import com.tmazon.dao.impl.ProfitDaoImpl;
import com.tmazon.domain.Profit;
import com.tmazon.service.ProfitService;
import com.tmazon.util.Rate;


// the controller of Profit
public class ProfitServiceImpl implements ProfitService {
	
	/**
	 * the method called when calculate profit
	 * 
	 * @return pro the profit
	 * */
	public int getProfit() {
		ProfitDao pd=new ProfitDaoImpl();
		int pro=0;
		List<Profit> l=pd.getList();
		for(Profit p:l){
			pro+=p.getNumber()*p.getPrice()*Rate.getRate();
		}
		
		return pro;
	
	}
	
	
	
}
