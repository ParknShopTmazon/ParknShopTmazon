package com.tmazon.dao.impl;

import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.HistoryAdminDao;
import com.tmazon.domain.Order;
import com.tmazon.domain.OrderInfo;
import com.tmazon.util.DaoUtil;

public class HistoryAdminDaoImpl implements HistoryAdminDao{
	
	public List<OrderInfo> search(Date start,Date end) {
		
		StringBuilder sql= new StringBuilder("SELECT * FROM orderinfo WHERE status = ? ");
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(OrderInfo.STATUS_CONFIRM_RECEIPT);
		if(start != null)
		{
			sql.append(" AND dealtime >= ? ");
			params.add(start);
		}
		if(end != null)
		{
			sql.append(" AND dealtime <= ? ");
			params.add(end);
		}
		sql.append("ORDER BY dealTime DESC , orderId DESC");
		System.out.println(sql);
		try {
			
			List<OrderInfo> orderInfoList = runner.query(sql.toString(), new BeanListHandler<OrderInfo>(OrderInfo.class),params.toArray());
			return orderInfoList;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	
}
