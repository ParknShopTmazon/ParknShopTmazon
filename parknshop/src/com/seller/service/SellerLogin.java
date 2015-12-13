/*    */ package com.seller.service;
/*    */ 
/*    */ import com.seller.vo.Customerinfo;
/*    */ 
/*    */ public class SellerLogin
/*    */ {
/*    */   public int login(String sname, String spwd) {
/*  8 */     Customerinfo ci = new Customerinfo();
/*  9 */     ci.setCustomername(sname);
/* 10 */     ci.setCustomerpwd(spwd);
/*    */     
/* 12 */     com.seller.dao.SellerlonginDao sld = new com.seller.dao.SellerlonginDao();
/* 13 */     int row = sld.login(ci);
/* 14 */     return row;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\com\seller\service\SellerLogin.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */