/*    */ package com.seller.dao;
/*    */ 
/*    */ import com.seller.vo.Customerinfo;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ 
/*    */ public class SellerlonginDao extends Dbcommon
/*    */ {
/*    */   public int login(Customerinfo ci)
/*    */   {
/* 11 */     String sql = "select count(*) from customerinfo where CustomerName='" + 
/*    */     
/* 13 */       ci.getCustomername() + "' " + 
/* 14 */       "and CustomerPwd='" + ci.getCustomerpwd() + "'";
/* 15 */     int row = 0;
/* 16 */     returnResultSet(sql);
/*    */     try {
/* 18 */       while (getRs().next())
/*    */       {
/* 20 */         row = getRs().getInt(1);
/*    */       }
/*    */     }
/*    */     catch (SQLException e) {
/* 24 */       e.printStackTrace();
/*    */     }
/*    */     
/*    */ 
/* 28 */     return row;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\com\seller\dao\SellerlonginDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */