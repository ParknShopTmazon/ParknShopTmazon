package com.tmazon.domain;

public class OrderInfo {

	private Product product;
	private Delivery delivery;
	
	private Integer orderId;
	private Integer deliveryId;
	private Integer quantity;
	private Integer productId;
	private String waybill;
	public OrderInfo(Integer orderId, Integer deliveryId, Integer quantity, Integer productId, String waybill) {
		super();
		this.orderId = orderId;
		this.deliveryId = deliveryId;
		this.quantity = quantity;
		this.productId = productId;
		this.waybill = waybill;
	}
	public OrderInfo() {
		super();
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Integer deliveryId) {
		this.deliveryId = deliveryId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getWaybill() {
		return waybill;
	}
	public void setWaybill(String waybill) {
		this.waybill = waybill;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deliveryId == null) ? 0 : deliveryId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		OrderInfo other = (OrderInfo) obj;
		if (deliveryId == null) {
			if (other.deliveryId != null)
				return false;
		} else if (!deliveryId.equals(other.deliveryId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", deliveryId=" + deliveryId + ", quantity=" + quantity
				+ ", productId=" + productId + "]";
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	
	
	
}
