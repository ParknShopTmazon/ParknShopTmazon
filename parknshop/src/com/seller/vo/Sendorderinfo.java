/*    */ package com.seller.vo;
/*    */ 
/*    */ import java.sql.Date;
/*    */ 
/*    */ public class Sendorderinfo
/*    */ {
/*    */   private int orderid;
/*    */   private String trackingnum;
/*    */   private String productname;
/*    */   private int productbuynum;
/*    */   private Date ordertime;
/*    */   private String consigneename;
/*    */   private String consigneephonenumber;
/*    */   private String consigneeaddress;
/*    */   private String consigneepostcode;
/*    */   private int status;
/*    */   
/*    */   public String getTrackingnum() {
/* 19 */     return this.trackingnum;
/*    */   }
/*    */   
/* 22 */   public void setTrackingnum(String trackingnum) { this.trackingnum = trackingnum; }
/*    */   
/*    */   public int getStatus() {
/* 25 */     return this.status;
/*    */   }
/*    */   
/* 28 */   public void setStatus(int status) { this.status = status; }
/*    */   
/*    */   public int getOrderid() {
/* 31 */     return this.orderid;
/*    */   }
/*    */   
/* 34 */   public void setOrderid(int orderid) { this.orderid = orderid; }
/*    */   
/*    */   public String getProductname() {
/* 37 */     return this.productname;
/*    */   }
/*    */   
/* 40 */   public void setProductname(String productname) { this.productname = productname; }
/*    */   
/*    */   public int getProductbuynum()
/*    */   {
/* 44 */     return this.productbuynum;
/*    */   }
/*    */   
/* 47 */   public void setProductbuynum(int productbuynum) { this.productbuynum = productbuynum; }
/*    */   
/*    */   public Date getOrdertime() {
/* 50 */     return this.ordertime;
/*    */   }
/*    */   
/* 53 */   public void setOrdertime(Date ordertime) { this.ordertime = ordertime; }
/*    */   
/*    */   public String getConsigneename() {
/* 56 */     return this.consigneename;
/*    */   }
/*    */   
/* 59 */   public void setConsigneename(String consigneename) { this.consigneename = consigneename; }
/*    */   
/*    */   public String getConsigneephonenumber() {
/* 62 */     return this.consigneephonenumber;
/*    */   }
/*    */   
/* 65 */   public void setConsigneephonenumber(String consigneephonenumber) { this.consigneephonenumber = consigneephonenumber; }
/*    */   
/*    */   public String getConsigneeaddress() {
/* 68 */     return this.consigneeaddress;
/*    */   }
/*    */   
/* 71 */   public void setConsigneeaddress(String consigneeaddress) { this.consigneeaddress = consigneeaddress; }
/*    */   
/*    */   public String getConsigneepostcode() {
/* 74 */     return this.consigneepostcode;
/*    */   }
/*    */   
/* 77 */   public void setConsigneepostcode(String consigneepostcode) { this.consigneepostcode = consigneepostcode; }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\com\seller\vo\Sendorderinfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */