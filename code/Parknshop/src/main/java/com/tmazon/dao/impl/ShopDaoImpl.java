package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.ShopDao;
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

	public Shop findById(Integer id) {
		
		List<Shop> list = select(new Shop(id, null, null, null));
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}

}
