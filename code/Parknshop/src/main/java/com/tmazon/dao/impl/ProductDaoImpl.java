package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
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
			sqlBuilder.append("AND name = ? ");
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
		if(product.getStatus() != null){
			sqlBuilder.append(" AND status=? ");
			params.add(product.getStatus());
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

	public List<Product> findByCategory(String category) {
		// TODO Auto-generated method stub
		List<Product> list =select(new Product(null, null, null, null, null,category,null,null,null,null));
		if (list != null && !list.isEmpty()) {
			return list;
		}
		return null;
	}

	public Product findById(Integer id) {
		
		List<Product> list = select(new Product(id, null, null, null, null, null, null, null, null, null, null));
		
		if(list.isEmpty()){
			return null;
		}else {
			return list.get(0);
		}
		
	}

	public boolean insert(Product product) {
		product.setStatus("");
		String sql = "INSERT INTO user(shopId,name,price,discountPrice,category,stockNum,description,picture) VALUES (?, ?, ?,  ? , ? , ? , ? , ?, ?)";
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.insert(sql, new BeanHandler<Product>(Product.class), product.getShopId(), product.getName(), product.getPrice(),product.getDiscountPrice(),product.getCategory(),product.getStockNum(),product.getDescription(),product.getPicture(),product.getStatus());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean modify(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delect(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public String[] findAllCategory() {
		String sql = "SELECT * FROM category";
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			
			List<Object[]> result = runner.query(sql, new ArrayListHandler());
			List<String> categories = new ArrayList<String>();
			for (Object[] objects : result) {
				categories.add((String) objects[0]);
			}
			
			return categories.toArray(new String[0]);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
