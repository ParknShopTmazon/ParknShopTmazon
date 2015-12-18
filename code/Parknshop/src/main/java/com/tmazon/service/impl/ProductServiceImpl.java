package com.tmazon.service.impl;

import java.util.List;

import com.tmazon.dao.ProductDao;
import com.tmazon.dao.UserDao;
import com.tmazon.domain.Product;
import com.tmazon.service.ProductService;
import com.tmazon.util.BasicFactory;

public class ProductServiceImpl implements ProductService{

	private ProductDao productDao = BasicFactory.getImpl(ProductDao.class);
	
	public List<Product> select(Product product) {
		
		return productDao.select(product);
	}

}
