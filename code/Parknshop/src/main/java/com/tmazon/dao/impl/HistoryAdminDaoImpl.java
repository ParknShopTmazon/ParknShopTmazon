package com.tmazon.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.HistoryAdminDao;
import com.tmazon.domain.Order;
import com.tmazon.util.DaoUtil;

public class HistoryAdminDaoImpl implements HistoryAdminDao{

	public List<Order> search(Date start,Date end) {
		String sql="SELECT * FROM Order WHERE orderTime BETWEEN ? and ?";
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(start);
		params.add(end);
		try {
			List<Order> order = runner.query(sql, new BeanListHandler<Order>(Order.class),params.toArray());
			return order;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
