/*     */ package admin.entity;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Comments
/*     */   implements Serializable
/*     */ {
/*     */   private Integer commentId;
/*     */   private Integer userorder;
/*     */   private String productName;
/*     */   private Integer productId;
/*     */   private Integer shopId;
/*     */   private String shopName;
/*     */   private String sellerName;
/*     */   private String buyerName;
/*     */   private String comment;
/*     */   private Date time;
/*     */   private Integer level;
/*     */   private Integer Status;
/*     */   private String status1;
/*     */   
/*     */   public Integer getShopId()
/*     */   {
/*  34 */     return this.shopId;
/*     */   }
/*     */   
/*  37 */   public void setShopId(Integer shopId) { this.shopId = shopId; }
/*     */   
/*     */   public Integer getProductId() {
/*  40 */     return this.productId;
/*     */   }
/*     */   
/*  43 */   public void setProductId(Integer productId) { this.productId = productId; }
/*     */   
/*     */   public Integer getCommentId() {
/*  46 */     return this.commentId;
/*     */   }
/*     */   
/*  49 */   public void setCommentId(Integer commentId) { this.commentId = commentId; }
/*     */   
/*     */   public Integer getUserorder() {
/*  52 */     return this.userorder;
/*     */   }
/*     */   
/*  55 */   public void setUserorder(Integer userorder) { this.userorder = userorder; }
/*     */   
/*     */   public String getComment() {
/*  58 */     return this.comment;
/*     */   }
/*     */   
/*  61 */   public void setComment(String comment) { this.comment = comment; }
/*     */   
/*     */   public Date getTime() {
/*  64 */     return this.time;
/*     */   }
/*     */   
/*  67 */   public void setTime(Date time) { this.time = time; }
/*     */   
/*     */   public Integer getLevel() {
/*  70 */     return this.level;
/*     */   }
/*     */   
/*  73 */   public void setLevel(Integer level) { this.level = level; }
/*     */   
/*     */   public Integer getStatus() {
/*  76 */     return this.Status;
/*     */   }
/*     */   
/*  79 */   public void setStatus(Integer status) { this.Status = status; }
/*     */   
/*     */   public String getStatus1() {
/*  82 */     return this.status1;
/*     */   }
/*     */   
/*  85 */   public void setStatus1(String status1) { this.status1 = status1; }
/*     */   
/*     */   public String getProductName() {
/*  88 */     return this.productName;
/*     */   }
/*     */   
/*  91 */   public void setProductName(String productName) { this.productName = productName; }
/*     */   
/*     */   public String getShopName() {
/*  94 */     return this.shopName;
/*     */   }
/*     */   
/*  97 */   public void setShopName(String shopName) { this.shopName = shopName; }
/*     */   
/*     */   public String getSellerName() {
/* 100 */     return this.sellerName;
/*     */   }
/*     */   
/* 103 */   public void setSellerName(String sellerName) { this.sellerName = sellerName; }
/*     */   
/*     */   public String getBuyerName() {
/* 106 */     return this.buyerName;
/*     */   }
/*     */   
/* 109 */   public void setBuyerName(String buyerName) { this.buyerName = buyerName; }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\entity\Comments.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */