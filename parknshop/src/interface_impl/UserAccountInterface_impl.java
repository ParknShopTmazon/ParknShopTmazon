/*    */ package interface_impl;
/*    */ 
/*    */ import interface_servlet.UserAccountInterface;
/*    */ import java.sql.Connection;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.Statement;
/*    */ import jdbc.ConnectionManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserAccountInterface_impl
/*    */   implements UserAccountInterface
/*    */ {
/*    */   public double useraccount(String customername)
/*    */   {
/* 16 */     String sql = "SELECT AccountBalence  from customerinfo where CustomerName='" + customername + "'";
/* 17 */     double AccountBalence = 0.0D;
/*    */     try
/*    */     {
/* 20 */       Connection con = ConnectionManager.getConnection();
/* 21 */       Statement st = con.createStatement();
/* 22 */       ResultSet rs = st.executeQuery(sql);
/* 23 */       while (rs.next())
/*    */       {
/* 25 */         AccountBalence = rs.getDouble("AccountBalence");
/*    */       }
/*    */       
/* 28 */       ConnectionManager.close(rs);
/* 29 */       ConnectionManager.close(st);
/* 30 */       ConnectionManager.close(con);
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 34 */       e.printStackTrace();
/*    */     }
/*    */     
/*    */ 
/* 38 */     return AccountBalence;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\interface_impl\UserAccountInterface_impl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */