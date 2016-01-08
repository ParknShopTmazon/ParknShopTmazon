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
		ArrayList<Object> params =  new ArrayList<Object>();
		params.add(productId);
		params.add(cost);
		params.add(picture);
		try {
			runner.insert(sql,new BeanHandler<Advertisement>(Advertisement.class),params);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean update(Advertisement advertisement){
		
		String sql="UPDATE advertisement SET cost = ? ,picture = ? WHERE adId = ?";
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(advertisement.getCost());
		params.add(advertisement.getPicture());
		params.add(advertisement.getAdId());
		try {
			runner.update(sql,params);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteById(int  adId){
		
		String sql="DELETE FROM advertisement WHERE adId = ?";
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.update(sql,adId);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
