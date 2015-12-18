package com.tmazon.dao;

import java.util.List;

import com.tmazon.domain.ProductInfo;

public interface ProductInfoDao {

	public List<ProductInfo> select(ProductInfo productInfo);
	
	public ProductInfo getByProductId(Integer id);
	
}
