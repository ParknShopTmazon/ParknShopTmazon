package com.tmazon.domain;

public class History {
	
	private OrderInfo orderInfo;
	private Order order;
	private Shop shop;
	private User user;
	private Product product;
	
	public History(OrderInfo orderInfo,Order order,Shop shop,User user,Product product){
		
		this.orderInfo=orderInfo;
		this.order=order;
		this.shop=shop;
		this.user=user;
		this.product=product;
	}
	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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
