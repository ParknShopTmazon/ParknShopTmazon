/*    */ package interface_impl;
/*    */ 
/*    */ import interface_servlet.UserRegisteredInterface;
/*    */ import java.sql.Connection;
/*    */ import java.sql.Date;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.Statement;
/*    */ import jdbc.ConnectionManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserRegisteredInterface_impl
/*    */   implements UserRegisteredInterface
/*    */ {
/*    */   public int userregistered(String name, String password, String realname, String email, String phone, String identityid)
/*    */   {
/* 18 */     String sql = "INSERT INTO customerinfo(CustomerName,CustomerPwd,RealName,Email,PhoneNumber,identityid,AccountState,AccountBalence,RegTime) VALUES(?,?,?,?,?,?,?,?,?) ";
/* 19 */     int mark = 0;
/*    */     try {
/* 21 */       Connection con = ConnectionManager.getConnection();
/* 22 */       PreparedStatement ps = con.prepareStatement(sql);
/* 23 */       ps.setString(1, name);
/* 24 */       ps.setString(2, password);
/* 25 */       ps.setString(3, realname);
/* 26 */       ps.setString(4, email);
/* 27 */       ps.setString(5, phone);
/* 28 */       ps.setString(6, identityid);
/* 29 */       ps.setInt(7, 1);
/* 30 */       ps.setDouble(8, 100000.0D);
/* 31 */       ps.setDate(9, new Date(System.currentTimeMillis()));
/* 32 */       mark = ps.executeUpdate();
/*    */       
/* 34 */       ConnectionManager.close(con);
/* 35 */       ConnectionManager.close(ps);
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 39 */       e.printStackTrace();
/*    */     }
/*    */     
/* 42 */     return mark;
/*    */   }
/*    */   
/*    */ 
/*    */   public int checkusername(String name)
/*    */   {
/* 48 */     String sql = "select CustomerName from customerinfo where CustomerName=" + name;
/* 49 */     int mark = 0;
/*    */     try {
/* 51 */       Connection con = ConnectionManager.getConnection();
/* 52 */       Statement st = con.createStatement();
/* 53 */       ResultSet rs = st.executeQuery(sql);
/* 54 */       rs.next();
/* 55 */       if (name.equals(rs.getString("CustomerName")))
/*    */       {
/* 57 */         mark = 1;
/*    */       } else {
/* 59 */         mark = 0;
/*    */       }
/*    */       
/* 62 */       ConnectionManager.close(rs);
/* 63 */       ConnectionManager.close(st);
/* 64 */       ConnectionManager.close(con);
/*    */ 
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 69 */       e.printStackTrace();
/*    */     }
/*    */     
/* 72 */     return mark;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\interface_impl\UserRegisteredInterface_impl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */