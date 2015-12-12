/*     */ package admin.entity;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Userorder
/*     */   implements Serializable
/*     */ {
/*     */   private Integer orderId;
/*     */   private int shopProductId;
/*     */   private int consigneeId;
/*     */   private Integer productBuyNum;
/*     */   private Date orderTime;
/*     */   private Date finishTime;
/*     */   private Integer currentState;
/*     */   private String state;
/*     */   private String anythingElse;
/*     */   private String trackingNum;
/*  25 */   private Set commentses = new HashSet(0);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getOrderId()
/*     */   {
/*  35 */     return this.orderId;
/*     */   }
/*     */   
/*     */   public String getState() {
/*  39 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(String state) {
/*  43 */     this.state = state;
/*     */   }
/*     */   
/*     */   public void setOrderId(Integer orderId) {
/*  47 */     this.orderId = orderId;
/*     */   }
/*     */   
/*     */   public int getShopProductId() {
/*  51 */     return this.shopProductId;
/*     */   }
/*     */   
/*     */   public void setShopProductId(int shopProductId) {
/*  55 */     this.shopProductId = shopProductId;
/*     */   }
/*     */   
/*     */   public int getConsigneeId() {
/*  59 */     return this.consigneeId;
/*     */   }
/*     */   
/*     */   public void setConsigneeId(int consigneeId) {
/*  63 */     this.consigneeId = consigneeId;
/*     */   }
/*     */   
/*     */   public Integer getProductBuyNum() {
/*  67 */     return this.productBuyNum;
/*     */   }
/*     */   
/*     */   public void setProductBuyNum(Integer productBuyNum) {
/*  71 */     this.productBuyNum = productBuyNum;
/*     */   }
/*     */   
/*     */   public Date getOrderTime() {
/*  75 */     return this.orderTime;
/*     */   }
/*     */   
/*     */   public void setOrderTime(Date orderTime) {
/*  79 */     this.orderTime = orderTime;
/*     */   }
/*     */   
/*     */   public Date getFinishTime() {
/*  83 */     return this.finishTime;
/*     */   }
/*     */   
/*     */   public void setFinishTime(Date finishTime) {
/*  87 */     this.finishTime = finishTime;
/*     */   }
/*     */   
/*     */   public Integer getCurrentState() {
/*  91 */     return this.currentState;
/*     */   }
/*     */   
/*     */   public void setCurrentState(Integer currentState) {
/*  95 */     this.currentState = currentState;
/*     */   }
/*     */   
/*     */   public String getAnythingElse() {
/*  99 */     return this.anythingElse;
/*     */   }
/*     */   
/*     */   public void setAnythingElse(String anythingElse) {
/* 103 */     this.anythingElse = anythingElse;
/*     */   }
/*     */   
/*     */   public String getTrackingNum() {
/* 107 */     return this.trackingNum;
/*     */   }
/*     */   
/*     */   public void setTrackingNum(String trackingNum) {
/* 111 */     this.trackingNum = trackingNum;
/*     */   }
/*     */   
/*     */   public Set getCommentses() {
/* 115 */     return this.commentses;
/*     */   }
/*     */   
/*     */   public void setCommentses(Set commentses) {
/* 119 */     this.commentses = commentses;
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\entity\Userorder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */