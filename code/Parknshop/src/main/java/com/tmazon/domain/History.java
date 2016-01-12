package com.tmazon.domain;

import java.util.List;

public class History {
	
	private OrderInfo orderInfo;
	private Shop shop;
	private User user;
	private Product product;
	private String dealTime;
	private double cost;
	

	public History(OrderInfo orderInfo,Shop shop,User user,Product product){
		
		this.orderInfo = orderInfo;
		this.shop=shop;
		this.user=user;
		this.product=product;
	}

	public String getDealTime() {
		return orderInfo.getDealTime().toString();
	}

	public double getCost() {
		return orderInfo.getQuantity() * product.getDiscountPrice();
	}
	public double getRate()
	{
		String rateStr = this.orderInfo.getRate();
		if(rateStr == null || rateStr.equals(""))
		{
			System.out.println("Error::History::getRate::RateStr is null");
			return 0.0;
		}
		else
		{
			return Double.valueOf(rateStr);
		}
	}

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	
}
