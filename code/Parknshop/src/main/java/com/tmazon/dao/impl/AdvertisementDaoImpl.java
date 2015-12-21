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
		ArrayList<Object> params = new ArrayList<Object>();
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<Advertisement> result=runner.query(sql, new BeanListHandler<Advertisement>(Advertisement.class),params.toArray());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean insert(Advertisement advertisement){
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		String sql="INSERT INTO advertisement(productID,cost) VALUES(?,?)";
		try {
			runner.insert(sql,new BeanHandler<Advertisement>(Advertisement.class),advertisement.getProductID(),advertisement.getCost());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean update(Advertisement advertisement){
		String sql="UPDATE advertisement SET cost = ? WHERE adId = ?";
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.update(sql,advertisement.getCost(),advertisement.getAdId());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean delete(int  id){
		String sql="DELETE FROM advertisement WHERE adId = ?";
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.update(sql,id);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
