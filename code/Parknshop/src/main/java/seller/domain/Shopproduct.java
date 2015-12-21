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
/*    */ public class Shopproduct
/*    */   implements Serializable
/*    */ {
/*    */   private Integer shopProductId;
/*    */   private Integer shopInfoId;
/*    */   private Integer productId;
/*    */   private Integer productStock;
/*    */   private Double producePrice;
/* 19 */   private Set shoppingcarts = new HashSet(0);
/* 20 */   private Set userfavorites = new HashSet(0);
/* 21 */   private Set userorders = new HashSet(0);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Integer getShopProductId()
/*    */   {
/* 30 */     return this.shopProductId;
/*    */   }
/*    */   
/*    */   public void setShopProductId(Integer shopProductId) {
/* 34 */     this.shopProductId = shopProductId;
/*    */   }
/*    */   
/*    */   public Integer getShopInfoId() {
/* 38 */     return this.shopInfoId;
/*    */   }
/*    */   
/*    */   public void setShopInfoId(Integer shopInfoId) {
/* 42 */     this.shopInfoId = shopInfoId;
/*    */   }
/*    */   
/*    */   public Integer getProductId() {
/* 46 */     return this.productId;
/*    */   }
/*    */   
/*    */   public void setProductId(Integer productId) {
/* 50 */     this.productId = productId;
/*    */   }
/*    */   
/*    */   public Integer getProductStock() {
/* 54 */     return this.productStock;
/*    */   }
/*    */   
/*    */   public void setProductStock(Integer productStock) {
/* 58 */     this.productStock = productStock;
/*    */   }
/*    */   
/*    */   public Double getProducePrice() {
/* 62 */     return this.producePrice;
/*    */   }
/*    */   
/*    */   public void setProducePrice(Double producePrice) {
/* 66 */     this.producePrice = producePrice;
/*    */   }
/*    */   
/*    */   public Set getShoppingcarts() {
/* 70 */     return this.shoppingcarts;
/*    */   }
/*    */   
/*    */   public void setShoppingcarts(Set shoppingcarts) {
/* 74 */     this.shoppingcarts = shoppingcarts;
/*    */   }
/*    */   
/*    */   public Set getUserfavorites() {
/* 78 */     return this.userfavorites;
/*    */   }
/*    */   
/*    */   public void setUserfavorites(Set userfavorites) {
/* 82 */     this.userfavorites = userfavorites;
/*    */   }
/*    */   
/*    */   public Set getUserorders() {
/* 86 */     return this.userorders;
/*    */   }
/*    */   
/*    */   public void setUserorders(Set userorders) {
/* 90 */     this.userorders = userorders;
/*    */   }
/*    */ }

