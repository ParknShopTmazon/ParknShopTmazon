/*    */ package com.seller.vo;
/*    */ 
/*    */ import java.sql.Date;
/*    */ 
/*    */ public class Userorder {
/*    */   private int OrderID;
/*    */   private int ConsigneeInfoID;
/*    */   private int ShopProductID;
/*    */   private int ProductBuyNum;
/*    */   private Date OrderTime;
/*    */   private Date FinishTime;
/*    */   private int CurrentState;
/*    */   private String Anythingelse;
/*    */   private String TrackingNum;
/*    */   
/*    */   public int getOrderID() {
/* 17 */     return this.OrderID;
/*    */   }
/*    */   
/* 20 */   public void setOrderID(int orderID) { this.OrderID = orderID; }
/*    */   
/*    */   public int getConsigneeInfoID() {
/* 23 */     return this.ConsigneeInfoID;
/*    */   }
/*    */   
/* 26 */   public void setConsigneeInfoID(int consigneeInfoID) { this.ConsigneeInfoID = consigneeInfoID; }
/*    */   
/*    */   public int getShopProductID() {
/* 29 */     return this.ShopProductID;
/*    */   }
/*    */   
/* 32 */   public void setShopProductID(int shopProductID) { this.ShopProductID = shopProductID; }
/*    */   
/*    */   public int getProductBuyNum() {
/* 35 */     return this.ProductBuyNum;
/*    */   }
/*    */   
/* 38 */   public void setProductBuyNum(int productBuyNum) { this.ProductBuyNum = productBuyNum; }
/*    */   
/*    */   public Date getOrderTime() {
/* 41 */     return this.OrderTime;
/*    */   }
/*    */   
/* 44 */   public void setOrderTime(Date orderTime) { this.OrderTime = orderTime; }
/*    */   
/*    */   public Date getFinishTime() {
/* 47 */     return this.FinishTime;
/*    */   }
/*    */   
/* 50 */   public void setFinishTime(Date finishTime) { this.FinishTime = finishTime; }
/*    */   
/*    */   public int getCurrentState() {
/* 53 */     return this.CurrentState;
/*    */   }
/*    */   
/* 56 */   public void setCurrentState(int currentState) { this.CurrentState = currentState; }
/*    */   
/*    */   public String getAnythingelse() {
/* 59 */     return this.Anythingelse;
/*    */   }
/*    */   
/* 62 */   public void setAnythingelse(String anythingelse) { this.Anythingelse = anythingelse; }
/*    */   
/*    */   public String getTrackingNum() {
/* 65 */     return this.TrackingNum;
/*    */   }
/*    */   
/* 68 */   public void setTrackingNum(String trackingNum) { this.TrackingNum = trackingNum; }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\com\seller\vo\Userorder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */