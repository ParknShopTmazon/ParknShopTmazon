package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.ShopApplyDao;
import com.tmazon.domain.Shop;
import com.tmazon.util.DaoUtil;

public class ShopApplyDaoImpl implements ShopApplyDao {

	public List<Shop> getApply() {
		String sql="SELECT *FROM shop WHERE	STATUS=?";
		String param="0";		
		List<Shop>	list=null;
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
		list=runner.query(sql,new BeanListHandler<Shop>(Shop.class),param);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			return list;
		}
		
	}

}
