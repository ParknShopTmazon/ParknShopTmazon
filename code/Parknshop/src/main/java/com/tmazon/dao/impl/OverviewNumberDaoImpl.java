package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.OverviewNumberDao;
import com.tmazon.domain.User;
import com.tmazon.util.DaoUtil;
import com.tmazon.util.OverviewUser;

public class OverviewNumberDaoImpl implements OverviewNumberDao {



	public List<User> getShopOwner() {
		String sql=OverviewUser.sql;
		List<User> result=null;
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		Object[] role={"shop_owner"};
		try {
			 result=runner.query(sql, new BeanListHandler<User>(User.class),role);
//			 if(result==null){
//				 System.out.println("godi");
//			 }
		} catch (SQLException e) {
			System.out.println("dao层");
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public List<User> getCustomerOwner() {
		String sql=OverviewUser.sql;
		List<User> result=null;
		Object[] role={"customer"};
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			 result=runner.query(sql, new BeanListHandler<User>(User.class),role);
		} catch (SQLException e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

}
