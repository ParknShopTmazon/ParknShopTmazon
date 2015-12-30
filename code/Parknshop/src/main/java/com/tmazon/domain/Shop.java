package com.tmazon.domain;

public class Shop {

	public static final String STATUS_CHECKING = "checking";
	public static final String STATUS_FAIL = "fail";
	public static final String STATUS_SUCCESS = "success";

	public static final String TYPE_PERSON = "person";
	public static final String TYPE_COMPANY = "company";
	
	private Integer shopId;
	private String name;
	private String type;
	private String status;
	private Integer owner;
	private String picture;
	
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Shop(Integer shopId, String name, String type, String status, Integer owner) {
		super();
		this.shopId = shopId;
		this.name = name;
		this.type = type;
		this.status = status;
		this.owner = owner;
	}

	public Shop() {
		super();
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getOwner() {
		return owner;
	}

	public void setOwner(Integer owner) {
		this.owner = owner;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((shopId == null) ? 0 : shopId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Shop other = (Shop) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (shopId == null) {
			if (other.shopId != null)
				return false;
		} else if (!shopId.equals(other.shopId))
			return false;

		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (status == null) {
			if (other.status != null) {
				return false;
			} else if (!status.equals(other.status)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", name=" + name + ", type=" + type + ", owner=" + owner + ", status="
				+ status + "]";
	}

}
