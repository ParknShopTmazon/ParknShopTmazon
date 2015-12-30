package com.tmazon.service.impl;

import java.util.List;

import com.tmazon.dao.ProductDao;
import com.tmazon.dao.ProductInfoDao;
import com.tmazon.domain.Product;
import com.tmazon.domain.ProductInfo;
import com.tmazon.service.ProductService;
import com.tmazon.util.BasicFactory;

public class ProductServiceImpl implements ProductService{

	private ProductDao productDao = BasicFactory.getImpl(ProductDao.class);
	private ProductInfoDao productInfoDao = BasicFactory.getImpl(ProductInfoDao.class);
	
	public List<Product> select(Product product) {
		return productDao.select(product);
	}

	public Product getProductById(Integer id) {
		
		return productDao.findById(id);
	}

	public ProductInfo getProductInfo(Product product) {
		
		return productInfoDao.getByProductId(product.getProductId());
	}

	public ProductInfo getProductInfo(Integer productId) {
		
		return productInfoDao.getByProductId(productId);
	}

	public boolean insert(Product product) {
		// TODO Auto-generated method stub
		return productDao.insert(product);
	}

	public boolean modify(Product product) {
		// TODO Auto-generated method stub
		return productDao.modify(product);
	}

	public boolean delect(Product product) {
		// TODO Auto-generated method stub
		return productDao.delect(product);
	}

	public String[] findAllCategory() {
		return productDao.findAllCategory();
	}

}
