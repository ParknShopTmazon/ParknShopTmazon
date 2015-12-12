/*     */ package interface_impl;
/*     */ 
/*     */ import interface_servlet.IndexInterface;
/*     */ import java.sql.Connection;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import jdbc.ConnectionManager;
/*     */ import vo.ProductDetail;
/*     */ 
/*     */ 
/*     */ public class IndexInterface_impl
/*     */   implements IndexInterface
/*     */ {
/*     */   public List<ProductDetail> SearchProductByType(int product_type)
/*     */   {
/*  18 */     String sql = "SELECT  productinfo.ProductID,ProductName,ProductDescription,ImagePath,ProducePrice FROM productinfo  LEFT JOIN shopproduct ON  productinfo.ProductID=  shopproduct.ProductID  where productinfo.statement=1 AND ProductTypeID=" + 
/*     */     
/*  20 */       product_type;
/*  21 */     ProductDetail pd = null;
/*  22 */     List<ProductDetail> list = new ArrayList();
/*     */     try
/*     */     {
/*  25 */       Connection con = ConnectionManager.getConnection();
/*  26 */       Statement st = con.createStatement();
/*  27 */       ResultSet rs = st.executeQuery(sql);
/*  28 */       while (rs.next()) {
/*  29 */         pd = new ProductDetail();
/*  30 */         pd.setProduct_ID(rs.getInt("ProductID"));
/*  31 */         pd.setProduct_name(rs.getString("ProductName"));
/*  32 */         pd.setProduct_description(rs.getString("ProductDescription"));
/*  33 */         pd.setProduct_img_url(rs.getString("ImagePath"));
/*  34 */         pd.setProduct_price(rs.getInt("ProducePrice"));
/*  35 */         pd.setProduct_type_ID(product_type);
/*  36 */         list.add(pd);
/*     */       }
/*     */       
/*  39 */       ConnectionManager.close(rs);
/*  40 */       ConnectionManager.close(st);
/*  41 */       ConnectionManager.close(con);
/*     */     } catch (Exception e) {
/*  43 */       e.printStackTrace();
/*     */     }
/*     */     
/*  46 */     return list;
/*     */   }
/*     */   
/*     */   public List<ProductDetail> SearchProduct(String product)
/*     */   {
/*  51 */     String sql = "SELECT  ProductID,ProductTypeID,ProductName,ProductDescription,ImagePath,Price FROM productinfo where statement=1 and ProductName like '%" + 
/*  52 */       product + "%'";
/*  53 */     ProductDetail pd = null;
/*  54 */     List<ProductDetail> list = new ArrayList();
/*     */     try
/*     */     {
/*  57 */       Connection con = ConnectionManager.getConnection();
/*  58 */       Statement st = con.createStatement();
/*  59 */       ResultSet rs = st.executeQuery(sql);
/*  60 */       while (rs.next()) {
/*  61 */         pd = new ProductDetail();
/*  62 */         pd.setProduct_ID(rs.getInt("ProductID"));
/*  63 */         pd.setProduct_name(rs.getString("ProductName"));
/*  64 */         pd.setProduct_description(rs.getString("ProductDescription"));
/*  65 */         pd.setProduct_img_url(rs.getString("ImagePath"));
/*  66 */         pd.setProduct_price(rs.getInt("Price"));
/*  67 */         pd.setProduct_type_ID(rs.getInt("ProductTypeID"));
/*  68 */         list.add(pd);
/*     */       }
/*     */       
/*     */ 
/*  72 */       ConnectionManager.close(rs);
/*  73 */       ConnectionManager.close(st);
/*  74 */       ConnectionManager.close(con);
/*     */     } catch (Exception e) {
/*  76 */       e.printStackTrace();
/*     */     }
/*     */     
/*  79 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<ProductDetail> SellBestProduct()
/*     */   {
/*  85 */     String sql = " SELECT  productinfo.ProductID,ProductTypeID,ProductName,ProductDescription,ImagePath,Price   FROM productinfo, (select  Shopproduct.ProductID  from (SELECT sum(ProductBuyNum),ShopProductID FROM userorder GROUP BY ShopProductID ORDER BY sum(ProductBuyNum) DESC)as ps ,Shopproduct  where ps.ShopProductID=Shopproduct.ShopProductID) as shopPId  WHERE  productinfo.ProductID=shopPId.ProductID AND productinfo.statement=1  LIMIT 0,4";
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  93 */     ProductDetail pd = null;
/*  94 */     List<ProductDetail> list = new ArrayList();
/*     */     try
/*     */     {
/*  97 */       Connection con = ConnectionManager.getConnection();
/*  98 */       Statement st = con.createStatement();
/*  99 */       ResultSet rs = st.executeQuery(sql);
/* 100 */       while (rs.next()) {
/* 101 */         pd = new ProductDetail();
/* 102 */         pd.setProduct_ID(rs.getInt("ProductID"));
/* 103 */         pd.setProduct_name(rs.getString("ProductName"));
/* 104 */         pd.setProduct_description(rs.getString("ProductDescription"));
/* 105 */         pd.setProduct_img_url(rs.getString("ImagePath"));
/* 106 */         pd.setProduct_price(rs.getInt("Price"));
/* 107 */         pd.setProduct_type_ID(rs.getInt("ProductTypeID"));
/* 108 */         list.add(pd);
/*     */       }
/*     */       
/* 111 */       ConnectionManager.close(rs);
/* 112 */       ConnectionManager.close(st);
/* 113 */       ConnectionManager.close(con);
/*     */     } catch (Exception e) {
/* 115 */       e.printStackTrace();
/*     */     }
/*     */     
/* 118 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<ProductDetail> NewProduct()
/*     */   {
/* 124 */     int num = 1;
/* 125 */     int typenumber = 10;
/* 126 */     List<ProductDetail> list = new ArrayList();
/* 127 */     List<ProductDetail> list1 = new ArrayList();
/* 128 */     ProductDetail d = null;
/* 129 */     for (int i = 1; i <= typenumber; i++)
/*     */     {
/* 131 */       list1 = SearchProductByType(i);
/* 132 */       for (int j = 0; j < list1.size(); j++) {
/* 133 */         if (j > num) break;
/* 134 */         d = (ProductDetail)list1.get(j);
/* 135 */         list.add(d);
/*     */       }
/*     */     }
/*     */     
/* 139 */     return list;
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\interface_impl\IndexInterface_impl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */