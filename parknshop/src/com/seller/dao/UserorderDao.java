/*    */ package com.seller.dao;
/*    */ 
/*    */ import com.seller.vo.Sendorderinfo;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ 
/*    */ public class UserorderDao extends Dbcommon
/*    */ {
/*    */   public java.util.List<Sendorderinfo> showorder(com.seller.vo.Shopinfo si)
/*    */   {
/* 11 */     String sql = "select c.OrderID,b.ProductName,c.ProductBuyNum,c.OrderTime,d.ConsigneeName,d.ConsigneePhoneNumber,d.ConsigneeAddress,d.ConsigneePostcode from shopproduct as a,productinfo as b,userorder as c,consigneeinfo as d WHERE a.ShopInfoID=" + 
/*    */     
/* 13 */       si.getShopinfoid() + 
/* 14 */       " and c.ShopProductID=a.ShopProductID and a.ProductID=b.ProductID and c.CurrentState=1 and c.ConsigneeInfoID=d.ConsigneeInfoID";
/*    */     
/* 16 */     returnResultSet(sql);
/* 17 */     java.util.List<Sendorderinfo> olist = new java.util.ArrayList();
/* 18 */     Sendorderinfo soi = null;
/*    */     try {
/* 20 */       while (getRs().next())
/*    */       {
/* 22 */         soi = new Sendorderinfo();
/* 23 */         soi.setOrderid(getRs().getInt(1));
/* 24 */         soi.setProductname(getRs().getString(2));
/* 25 */         soi.setProductbuynum(getRs().getInt(3));
/* 26 */         soi.setOrdertime(getRs().getDate(4));
/* 27 */         soi.setConsigneename(getRs().getString(5));
/* 28 */         soi.setConsigneephonenumber(getRs().getString(6));
/* 29 */         soi.setConsigneeaddress(getRs().getString(7));
/* 30 */         soi.setConsigneepostcode(getRs().getString(8));
/* 31 */         olist.add(soi);
/*    */       }
/*    */     }
/*    */     catch (SQLException e) {
/* 35 */       e.printStackTrace();
/*    */     }
/*    */     
/* 38 */     CloseConnection(getCon(), getRs(), getSt());
/* 39 */     return olist;
/*    */   }
/*    */   
/*    */ 
/*    */   public void delivery(com.seller.vo.Userorder uo)
/*    */   {
/* 45 */     String sql = "update userorder set CurrentState=3 where OrderID=" + uo.getOrderID();
/* 46 */     noResultSet(sql);
/*    */   }
/*    */   
/*    */   public java.util.List<Sendorderinfo> search(String sql)
/*    */   {
/* 51 */     System.out.print(sql);
/* 52 */     returnResultSet(sql);
/* 53 */     java.util.List<Sendorderinfo> list = new java.util.ArrayList();
/* 54 */     Sendorderinfo soi = null;
/*    */     try {
/* 56 */       while (getRs().next())
/*    */       {
/* 58 */         soi = new Sendorderinfo();
/* 59 */         soi.setOrderid(getRs().getInt(1));
/* 60 */         soi.setTrackingnum(getRs().getString(2));
/* 61 */         soi.setProductname(getRs().getString(3));
/* 62 */         soi.setProductbuynum(getRs().getInt(4));
/* 63 */         soi.setOrdertime(getRs().getDate(5));
/* 64 */         soi.setConsigneename(getRs().getString(6));
/* 65 */         soi.setConsigneephonenumber(getRs().getString(7));
/* 66 */         soi.setConsigneeaddress(getRs().getString(8));
/* 67 */         soi.setConsigneepostcode(getRs().getString(9));
/* 68 */         soi.setStatus(getRs().getInt(10));
/* 69 */         list.add(soi);
/*    */       }
/*    */     }
/*    */     catch (SQLException e) {
/* 73 */       e.printStackTrace();
/*    */     }
/* 75 */     CloseConnection(getCon(), getRs(), getSt());
/* 76 */     return list;
/*    */   }
/*    */   
/*    */ 
/*    */   public void createTackingNum(int orderid, String ordertime)
/*    */   {
/* 82 */     String tracknum = String.valueOf(orderid) + String.valueOf(ordertime).replace("-", "");
/* 83 */     String sql = "update userorder set TrackingNum='" + tracknum + "' where OrderID=" + orderid + " ";
/* 84 */     System.out.println(sql);
/* 85 */     noResultSet(sql);
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\com\seller\dao\UserorderDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */