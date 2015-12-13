/*    */ package admin.dao;
/*    */ 
/*    */ import admin.entity.Shopproduct;
/*    */ import admin.util.DBHelper;
/*    */ import java.sql.ResultSet;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class ShopProductDAO
/*    */ {
/*    */   public List<Shopproduct> getAny(int id)
/*    */   {
/* 14 */     List<Shopproduct> Cs = new ArrayList();
/* 15 */     String sql = "select * from Shopproduct where ShopProductID=?";
/*    */     
/* 17 */     DBHelper dbhelper = new DBHelper();
/*    */     
/* 19 */     Object[] values = new Object[1];
/* 20 */     values[0] = Integer.valueOf(id);
/*    */     try
/*    */     {
/* 23 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/* 24 */       while (rs.next())
/*    */       {
/* 26 */         Shopproduct C = new Shopproduct();
/* 27 */         C.setShopProductId(Integer.valueOf(rs.getInt("ShopProductID")));
/* 28 */         C.setShopInfoId(Integer.valueOf(rs.getInt("ShopInfoID")));
/* 29 */         C.setProductId(Integer.valueOf(rs.getInt("ProductID")));
/* 30 */         C.setProductStock(Integer.valueOf(rs.getInt("ProductStock")));
/* 31 */         C.setProducePrice(Double.valueOf(rs.getDouble("ProducePrice")));
/* 32 */         Cs.add(C);
/*    */       }
/* 34 */       dbhelper.closeDB();
/*    */     }
/*    */     catch (Exception e) {
/* 37 */       e.printStackTrace();
/*    */     }
/* 39 */     return Cs;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\dao\ShopProductDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */