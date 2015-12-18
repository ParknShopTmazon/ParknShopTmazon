package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.ProductInfoDao;
import com.tmazon.domain.ProductInfo;
import com.tmazon.util.DaoUtil;

public class ProductInfoDaoImpl implements ProductInfoDao {

	public List<ProductInfo> select(ProductInfo productInfo) {
		StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM product_info WHERE 1=1 ");
		ArrayList<Object> params = new ArrayList<Object>();
		if (productInfo.getProductId() != null) {
			sqlBuilder.append("AND product_id=? ");
			params.add(productInfo.getProductId());
		}
		if (productInfo.getSize() != null) {
			sqlBuilder.append("AND size = ? ");
			params.add(productInfo.getSize());
		}
		if (productInfo.getColor() != null) {
			sqlBuilder.append("AND color=? ");
			params.add(productInfo.getColor());
		}
		
		String sql = sqlBuilder.toString();
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<ProductInfo> result = runner.query(sql, new BeanListHandler<ProductInfo>(ProductInfo.class), params.toArray());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ProductInfo getByProductId(Integer id) {
		
		List<ProductInfo> list = select(new ProductInfo(id, null, null));
		
		if(!list.isEmpty())
			return list.get(0);
		
		return null;
	}

}
