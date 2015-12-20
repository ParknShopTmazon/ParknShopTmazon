package com.tmazon.domain;

/*
 * product_id int AUTO_INCREMENT,
	shop_id int NOT NULL,
	name varchar(50) NOT NULL,
	price decimal(10,2) NOT NULL,
	discount_price decimal(10,2) NOT NULL,
	category varchar(50) NOT NULL,
	stock_num int NOT NULL,
	sold_num int NOT NULL,
	description text NOT NULL,
	picture varchar(100),
	PRIMARY KEY (product_id),
	FOREIGN KEY (shop_id) REFERENCES shop(shop_id),
	FOREIGN KEY (category) REFERENCES category(category)
 */

public class Product {

	private Integer productId;
	private Integer shopId;
	private String name;
	private Double price;
	private Double discountPrice;
	private String category;
	private Integer stockNum;
	private Integer soldNum;
	private String description;
	private String picture;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getStockNum() {
		return stockNum;
	}
	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
	}
	public Integer getSoldNum() {
		return soldNum;
	}
	public void setSoldNum(Integer soldNum) {
		this.soldNum = soldNum;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Product(Integer productId, Integer shopId, String name, Double price, Double discountPrice, String category,
			Integer stockNum, Integer soldNum, String description, String picture) {
		super();
		this.productId = productId;
		this.shopId = shopId;
		this.name = name;
		this.price = price;
		this.discountPrice = discountPrice;
		this.category = category;
		this.stockNum = stockNum;
		this.soldNum = soldNum;
		this.description = description;
		this.picture = picture;
	}

	public Product() {
	}

	
}
