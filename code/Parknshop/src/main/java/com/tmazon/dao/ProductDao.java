package com.tmazon.dao;

import java.util.List;

import com.tmazon.domain.Product;

public interface ProductDao {

	public List<Product> select(Product product);
	
	public Product findByName(String name);
}
