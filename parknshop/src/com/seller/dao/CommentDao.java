/*    */ package com.seller.dao;
/*    */ 
/*    */ import com.seller.vo.Comments;
/*    */ 
/*    */ public class CommentDao extends Dbcommon
/*    */ {
/*    */   public java.util.List<Comments> showcomment(String sql)
/*    */   {
/*  9 */     returnResultSet(sql);
/*    */     
/* 11 */     java.util.List<Comments> list = new java.util.ArrayList();
/* 12 */     Comments cs = null;
/*    */     try {
/* 14 */       while (getRs().next())
/*    */       {
/* 16 */         cs = new Comments();
/* 17 */         cs.setCommentary(getRs().getString(1));
/* 18 */         cs.setpName(getRs().getString(2));
/* 19 */         cs.setPtname(getRs().getString(3));
/* 20 */         cs.setTime(getRs().getDate(4));
/* 21 */         cs.setcName(getRs().getString(5));
/* 22 */         list.add(cs);
/*    */       }
/*    */     }
/*    */     catch (java.sql.SQLException e) {
/* 26 */       e.printStackTrace();
/*    */     }
/* 28 */     CloseConnection(getCon(), getRs(), getSt());
/*    */     
/* 30 */     return list;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\com\seller\dao\CommentDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */