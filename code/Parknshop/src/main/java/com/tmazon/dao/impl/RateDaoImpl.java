package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.RateDao;
import com.tmazon.domain.Rate;
import com.tmazon.domain.Shop;
import com.tmazon.util.DaoUtil;

public class RateDaoImpl implements RateDao{

	public double getRate()
	{
		String sql = "SELECT * FROM rate";
		List<Rate> rateList = null;
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			rateList=runner.query(sql,new BeanListHandler<Rate>(Rate.class));
			System.out.println(sql+"\n Result::"+rateList.get(0).getRateNum());
			return rateList.get(0).getRateNum();
		} catch (Exception e) {
			e.printStackTrace();
			return 0.0;
		}
	}
	
	public boolean modifyRate(double rate){
		String sql="UPDATE rate SET rate = ? ";
		List<Rate> rateList = null;
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(""+rate);
		try {
			runner.update(sql,params);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
