/*    */ package com.seller.dao;
/*    */ 
/*    */ import com.seller.vo.Shopproduct;
/*    */ 
/*    */ public class ShopproductDao extends Dbcommon
/*    */ {
/*    */   public void addinfo(Shopproduct shopproduct) {
/*  8 */     String sql = "insert into shopproduct(ShopInfoID,ProductID,ProductStock,ProducePrice) values(" + 
/*  9 */       shopproduct.getShop_infoid() + 
/* 10 */       "," + 
/* 11 */       shopproduct.getProductid() + 
/* 12 */       "," + 
/* 13 */       shopproduct.getProductstock() + 
/* 14 */       "," + 
/* 15 */       shopproduct.getProduceprice() + 
/* 16 */       ") ";
/* 17 */     noResultSet(sql);
/*    */   }
/*    */   
/*    */   public void modify(Shopproduct shopproduct)
/*    */   {
/* 22 */     String sql = "update shopproduct set ProductStock=" + 
/* 23 */       shopproduct.getProductstock() + 
/* 24 */       " , " + 
/* 25 */       "ProducePrice=" + 
/* 26 */       shopproduct.getProduceprice() + 
/* 27 */       " where ProductID=" + 
/* 28 */       shopproduct.getProductid();
/* 29 */     System.out.print(sql);
/* 30 */     noResultSet(sql);
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\com\seller\dao\ShopproductDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */