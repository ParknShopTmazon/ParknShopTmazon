package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.ProductDao;
import com.tmazon.domain.Product;
import com.tmazon.util.DaoUtil;

public class ProductDaoImpl implements ProductDao{

	public List<Product> select(Product product) {
		StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM product WHERE 1=1 ");
		ArrayList<Object> params = new ArrayList<Object>();
		if (product.getProductId() != null) {
			sqlBuilder.append("AND productId = ? ");
			params.add(product.getProductId());
		}
		if (product.getShopId() != null) {
			sqlBuilder.append("AND shopId = ? ");
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
		if (product.getDiscountPrice() != null) {
			sqlBuilder.append("AND discountPrice = ? ");
			params.add(product.getDiscountPrice());
		}
		if (product.getCategory() != null) {
			sqlBuilder.append("AND category = ? ");
			params.add(product.getCategory());
		}
		if (product.getStockNum() != null) {
			sqlBuilder.append("AND stockNum = ? ");
			params.add(product.getStockNum());
		}
		if(product.getSoldNum()!=null){
			sqlBuilder.append(" AND soldNum=? ");
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
		sqlBuilder.append(" order by soldNum  DESC");
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

	public List<Product> findByCategory(String category) {
		// TODO Auto-generated method stub
		List<Product> list =select(new Product(null, null, null, null, null,category,null,null,null,null));
		if (list != null && !list.isEmpty()) {
			return list;
		}
		return null;
	}

	public Product findById(Integer id) {
		
		List<Product> list = select(new Product(id, null, null, null, null, null, null, null, null, null));
		
		if(list.isEmpty()){
			return null;
		}else {
			return list.get(0);
		}
		
	}
	
}
