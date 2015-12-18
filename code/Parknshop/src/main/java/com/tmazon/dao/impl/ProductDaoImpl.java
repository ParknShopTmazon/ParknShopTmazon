package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.ProductDao;
import com.tmazon.domain.Product;
import com.tmazon.domain.User;
import com.tmazon.util.DaoUtil;

public class ProductDaoImpl implements ProductDao{

	public List<Product> select(Product product) {
		StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM product WHERE 1=1 ");
		ArrayList<Object> params = new ArrayList<Object>();
		if (product.getProductId() != null) {
			sqlBuilder.append("AND product_id = ? ");
			params.add(product.getProductId());
		}
		if (product.getShopId() != null) {
			sqlBuilder.append("AND shop_id = ? ");
			params.add(product.getShopId());
		}
		if (product.getName() != null) {
			product.setName("%"+product.getName()+"%");
			sqlBuilder.append("AND name like ? ");
			params.add(product.getName());
		}
		if (product.getPrice() != null) {
			sqlBuilder.append("AND price = ? ");
			params.add(product.getPrice());
		}
		if (product.getDiscontPrice() != null) {
			sqlBuilder.append("AND discont_price = ? ");
			params.add(product.getDiscontPrice());
		}
		if (product.getCategory() != null) {
			sqlBuilder.append("AND category = ? ");
			params.add(product.getCategory());
		}
		if (product.getStockNum() != null) {
			sqlBuilder.append("AND stock_num = ? ");
			params.add(product.getStockNum());
		}
		if(product.getSoldNum()!=null){
			sqlBuilder.append(" AND sold_num=? ");
			params.add(product.getSoldNum());
		}
		if(product.getDescription()!=null){
			sqlBuilder.append(" AND description=? ");
			params.add(product.getDescription());
		}
		if(product.getPicture()!=null){
			sqlBuilder.append(" AND picture=? ");
			params.add(product.getPicture());
		}
		
		String sql = sqlBuilder.toString();
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<Product> result = runner.query(sql, new BeanListHandler<Product>(Product.class), params.toArray());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Product findByName(String name) {
		// TODO Auto-generated method stub
		List<Product> list =select(new Product(null, null, name, null, null,null,null,null,null,null));
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public Product findByCategory(String category) {
		// TODO Auto-generated method stub
		List<Product> list =select(new Product(null, null, null, null, null,category,null,null,null,null));
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
}
