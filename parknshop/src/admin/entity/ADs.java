/*    */ package admin.entity;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ADs
/*    */   implements Serializable
/*    */ {
/*    */   private Integer adId;
/*    */   private String productId;
/*    */   private String imagePath;
/*    */   private String URL;
/*    */   
/*    */   public String getURL()
/*    */   {
/* 18 */     return this.URL;
/*    */   }
/*    */   
/* 21 */   public void setURL(String uRL) { this.URL = uRL; }
/*    */   
/*    */   public Integer getAdId()
/*    */   {
/* 25 */     return this.adId;
/*    */   }
/*    */   
/* 28 */   public void setAdId(Integer adId) { this.adId = adId; }
/*    */   
/*    */   public String getImagePath()
/*    */   {
/* 32 */     return this.imagePath;
/*    */   }
/*    */   
/* 35 */   public void setImagePath(String imagePath) { this.imagePath = imagePath; }
/*    */   
/*    */   public String getProductId() {
/* 38 */     return this.productId;
/*    */   }
/*    */   
/* 41 */   public void setProductId(String productId) { this.productId = productId; }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\entity\ADs.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */