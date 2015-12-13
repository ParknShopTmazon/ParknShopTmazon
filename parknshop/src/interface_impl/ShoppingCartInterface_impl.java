/*    */ package interface_impl;
/*    */ 
/*    */ import interface_servlet.ShoppingCartInterface;
/*    */ import java.sql.Connection;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.Statement;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import jdbc.ConnectionManager;
/*    */ import vo.ShoppingCart;
/*    */ 
/*    */ 
/*    */ public class ShoppingCartInterface_impl
/*    */   implements ShoppingCartInterface
/*    */ {
/*    */   public List<ShoppingCart> returncartlist(String customername)
/*    */   {
/* 18 */     String sql = "SELECT productinfo.ProductID,ImagePath,ProductDescription,ProducePrice,ProductName,ProductBuyNum,ProductStock  FROM shoppingcart,shopproduct,productinfo WHERE shoppingcart.ShopProductID=shopproduct.ShopProductID AND  shopproduct.ProductID=productinfo.ProductID AND  shoppingcart.CustomerName='" + 
/*    */     
/*    */ 
/*    */ 
/* 22 */       customername + "'";
/* 23 */     List<ShoppingCart> list = new ArrayList();
/* 24 */     ShoppingCart sc = null;
/*    */     try
/*    */     {
/* 27 */       Connection con = ConnectionManager.getConnection();
/* 28 */       Statement st = con.createStatement();
/* 29 */       ResultSet rs = st.executeQuery(sql);
/* 30 */       while (rs.next()) {
/* 31 */         sc = new ShoppingCart();
/* 32 */         sc.setProduct_ID(String.valueOf(rs.getInt("ProductID")));
/* 33 */         sc.setProduct_img_url(rs.getString("ImagePath"));
/* 34 */         sc.setProduct_description(rs.getString("ProductDescription"));
/* 35 */         sc.setProduct_price(String.valueOf(rs.getInt("ProducePrice")));
/* 36 */         sc.setProduct_name(rs.getString("ProductName"));
/* 37 */         sc.setProduct_quantity(rs.getInt("ProductBuyNum"));
/* 38 */         sc.setProduct_stock(rs.getInt("ProductStock"));
/* 39 */         list.add(sc);
/*    */       }
/*    */       
/* 42 */       ConnectionManager.close(rs);
/* 43 */       ConnectionManager.close(st);
/* 44 */       ConnectionManager.close(con);
/*    */     } catch (Exception e) {
/* 46 */       e.printStackTrace();
/*    */     }
/*    */     
/* 49 */     return list;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int usercount(String customername)
/*    */   {
/* 56 */     String sql = "SELECT COUNT(*) FROM shoppingcart where CustomerName='" + 
/* 57 */       customername + "'";
/* 58 */     int count = 0;
/*    */     try {
/* 60 */       Connection con = ConnectionManager.getConnection();
/* 61 */       Statement st = con.createStatement();
/* 62 */       ResultSet rs = st.executeQuery(sql);
/* 63 */       while (rs.next()) {
/* 64 */         count = rs.getInt(1);
/*    */       }
/*    */       
/* 67 */       ConnectionManager.close(rs);
/* 68 */       ConnectionManager.close(st);
/* 69 */       ConnectionManager.close(con);
/*    */     } catch (Exception e) {
/* 71 */       e.printStackTrace();
/*    */     }
/*    */     
/* 74 */     return count;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cartremove(String customername, int product_id)
/*    */   {
/* 80 */     String sql = "DELETE FROM  shoppingcart WHERE CustomerName='" + customername + "' AND ShopProductID  IN " + 
/* 81 */       "(SELECT  shopproduct.ShopProductID" + 
/* 82 */       " FROM productinfo,shopproduct " + 
/* 83 */       " WHERE  productinfo.ProductID=shopproduct.ProductID " + 
/* 84 */       "  AND productinfo.ProductID= " + product_id + ")";
/* 85 */     int mark = 0;
/*    */     try {
/* 87 */       Connection con = ConnectionManager.getConnection();
/* 88 */       Statement st = con.createStatement();
/* 89 */       mark = st.executeUpdate(sql);
/* 90 */       ConnectionManager.close(st);
/* 91 */       ConnectionManager.close(con);
/*    */     } catch (Exception e) {
/* 93 */       e.printStackTrace();
/*    */     }
/*    */     
/* 96 */     return mark;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\interface_impl\ShoppingCartInterface_impl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */