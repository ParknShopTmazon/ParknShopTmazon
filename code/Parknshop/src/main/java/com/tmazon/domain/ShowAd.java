package com.tmazon.domain;

import java.io.Serializable;

public class ShowAd implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Product product;
	private Shop  shop;
	private Advertisement ad;
	
	
	
	public ShowAd(Product product, Shop shop, Advertisement ad) {
		super();
		this.product = product;
		this.shop = shop;
		this.ad = ad;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Advertisement getAd() {
		return ad;
	}
	public void setAd(Advertisement ad) {
		this.ad = ad;
	}
	
	
}
