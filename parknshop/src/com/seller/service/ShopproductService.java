/*    */ package com.seller.service;
/*    */ 
/*    */ import com.seller.vo.Shopproduct;
/*    */ 
/*    */ public class ShopproductService
/*    */ {
/*    */   public void addinfo(int shopinfoid, int pid, int stock, double price)
/*    */   {
/*  9 */     Shopproduct shopproduct = new Shopproduct();
/* 10 */     shopproduct.setShop_infoid(shopinfoid);
/* 11 */     shopproduct.setProductid(pid);
/* 12 */     shopproduct.setProductstock(stock);
/* 13 */     shopproduct.setProduceprice(price);
/*    */     
/* 15 */     com.seller.dao.ShopproductDao spd = new com.seller.dao.ShopproductDao();
/* 16 */     spd.addinfo(shopproduct);
/*    */   }
/*    */   
/*    */   public void modify(int pid, double price, int stock)
/*    */   {
/* 21 */     Shopproduct shopproduct = new Shopproduct();
/* 22 */     shopproduct.setProductid(pid);
/* 23 */     shopproduct.setProductstock(stock);
/* 24 */     shopproduct.setProduceprice(price);
/*    */     
/* 26 */     com.seller.dao.ShopproductDao spd = new com.seller.dao.ShopproductDao();
/* 27 */     spd.modify(shopproduct);
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\com\seller\service\ShopproductService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */