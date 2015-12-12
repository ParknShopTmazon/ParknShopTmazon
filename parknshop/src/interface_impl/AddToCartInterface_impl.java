/*    */ package interface_impl;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.Statement;
/*    */ import jdbc.ConnectionManager;
/*    */ 
/*    */ public class AddToCartInterface_impl implements interface_servlet.AddToCartInterface
/*    */ {
/*    */   public int addtocart(String CustomerName, int product_ID, int product_quantity)
/*    */   {
/* 11 */     int mark = 0;
/* 12 */     String sql = "INSERT INTO shoppingcart(ShopProductID,CustomerName,ProductBuyNum)  SELECT sp2.ShopProductID ,'" + 
/*    */     
/* 14 */       CustomerName + 
/* 15 */       "'," + 
/* 16 */       product_quantity + 
/* 17 */       " FROM  (SELECT sp3.ShopProductID  FROM productinfo,shopproduct AS sp3  WHERE productinfo.ProductID=sp3.ProductID AND productinfo.ProductID=" + product_ID + ") AS sp2" + 
/* 18 */       " WHERE  sp2.ShopProductID NOT IN (SELECT  sp1.ShopProductID  FROM shoppingcart AS sp1 WHERE CustomerName='" + 
/* 19 */       CustomerName + "') ";
/*    */     try
/*    */     {
/* 22 */       Connection con = ConnectionManager.getConnection();
/* 23 */       Statement st = con.createStatement();
/* 24 */       mark = st.executeUpdate(sql);
/* 25 */       ConnectionManager.close(st);
/* 26 */       ConnectionManager.close(con);
/*    */     } catch (Exception e) {
/* 28 */       e.printStackTrace();
/*    */     }
/*    */     
/* 31 */     return mark;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\interface_impl\AddToCartInterface_impl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */