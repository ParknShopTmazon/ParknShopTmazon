/*    */ package interface_impl;
/*    */ 
/*    */ import interface_servlet.ProductDetailInterface;
/*    */ import java.sql.Connection;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.Statement;
/*    */ import jdbc.ConnectionManager;
/*    */ import vo.ProductDetail;
/*    */ 
/*    */ 
/*    */ public class ProductDetail_Impl
/*    */   implements ProductDetailInterface
/*    */ {
/*    */   public ProductDetail searchproductdetail(int product_id)
/*    */   {
/* 16 */     ProductDetail pd = new ProductDetail();
/* 17 */     pd.setProduct_ID(product_id);
/* 18 */     String sql = "select ProductTypeID,ProductName,ProductDescription,ImagePath,Price from productinfo where statement=1 AND  ProductID= " + 
/* 19 */       product_id;
/*    */     try {
/* 21 */       Connection con = ConnectionManager.getConnection();
/* 22 */       Statement st = con.createStatement();
/* 23 */       ResultSet rs = st.executeQuery(sql);
/* 24 */       while (rs.next())
/*    */       {
/* 26 */         pd.setProduct_type_ID(rs.getInt("ProductTypeID"));
/* 27 */         pd.setProduct_name(rs.getString("ProductName"));
/* 28 */         pd.setProduct_description(rs.getString("ProductDescription"));
/* 29 */         pd.setProduct_img_url(rs.getString("ImagePath"));
/* 30 */         pd.setProduct_price(rs.getInt("Price"));
/*    */       }
/*    */       
/* 33 */       ConnectionManager.close(rs);
/* 34 */       ConnectionManager.close(st);
/* 35 */       ConnectionManager.close(con);
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 39 */       e.printStackTrace();
/*    */     }
/*    */     
/*    */ 
/* 43 */     return pd;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\interface_impl\ProductDetail_Impl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */