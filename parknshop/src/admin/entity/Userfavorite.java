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
/*    */ public class Userfavorite
/*    */   implements Serializable
/*    */ {
/*    */   private Integer favoritId;
/*    */   private Customerinfo customerinfo;
/*    */   private Shopproduct shopproduct;
/*    */   
/*    */   public Userfavorite() {}
/*    */   
/*    */   public Userfavorite(Integer favoritId, Customerinfo customerinfo, Shopproduct shopproduct)
/*    */   {
/* 24 */     this.favoritId = favoritId;
/* 25 */     this.customerinfo = customerinfo;
/* 26 */     this.shopproduct = shopproduct;
/*    */   }
/*    */   
/*    */ 
/*    */   public Integer getFavoritId()
/*    */   {
/* 32 */     return this.favoritId;
/*    */   }
/*    */   
/*    */   public void setFavoritId(Integer favoritId) {
/* 36 */     this.favoritId = favoritId;
/*    */   }
/*    */   
/*    */   public Customerinfo getCustomerinfo() {
/* 40 */     return this.customerinfo;
/*    */   }
/*    */   
/*    */   public void setCustomerinfo(Customerinfo customerinfo) {
/* 44 */     this.customerinfo = customerinfo;
/*    */   }
/*    */   
/*    */   public Shopproduct getShopproduct() {
/* 48 */     return this.shopproduct;
/*    */   }
/*    */   
/*    */   public void setShopproduct(Shopproduct shopproduct) {
/* 52 */     this.shopproduct = shopproduct;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\entity\Userfavorite.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */