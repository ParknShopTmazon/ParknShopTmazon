package com.tmazon.domain;
//class of profit about admin
public class Profit {
	private int productId;
	private int  price;
	private int quantity;
	public Profit(){}
	public int getProductId() {
		return productId;
	}
	public Profit(int productId, int price, int quantityr) {
		super();
		this.productId = productId;
		this.price = price;
		this.quantity= quantityr;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

	
}
