/*    */ package admin.entity;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Shoppingcart
/*    */   implements Serializable
/*    */ {
/*    */   private Integer cartId;
/*    */   private Customerinfo customerinfo;
/*    */   private Shopproduct shopproduct;
/*    */   private Integer productBuyNum;
/*    */   
/*    */   public Shoppingcart() {}
/*    */   
/*    */   public Shoppingcart(Integer cartId, Customerinfo customerinfo, Shopproduct shopproduct, Integer productBuyNum)
/*    */   {
/* 25 */     this.cartId = cartId;
/* 26 */     this.customerinfo = customerinfo;
/* 27 */     this.shopproduct = shopproduct;
/* 28 */     this.productBuyNum = productBuyNum;
/*    */   }
/*    */   
/*    */ 
/*    */   public Integer getCartId()
/*    */   {
/* 34 */     return this.cartId;
/*    */   }
/*    */   
/*    */   public void setCartId(Integer cartId) {
/* 38 */     this.cartId = cartId;
/*    */   }
/*    */   
/*    */   public Customerinfo getCustomerinfo() {
/* 42 */     return this.customerinfo;
/*    */   }
/*    */   
/*    */   public void setCustomerinfo(Customerinfo customerinfo) {
/* 46 */     this.customerinfo = customerinfo;
/*    */   }
/*    */   
/*    */   public Shopproduct getShopproduct() {
/* 50 */     return this.shopproduct;
/*    */   }
/*    */   
/*    */   public void setShopproduct(Shopproduct shopproduct) {
/* 54 */     this.shopproduct = shopproduct;
/*    */   }
/*    */   
/*    */   public Integer getProductBuyNum() {
/* 58 */     return this.productBuyNum;
/*    */   }
/*    */   
/*    */   public void setProductBuyNum(Integer productBuyNum) {
/* 62 */     this.productBuyNum = productBuyNum;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\entity\Shoppingcart.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */