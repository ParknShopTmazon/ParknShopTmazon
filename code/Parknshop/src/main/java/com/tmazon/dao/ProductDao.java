package com.tmazon.dao;

import java.util.List;

import com.tmazon.domain.Product;

public interface ProductDao {

	public List<Product> select(Product product);
	
	public List<Product> selectInLike(Product product);
	
	public Product findByName(String name);
	
	public Product findById(Integer id);
	
	public boolean insert(Product product);
	
	public boolean modify(Product product);
	
	//update the product state
	public boolean delete(Product product);
	
	public String[] findAllCategory();
	
	public Product findOnSellById(Integer id);
	
	public List<Product> selectOnSell(Product product);
	
	public List<Product> findByShopId(Integer shopId);
	
	//for add order
	public boolean updateStockNum(Product product);
}
