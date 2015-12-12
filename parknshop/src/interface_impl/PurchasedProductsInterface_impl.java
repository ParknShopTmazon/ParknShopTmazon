/*    */ package interface_impl;
/*    */ 
/*    */ import interface_servlet.PurchasedProductsInterface;
/*    */ import java.sql.Connection;
/*    */ import java.sql.Date;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.Statement;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import jdbc.ConnectionManager;
/*    */ import vo.NewPurchase;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PurchasedProductsInterface_impl
/*    */   implements PurchasedProductsInterface
/*    */ {
/*    */   public List<NewPurchase> returnPurchasedProductlist(String customername)
/*    */   {
/* 20 */     String sql = "SELECT productinfo.ProductID,userorder.OrderID,ImagePath,ProductDescription,userorder.CurrentState,userorder.OrderTime,ProducePrice FROM consigneeinfo,userorder,shopproduct,productinfo WHERE consigneeinfo.ConsigneeInfoID=userorder.ConsigneeInfoID  AND userorder.ShopProductID=ShopProduct.ShopProductID AND shopproduct.ProductID=productinfo.ProductID AND  userorder.state=1 AND consigneeinfo.CustomerName='" + 
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 27 */       customername + "'";
/* 28 */     NewPurchase pp = null;
/* 29 */     List<NewPurchase> list = new ArrayList();
/*    */     try {
/* 31 */       Connection con = ConnectionManager.getConnection();
/* 32 */       Statement st = con.createStatement();
/* 33 */       ResultSet rs = st.executeQuery(sql);
/* 34 */       while (rs.next()) {
/* 35 */         pp = new NewPurchase();
/* 36 */         pp.setProduct_id(rs.getInt("ProductID"));
/* 37 */         pp.setOrder_id(rs.getInt("OrderID"));
/* 38 */         pp.setProduct_img_url(rs.getString("ImagePath"));
/* 39 */         pp.setProduct_description(rs.getString("ProductDescription"));
/* 40 */         pp.setOrder_state(String.valueOf(rs.getInt("CurrentState")));
/* 41 */         pp.setDatetime(rs.getDate("OrderTime").toString());
/* 42 */         pp.setProduct_price(String.valueOf(rs.getInt("ProducePrice")));
/*    */         
/* 44 */         list.add(pp);
/*    */       }
/*    */       
/* 47 */       ConnectionManager.close(rs);
/* 48 */       ConnectionManager.close(st);
/* 49 */       ConnectionManager.close(con);
/*    */     } catch (Exception e) {
/* 51 */       e.printStackTrace();
/*    */     }
/*    */     
/* 54 */     return list;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\interface_impl\PurchasedProductsInterface_impl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */