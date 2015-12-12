/*    */ package com.seller.service;
/*    */ 
/*    */ import com.seller.dao.UserorderDao;
/*    */ import com.seller.vo.Sendorderinfo;
/*    */ import com.seller.vo.Userorder;
/*    */ 
/*    */ public class OrderService
/*    */ {
/*    */   public void delivery(int orderid)
/*    */   {
/* 11 */     Userorder uo = new Userorder();
/* 12 */     uo.setOrderID(orderid);
/*    */     
/* 14 */     UserorderDao uod = new UserorderDao();
/* 15 */     uod.delivery(uo);
/*    */   }
/*    */   
/*    */   public java.util.List<Sendorderinfo> search(String sql)
/*    */   {
/* 20 */     UserorderDao uod = new UserorderDao();
/* 21 */     java.util.List<Sendorderinfo> list = new java.util.ArrayList();
/* 22 */     list = uod.search(sql);
/* 23 */     return list;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\com\seller\service\OrderService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */