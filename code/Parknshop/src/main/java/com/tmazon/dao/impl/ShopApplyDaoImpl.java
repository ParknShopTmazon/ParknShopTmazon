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
		String param= Shop.STATUS_CHECKING;		
		List<Shop>	list=null;
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			list=runner.query(sql,new BeanListHandler<Shop>(Shop.class),param);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean setStatus(int id, boolean isOk) {
		String sql = "UPDATE  shop SET STATUS = ? WHERE shopId = ? ";
		String status=isOk?Shop.STATUS_SUCCESS:Shop.STATUS_FAIL;
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		int ans;
		try {
			ans = runner.update(sql, status, id);
			return ans > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
			
	}

}
