/*    */ package seller.domain;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Shopinfo
/*    */   implements Serializable
/*    */ {
/*    */   private Integer shopInfoId;
/*    */   private String customerName;
/*    */   private String shopInfoName;
/*    */   private String shopInfoDescription;
/*    */   private int Status;
/*    */   private String status1;
/* 20 */   private Set shopproducts = new HashSet(0);
/*    */   
/*    */   public Integer getShopInfoId()
/*    */   {
/* 24 */     return this.shopInfoId;
/*    */   }
/*    */   
/* 27 */   public void setShopInfoId(Integer shopInfoId) { this.shopInfoId = shopInfoId; }
/*    */   
/*    */   public String getCustomerName() {
/* 30 */     return this.customerName;
/*    */   }
/*    */   
/* 33 */   public void setCustomerName(String customerName) { this.customerName = customerName; }
/*    */   
/*    */   public String getShopInfoName() {
/* 36 */     return this.shopInfoName;
/*    */   }
/*    */   
/* 39 */   public void setShopInfoName(String shopInfoName) { this.shopInfoName = shopInfoName; }
/*    */   
/*    */   public String getShopInfoDescription() {
/* 42 */     return this.shopInfoDescription;
/*    */   }
/*    */   
/* 45 */   public void setShopInfoDescription(String shopInfoDescription) { this.shopInfoDescription = shopInfoDescription; }
/*    */   
/*    */   public int getStatus() {
/* 48 */     return this.Status;
/*    */   }
/*    */   
/* 51 */   public void setStatus(int status) { this.Status = status; }
/*    */   
/*    */   public String getStatus1() {
/* 54 */     return this.status1;
/*    */   }
/*    */   
/* 57 */   public void setStatus1(String status1) { this.status1 = status1; }
/*    */   
/*    */   public Set getShopproducts() {
/* 60 */     return this.shopproducts;
/*    */   }
/*    */   
/* 63 */   public void setShopproducts(Set shopproducts) { this.shopproducts = shopproducts; }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\entity\Shopinfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */