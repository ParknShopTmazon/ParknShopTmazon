/*     */ package com.seller.dao;
/*     */ 
/*     */ import com.seller.vo.Productinfo;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class ProductDao extends Dbcommon
/*     */ {
/*     */   public void addpd_part(Productinfo pi)
/*     */   {
/*  11 */     String sql = "insert into productinfo (ProductTypeId,ProductName,ProductDescription,Price)values(" + 
/*  12 */       pi.getP_typeid() + 
/*  13 */       ",'" + 
/*  14 */       pi.getP_name() + 
/*  15 */       "','" + 
/*  16 */       pi.getP_desc() + 
/*  17 */       "'," + 
/*  18 */       pi.getP_price() + ")";
/*     */     
/*  20 */     noResultSet(sql);
/*     */   }
/*     */   
/*     */   public void addpd_rest(Productinfo pi)
/*     */   {
/*  25 */     String sql = "update productinfo set ImagePath='" + 
/*  26 */       pi.getImg_path() + 
/*  27 */       "' where ProductID=" + 
/*  28 */       pi.getP_id();
/*  29 */     noResultSet(sql);
/*     */   }
/*     */   
/*     */   public int selectByName(Productinfo pi)
/*     */   {
/*  34 */     String sql = "select ProductID from productinfo where ProductName='" + pi.getP_name() + "'";
/*     */     
/*  36 */     returnResultSet(sql);
/*     */     
/*  38 */     int returnPid = 0;
/*     */     try {
/*  40 */       while (getRs().next())
/*     */       {
/*  42 */         returnPid = getRs().getInt(1);
/*     */       }
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/*  47 */       System.out.println("这里出错了");
/*     */     }
/*  49 */     CloseConnection(getCon(), getRs(), getSt());
/*  50 */     return returnPid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.List<Productinfo> showproductList(com.seller.vo.Shopinfo shopinfo)
/*     */   {
/*  57 */     String sql = "SELECT a.ProductID,a.ProductName,b.TypeName,a.Price,c.ProductStock,a.ProductDescription,a.ImagePath FROM productinfo AS a,producttype AS b,shopproduct AS c WHERE a.ProductTypeID=b.TypeID AND a.ProductID IN(SELECT c.ProductID FROM shopproduct WHERE c.ShopInfoID=" + 
/*     */     
/*     */ 
/*     */ 
/*  61 */       shopinfo.getShopinfoid() + " )" + 
/*  62 */       "and a.Statement=1";
/*     */     
/*  64 */     returnResultSet(sql);
/*     */     
/*  66 */     Productinfo pd = null;
/*  67 */     java.util.List<Productinfo> plist = new java.util.ArrayList();
/*     */     try
/*     */     {
/*  70 */       while (getRs().next())
/*     */       {
/*  72 */         pd = new Productinfo();
/*  73 */         pd.setP_id(getRs().getInt(1));
/*  74 */         pd.setP_name(getRs().getString(2));
/*  75 */         pd.setP_type(getRs().getString(3));
/*  76 */         pd.setP_price(getRs().getDouble(4));
/*  77 */         pd.setP_stock(getRs().getInt(5));
/*  78 */         pd.setP_desc(getRs().getString(6));
/*  79 */         pd.setImg_path(getRs().getString(7));
/*  80 */         plist.add(pd);
/*     */       }
/*     */     }
/*     */     catch (SQLException e) {
/*  84 */       e.printStackTrace();
/*     */     }
/*  86 */     CloseConnection(getCon(), getRs(), getSt());
/*     */     
/*  88 */     return plist;
/*     */   }
/*     */   
/*     */   public void delproduct(Productinfo pi)
/*     */   {
/*  93 */     String sql = "update productinfo set Statement=0 where ProductID='" + pi.getP_id() + "'";
/*     */     
/*  95 */     noResultSet(sql);
/*     */   }
/*     */   
/*     */   public void modifyproduct(Productinfo pi)
/*     */   {
/* 100 */     String sql = "update productinfo set Price=" + pi.getP_price() + " where ProductID=" + pi.getP_id();
/* 101 */     System.out.print(sql);
/* 102 */     noResultSet(sql);
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\com\seller\dao\ProductDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */