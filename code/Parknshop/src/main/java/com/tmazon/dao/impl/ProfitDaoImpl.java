package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.ProfitDao;
import com.tmazon.domain.Cart;
import com.tmazon.domain.Profit;
import com.tmazon.util.DaoUtil;

public class ProfitDaoImpl implements ProfitDao {
	private  List<Profit> list;
	/**
	 * the mothod is called before   calculate the profit
	 * 
	 * @return  List  contains Profit
	 * 
	 * */
	public List<Profit> getList() {
		String sql="SELECT product_id,price,quantity"+" FROM order_info oi,delivery d,orders o"
				       +" WHERE	o.order_id=oi.order_id AND o.delivery_id=d.delivery_id"
				       + "   AND o.status='complete'";
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			list=runner.query(sql,new BeanListHandler<Profit>(Profit.class));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}finally{
			return list;
		}
			
	}

}
