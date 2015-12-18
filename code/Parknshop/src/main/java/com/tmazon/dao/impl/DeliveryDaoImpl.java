package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.DeliveryDao;
import com.tmazon.domain.Delivery;
import com.tmazon.util.DaoUtil;

public class DeliveryDaoImpl implements DeliveryDao {

	public List<Delivery> select(Delivery delivery) {
		
		StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM delivery WHERE 1=1 ");
		ArrayList<Object> params = new ArrayList<Object>();
		if(delivery.getCompany() != null){
			sqlBuilder.append("AND company = ? ");
			params.add(delivery.getCompany());
		}
		if(delivery.getDeliveryId() != null){
			sqlBuilder.append("AND delivery_id = ? ");
			params.add(delivery.getDeliveryId());
		}
		if(delivery.getPrice() != null){
			sqlBuilder.append("AND price = ? ");
			params.add(delivery.getPrice());
		}
		if(delivery.getType() != null){
			sqlBuilder.append("AND type = ? ");
			params.add(delivery.getType());
		}
		
		
		String sql = sqlBuilder.toString();
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<Delivery> result = runner.query(sql, new BeanListHandler<Delivery>(Delivery.class), params);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
