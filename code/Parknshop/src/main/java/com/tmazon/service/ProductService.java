package com.tmazon.service;

import java.util.List;

import com.tmazon.domain.Product;
import com.tmazon.domain.ProductInfo;

public interface ProductService {

	public List<Product> select(Product product );
	
	public Product getProductById(Integer id);
	
	public ProductInfo getProductInfo(Product product);
	
	public ProductInfo getProductInfo(Integer productId);
	
}
