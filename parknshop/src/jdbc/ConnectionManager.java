/*    */ package jdbc;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.Statement;
/*    */ 
/*    */ public class ConnectionManager
/*    */ {
/*    */   public static Connection getConnection() throws Exception
/*    */   {
/* 11 */     String driver = "com.mysql.jdbc.Driver";
/* 12 */     String url = "jdbc:mysql://localhost/parknshop3";
/* 13 */     String user = "root";
/* 14 */     String password = "zr19631026..";
/* 15 */     Class.forName(driver);
/* 16 */     Connection con = java.sql.DriverManager.getConnection(url, user, password);
/* 17 */     System.out.println("DataBase Connection Success!");
/* 18 */     return con;
/*    */   }
/*    */   
/*    */   public static void close(Connection con) throws java.sql.SQLException {
/* 22 */     if (con != null) {
/* 23 */       con.close();
/*    */     }
/*    */   }
/*    */   
/*    */   public static void close(Statement st) throws java.sql.SQLException {
/* 28 */     if (st != null) {
/* 29 */       st.close();
/*    */     }
/*    */   }
/*    */   
/*    */   public static void close(ResultSet rs) throws java.sql.SQLException {
/* 34 */     if (rs != null) {
/* 35 */       rs.close();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\jdbc\ConnectionManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */