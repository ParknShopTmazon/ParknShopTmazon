package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.domain.Advertisement;
import com.tmazon.util.DaoUtil;
import com.tmazon.dao.AdvertisementDao;

public class AdvertisementDaoImpl implements AdvertisementDao{
	
	public List<Advertisement>  select(){
		
		String sql="SELECT * FROM advertisement WHERE 1=1 ";
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<Advertisement> adList=runner.query(sql, new BeanListHandler<Advertisement>(Advertisement.class));
			return adList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean insert(Integer productId,Integer cost, String picture){
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		String sql="INSERT INTO advertisement(productID,cost,picture) VALUES(?,?,?)";
//		ArrayList<Object> params =  new ArrayList<Object>();
//		params.add(productId);
//		params.add(cost);
//		params.add(picture);
		System.out.println(sql);
		try {
			runner.insert(sql,new BeanHandler<Advertisement>(Advertisement.class),productId,cost,picture);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	@SuppressWarnings("null")
	public boolean update(Integer productId,Integer cost,String picture){
		
		StringBuilder sql= new StringBuilder("UPDATE advertisement SET ");
		List<Object> params = new ArrayList<Object>();
		if(cost != null || !cost.equals(""))
		{
			sql.append("cost=? , ");
			params.add(cost);
		}
		if(picture != null || !picture.equals(""))
		{
			sql.append("picture=? ");
			params.add(picture);
		}
		sql.append(" WHERE productID =?");
		params.add(productId);
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		System.out.println(sql.toString());
		try {
			
			runner.update(sql.toString(),params.toArray());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteByProductId(Integer  productId){
		
		String sql="DELETE FROM advertisement WHERE productID = ?";
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		System.out.println(sql);
		try {
			runner.update(sql,productId);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
