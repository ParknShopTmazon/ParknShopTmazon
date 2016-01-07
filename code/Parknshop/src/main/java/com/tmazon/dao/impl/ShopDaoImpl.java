package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.ShopDao;
import com.tmazon.domain.Product;
import com.tmazon.domain.Shop;
import com.tmazon.util.DaoUtil;

public class ShopDaoImpl implements ShopDao {


	public List<Shop> select(Shop shop) {
		StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM shop WHERE 1=1 ");
		ArrayList<Object> params = new ArrayList<Object>();
		if(shop.getName() != null){
			sqlBuilder.append("AND name = ? ");
			params.add(shop.getName());
		}
		if(shop.getOwner() != null){
			sqlBuilder.append("AND owner = ? ");
			params.add(shop.getOwner());
		}
		if(shop.getShopId() != null){
			sqlBuilder.append("AND shopId = ? ");
			params.add(shop.getShopId());
		}
		if(shop.getType() != null){
			sqlBuilder.append("AND type = ? ");
			params.add(shop.getType());
		}
		if(shop.getStatus() != null){
			sqlBuilder.append("AND status = ? ");
			params.add(shop.getStatus());
		}
		if(shop.getPicture() != null){
			sqlBuilder.append("AND picture = ?");
			params.add(shop.getPicture());
		}
		String sql = sqlBuilder.toString();
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<Shop> result = runner.query(sql, new BeanListHandler<Shop>(Shop.class), params.toArray());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public boolean insert(Shop shop) {
		String sql = "INSERT INTO shop VALUES (?, ?, ?, ?, ?, ?)";
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.insert(sql, new BeanHandler<Shop>(Shop.class), shop.getShopId(), shop.getName(), shop.getType(), shop.getStatus(), shop.getOwner(),shop.getPicture());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Shop shop) {

		StringBuilder sqlBuilder = new StringBuilder("update shop set status=? ");
		
		ArrayList<Object> params = new ArrayList<Object>();
        if(shop.getStatus().equals(Shop.STATUS_SUCCESS)){
			params.add(Shop.STATUS_SUCCESS);
        }else{
			params.add(Shop.STATUS_CHECKING);
		}
        
		if (shop.getName() != null) {
			sqlBuilder.append(" ,name = ? ");
			params.add(shop.getName());
		}
		if (shop.getType() != null) {
			sqlBuilder.append(" ,type = ? ");
			params.add(shop.getType());
		}
		if(shop.getPicture()!=null){
			sqlBuilder.append(" ,picture=? ");
			params.add(shop.getPicture());
		}
		sqlBuilder.append(" where shopId=?");
		System.out.println("update shopId="+shop.getShopId());
		params.add(shop.getShopId());
		String sql = sqlBuilder.toString();
        System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.insert(sql, new BeanListHandler<Shop>(Shop.class), params.toArray());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Shop shop) {

		String sql = "DELETE FROM shop WHERE shopId = ?";
		System.out.println(sql);
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.update(sql, shop.getShopId());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Shop findById(Integer id) {
		
		
		List<Shop> list = select(new Shop(id, null, null, null, null,null));		
		if(!list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
	
	
	public List<Shop> selectInLike(Shop shop) {
		StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM shop WHERE 1=1 ");
		ArrayList<Object> params = new ArrayList<Object>();
		if(shop.getName() != null){
			sqlBuilder.append("AND name like ? ");
			params.add("%"+shop.getName()+"%");
		}
		if(shop.getOwner() != null){
			sqlBuilder.append("AND owner = ? ");
			params.add(shop.getOwner());
		}
		if(shop.getShopId() != null){
			sqlBuilder.append("AND shopId = ? ");
			params.add(shop.getShopId());
		}
		if(shop.getType() != null){
			sqlBuilder.append("AND type = ? ");
			params.add(shop.getType());
		}
		if(shop.getStatus() != null){
			sqlBuilder.append("AND status = ? ");
			params.add(shop.getStatus());
		}
		if(shop.getPicture() != null){
			sqlBuilder.append("AND picture = ?");
			params.add(shop.getPicture());
		}
		String sql = sqlBuilder.toString();
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<Shop> result = runner.query(sql, new BeanListHandler<Shop>(Shop.class), params.toArray());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
