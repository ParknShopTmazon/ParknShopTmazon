package com.tmazon.domain;

public class Product {

	public static final String CATEGORY_TV = "TV& Home Theater";
	public static final String CATEGORY_COMP = "Computers & Tablets";
	public static final String CATEGORY_CELL = "Cell Phones";
	public static final String CATEGORY_CAMER = "Cameras & Camcorders";
	public static final String CATEGORY_AUDIO = "Audio";
	public static final String CATEGORY_CAR = "Car Electronics & GPS";
	public static final String CATEGORY_VIDEO = "Video, Games, Movies & Music";
	public static final String CATEGORY_HEALTH = "Health, Fitness & Sports";
	public static final String CATEGORY_HOME = "Home & Office";

	public static final String STATUS_ONSELL ="onsell";
	public static final String STATUS_PULL ="pulloff";
	
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
	private String status;
	
	private Shop shop;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
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
	public Product(Integer productId, Integer shopId, String name, Double price, Double discountPrice, String category,
			Integer stockNum, Integer soldNum, String description, String picture, String status) {
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
		this.status = status;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}

	
	
}
