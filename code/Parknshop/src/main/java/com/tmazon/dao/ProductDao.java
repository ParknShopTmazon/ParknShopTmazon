package com.tmazon.dao;

import java.util.List;

import com.tmazon.domain.Product;

public interface ProductDao {

	public List<Product> select(Product product);
	
	public Product findByName(String name);
	
	public Product findById(Integer id);
	
	public boolean insert(Product product);
	
	public boolean modify(Product product);
	
	//update the product state
	public boolean delect(Product product);
	
	public String[] findAllCategory();
}
