/*    */ package interface_impl;
/*    */ 
/*    */ import interface_servlet.UserLoginInterface;
/*    */ import java.io.PrintStream;
/*    */ import java.sql.Connection;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.Statement;
/*    */ import jdbc.ConnectionManager;
/*    */ 
/*    */ public class UserLoginInterface_impl
/*    */   implements UserLoginInterface
/*    */ {
/*    */   public int userlogin(String customername, String password, int logintype)
/*    */   {
/* 15 */     String sql = "";
/* 16 */     switch (logintype)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */     case 1: 
/* 22 */       sql = "select CustomerName,CustomerPwd from customerinfo  where CustomerName='" + customername + "' and CustomerPwd='" + password + "' and AccountState=1 and Status=0";
/* 23 */       break;
/*    */     case 2: 
/* 25 */       sql = "select CustomerName,CustomerPwd from customerinfo  where CustomerName='" + customername + "' and CustomerPwd='" + password + "' and AccountState=2 and Status=0";
/* 26 */       break;
/*    */     case 3: 
/* 28 */       sql = "SELECT AdminName,AdminPwd  FROM admininfo WHERE AdminName='" + customername + "' and AdminPwd='" + password + "'";
/*    */     }
/*    */     
/*    */     
/*    */ 
/* 33 */     System.out.println(sql);
/*    */     
/* 35 */     if (judge(customername, password, sql))
/*    */     {
/* 37 */       return 1;
/*    */     }
/* 39 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private boolean judge(String customername, String password, String sql)
/*    */   {
/* 47 */     Connection con = null;
/* 48 */     Statement st = null;
/* 49 */     ResultSet rs = null;
/*    */     try {
/* 51 */       con = ConnectionManager.getConnection();
/* 52 */       st = con.createStatement();
/* 53 */       rs = st.executeQuery(sql);
/*    */       
/* 55 */       while (rs.next())
/*    */       {
/*    */ 
/* 58 */         if ((customername.equals(rs.getString(1))) && (password.equals(rs.getString(2))))
/*    */         {
/* 60 */           return true;
/*    */         }
/*    */       }
/*    */       
/* 64 */       ConnectionManager.close(rs);
/* 65 */       ConnectionManager.close(st);
/* 66 */       ConnectionManager.close(con);
/* 67 */       return false;
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 71 */       e.printStackTrace();
/*    */     }
/*    */     
/*    */ 
/* 75 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\interface_impl\UserLoginInterface_impl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */