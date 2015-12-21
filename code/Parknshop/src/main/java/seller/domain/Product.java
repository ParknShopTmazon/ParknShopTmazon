package seller.domain;

/*
 * product_id int AUTO_INCREMENT,
	shop_id int NOT NULL,
	name varchar(50) NOT NULL,
	price decimal(10,2) NOT NULL,
	discont_price decimal(10,2) NOT NULL,
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

	private String shopname;
	private String productname;
	private String remark;
	private String price;
	private String productid;

	public String getProductId() {
		return productid;
	}
	public void setProductId(String productid) {
		this.productid = productid;
	}
	public String getshopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getproductname() {
		return productname;
	}
	public void setName(String productname) {
		this.productname = productname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String remark() {
		return remark;
	}
	public void setremark(String remark) {
		this.remark = remark;
	}
	
	public Product(String shopname,String productname, String remark,String price,String productid) {
		super();
		this.productid = productid;
		this.shopname = shopname;
		this.productname = productname;
		this.price = price;
		this.remark=remark;
	}

	public Product() {
	}

	
}
