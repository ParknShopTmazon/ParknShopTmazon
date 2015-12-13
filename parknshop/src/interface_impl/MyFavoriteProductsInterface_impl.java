/*    */ package interface_impl;
/*    */ 
/*    */ import interface_servlet.MyFavoriteProductsInterface;
/*    */ import java.sql.Connection;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.Statement;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import jdbc.ConnectionManager;
/*    */ import vo.ProductDetail;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MyFavoriteProductsInterface_impl
/*    */   implements MyFavoriteProductsInterface
/*    */ {
/*    */   public List<ProductDetail> returnmyfavoritelist(String customername)
/*    */   {
/* 19 */     ProductDetail pd = null;
/* 20 */     List<ProductDetail> list = new ArrayList();
/* 21 */     String sql = "SELECT productinfo.ProductID,ImagePath,ProductDescription,ProducePrice,ProductName,ProductTypeID  FROM userfavorite,shopproduct,productinfo WHERE userfavorite.ShopProductID=shopproduct.ShopProductID AND shopproduct.ProductID=productinfo.ProductID AND userfavorite.CustomerName='" + 
/*    */     
/*    */ 
/*    */ 
/* 25 */       customername + "'";
/*    */     try {
/* 27 */       Connection con = ConnectionManager.getConnection();
/* 28 */       Statement st = con.createStatement();
/* 29 */       ResultSet rs = st.executeQuery(sql);
/* 30 */       while (rs.next()) {
/* 31 */         pd = new ProductDetail();
/* 32 */         pd.setProduct_ID(rs.getInt("ProductID"));
/* 33 */         pd.setProduct_type_ID(rs.getInt("ProductTypeID"));
/* 34 */         pd.setProduct_name(rs.getString("ProductName"));
/* 35 */         pd.setProduct_description(rs.getString("ProductDescription"));
/* 36 */         pd.setProduct_img_url(rs.getString("ImagePath"));
/* 37 */         pd.setProduct_price(rs.getInt("ProducePrice"));
/* 38 */         list.add(pd);
/*    */       }
/*    */       
/* 41 */       ConnectionManager.close(rs);
/* 42 */       ConnectionManager.close(st);
/* 43 */       ConnectionManager.close(con);
/*    */     } catch (Exception e) {
/* 45 */       e.printStackTrace();
/*    */     }
/*    */     
/* 48 */     return list;
/*    */   }
/*    */   
/*    */ 
/*    */   public int myfavoriteremove(String customername, int product_id)
/*    */   {
/* 54 */     String sql = "DELETE FROM userfavorite WHERE userfavorite.CustomerName='" + customername + "' and userfavorite.ShopProductID " + 
/* 55 */       " IN (SELECT shopproduct.ShopProductID" + 
/* 56 */       " FROM shopproduct,productinfo" + 
/* 57 */       " WHERE shopproduct.ProductID=productinfo.ProductID" + 
/* 58 */       " AND   productinfo.ProductID=" + product_id + " )";
/* 59 */     int mark = 0;
/*    */     try {
/* 61 */       Connection con = ConnectionManager.getConnection();
/* 62 */       Statement st = con.createStatement();
/* 63 */       mark = st.executeUpdate(sql);
/*    */       
/*    */ 
/* 66 */       ConnectionManager.close(st);
/* 67 */       ConnectionManager.close(con);
/*    */     }
/*    */     catch (Exception e) {
/* 70 */       e.printStackTrace();
/*    */     }
/*    */     
/* 73 */     return mark;
/*    */   }
/*    */   
/*    */   public int addtomyfavorite(String customername, int product_id)
/*    */   {
/* 78 */     int mark = 0;
/* 79 */     String sql = "  INSERT INTO userfavorite(ShopProductID,CustomerName) SELECT ShopProductID,'" + customername + "' FROM shopproduct WHERE  ProductID=" + product_id;
/*    */     try {
/* 81 */       Connection con = ConnectionManager.getConnection();
/* 82 */       Statement st = con.createStatement();
/* 83 */       mark = st.executeUpdate(sql);
/*    */     }
/*    */     catch (Exception e) {
/* 86 */       e.printStackTrace();
/*    */     }
/* 88 */     return mark;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\interface_impl\MyFavoriteProductsInterface_impl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */