/*    */ package com.seller.dao;
/*    */ 
/*    */ import com.seller.vo.Shopinfo;
/*    */ 
/*    */ public class GetShopinfoDao extends Dbcommon
/*    */ {
/*    */   public Shopinfo getsid(String cname) {
/*  8 */     String sql = "select ShopInfoID from shopinfo where CustomerName='" + cname + "'";
/*  9 */     returnResultSet(sql);
/*    */     
/* 11 */     Shopinfo si = null;
/*    */     try
/*    */     {
/* 14 */       while (getRs().next())
/*    */       {
/* 16 */         si = new Shopinfo();
/* 17 */         si.setShopinfoid(getRs().getInt(1));
/*    */       }
/*    */     }
/*    */     catch (java.sql.SQLException e) {
/* 21 */       e.printStackTrace();
/*    */     }
/*    */     
/* 24 */     CloseConnection(getCon(), getRs(), getSt());
/*    */     
/* 26 */     return si;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\com\seller\dao\GetShopinfoDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */