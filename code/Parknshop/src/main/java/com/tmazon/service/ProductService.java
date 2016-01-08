package com.tmazon.service;

import java.util.List;

import com.tmazon.domain.Product;
import com.tmazon.domain.ProductInfo;

public interface ProductService {

	public List<Product> select(Product product );
	
	public List<Product> selectInLike(Product product );
	
	public Product getProductById(Integer id);
	
	public ProductInfo getProductInfo(Product product);
	
	public ProductInfo getProductInfo(Integer productId);
	
	public boolean insert(Product product);
	
	public boolean modify(Product product);
	
	//update the product state
	public boolean delete(Product product);
	
	public String[] findAllCategory();
	
	public Product findOnSellById(Integer id);
	
	public List<Product> selectOnSell(Product product);
	
	public List<Product> findByShopId(Integer shopId);
}
