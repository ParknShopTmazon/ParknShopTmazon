package com.tmazon.domain;

import java.io.Serializable;

public class Advertisement implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int MAXNUM = 10;
	private Integer adId;
	private Integer productID;
	private Integer cost;
	private String picture;
	
	public Advertisement(){
		super();
	}
	public Advertisement(Integer adId,Integer productID,Integer cost,String picture){
		this.adId=adId;
		this.productID=productID;
		this.cost=cost;
		this.picture=picture;
	}
	public void setAdId(Integer adId){
		this.adId=adId;
	}
	public void setProductID(Integer productID){
		this.productID=productID;
	}
	public void setCost(Integer cost){
		this.cost=cost;
	}
	public Integer getAdId(){
		return adId;
	}
	public Integer getProductID(){
		return productID;
	}
	public Integer getCost(){
		return cost;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
}
