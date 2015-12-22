/*     */ package seller.dao;
/*     */ 
/*     */ import seller.vo.Productinfo;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class ProductDao extends Dbcommon
/*     */ {
/*     */   public void addpd_part(Productinfo pi)
/*     */   {
/*  11 */     String sql = "insert into product_info (ProductId,ProductName,ProductDescription,Price)values(" + 
/*  12 */       pi.getP_id() + 
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
/*  47 */       System.out.println("这里出错�?");
/*     */     }
/*  49 */     CloseConnection(getCon(), getRs(), getSt());
/*  50 */     return returnPid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*        public java.util.List<Productinfo> showproductList(seller.vo.Shopinfo shopinfo)
/*        {
/*       String sql = "SELECT a.ProductID,a.ProductName,b.TypeName,a.Price,c.ProductStock,a.ProductDescription,a.ImagePath FROM productinfo AS a,producttype AS b,shopproduct AS c WHERE a.ProductTypeID=b.TypeID AND a.ProductID IN(SELECT c.ProductID FROM shopproduct WHERE c.ShopInfoID=" + 
/*          
/*      
/*      
/*       shopinfo.getShopinfoid() + " )" + 
/*        "and a.Statement=1";
/*        
/*       returnResultSet(sql);
/*        
/*      Productinfo pd = null;
/*      java.util.List<Productinfo> plist = new java.util.ArrayList();
     try
     {
       while (getRs().next())
       {
         pd = new Productinfo();
         pd.setP_id(getRs().getInt(1));
         pd.setP_name(getRs().getString(2));
         pd.setP_type(getRs().getString(3));
         pd.setP_price(getRs().getDouble(4));
         pd.setP_stock(getRs().getInt(5));
         pd.setP_desc(getRs().getString(6));
        pd.setImg_path(getRs().getString(7));
        plist.add(pd);
      }
     }
     catch (SQLException e) {
       e.printStackTrace();
     }
     CloseConnection(getCon(), getRs(), getSt());
    
     return plist;
   }
*/
/*     */   
/*     */   public void delproduct(Productinfo pi)
/*     */   {
/*  93 */     String sql = "update product_info set Statement=0 where ProductID='" + pi.getP_id() + "'";
/*     */     
/*  95 */     noResultSet(sql);
/*     */   }
/*     */   
/*     */   public void modifyproduct(Productinfo pi)
/*     */   {
/* 100 */     String sql = "update product_info set Price=" + pi.getP_price() + " where ProductID=" + pi.getP_id();
/* 101 */     System.out.print(sql);
/* 102 */     noResultSet(sql);
/*     */   }
/*     */ }

