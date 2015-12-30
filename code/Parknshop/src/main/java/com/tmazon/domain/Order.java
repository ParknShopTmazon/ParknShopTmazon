package com.tmazon.domain;

import java.util.Date;
import java.util.List;

public class Order {
	
	public static final String PAY_TYPE_CASH_ON_DELIVERY = "cash_on_delivery";
	public static final String PAY_TYPE_ONLINE_PAYMENT = "online_payment";
	
	public static final String STATUS_UNPAID = "unpaid";
	public static final String STATUS_PAID = "paid";
	public static final String STATUS_ON_DELIVERY = "on_delivery";
	public static final String STATUS_ON_DELIVERY_AND_UNPAID = "on_delivery_AND_unpaid";
	public static final String STATUS_CONFIRM_RECEIPT = "confirm_receipt";

	private Integer orderId;
	private String payType;
	private String status;
	private Date orderTime;
	private Date deliveryTime;
	private Date dealTime;
	private Integer userId;
	private Integer addressId;
	
	private  List<OrderInfo> orderInfos;
	
	
	public Order(Integer orderId, String payType, String status, Date orderTime, Date deliveryTime, Date dealTime,
			Integer userId, Integer addressId) {
		super();
		this.orderId = orderId;
		this.payType = payType;
		this.status = status;
		this.orderTime = orderTime;
		this.deliveryTime = deliveryTime;
		this.dealTime = dealTime;
		this.userId = userId;
		this.addressId = addressId;
	}

	public Order(Integer orderId, String payType, String status, Date orderTime, Integer userId, Integer addressId) {
		super();
		this.orderId = orderId;
		this.payType = payType;
		this.status = status;
		this.orderTime = orderTime;
		this.userId = userId;
		this.addressId = addressId;
	}
	public Order() {
		super();
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	
	public Date getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public Date getDealTime() {
		return dealTime;
	}
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderTime == null) ? 0 : orderTime.hashCode());
		result = prime * result + ((payType == null) ? 0 : payType.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderTime == null) {
			if (other.orderTime != null)
				return false;
		} else if (!orderTime.equals(other.orderTime))
			return false;
		if (payType == null) {
			if (other.payType != null)
				return false;
		} else if (!payType.equals(other.payType))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", payType=" + payType + ", status=" + status + ", orderTime=" + orderTime
				+ ", userId=" + userId + ", addressId=" + addressId + "]";
	}
	public List<OrderInfo> getOrderInfos() {
		return orderInfos;
	}
	public void setOrderInfos(List<OrderInfo> orderInfos) {
		this.orderInfos = orderInfos;
	}
	
	
	
}
