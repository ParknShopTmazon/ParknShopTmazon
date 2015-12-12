/*    */ package admin.util;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ 
/*    */ 
/*    */ public class DBHelper
/*    */ {
/* 12 */   public static String user = "root";
/* 13 */   public static String pwd = "";
/* 14 */   public static String url = "jdbc:mysql://localhost:3306/parknshop3?useUnicode=true&characterEncoding=utf8";
/* 15 */   private Connection conn = null;
/* 16 */   private PreparedStatement statement = null;
/* 17 */   private ResultSet rs = null;
/*    */   
/*    */   public Connection createConnection()
/*    */   {
/*    */     try {
/* 22 */       Class.forName("com.mysql.jdbc.Driver");
/* 23 */       this.conn = DriverManager.getConnection(url, user, pwd);
				System.out.println("databse connected yeah");
/* 24 */       return this.conn;
/*    */     }
/*    */     catch (Exception e) {
/* 27 */       e.printStackTrace();
/*    */     }
/* 29 */     return null;
/*    */   }
/*    */   
/*    */   public void executeUpdate(String sql, Object[] values)
/*    */   {
/*    */     try {
/* 35 */       createConnection();
/* 36 */       this.statement = this.conn.prepareStatement(sql);
/* 37 */       if ((values != null) && (values.length > 0))
/*    */       {
/* 39 */         for (int i = 0; i < values.length; i++)
/*    */         {
/* 41 */           this.statement.setObject(i + 1, values[i]);
/*    */         }
/*    */       }
/* 44 */       this.statement.executeUpdate();
/*    */     }
/*    */     catch (SQLException e) {
/* 47 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */   
/*    */   public ResultSet executeQuery(String sql, Object[] values)
/*    */   {
/*    */     try {
/* 54 */       createConnection();
/* 55 */       this.statement = this.conn.prepareStatement(sql);
/* 56 */       if ((values != null) && (values.length > 0))
/*    */       {
/* 58 */         for (int i = 0; i < values.length; i++)
/*    */         {
/* 60 */           this.statement.setObject(i + 1, values[i]);
/*    */         }
/*    */       }
/* 63 */       this.rs = this.statement.executeQuery();
/* 64 */       return this.rs;
/*    */     }
/*    */     catch (SQLException e) {
/* 67 */       e.printStackTrace();
/*    */     }
/* 69 */     return null;
/*    */   }
/*    */   
/*    */   public void closeDB()
/*    */   {
/*    */     try {
/* 75 */       if (this.rs != null)
/* 76 */         this.rs.close();
/* 77 */       if (this.statement != null)
/* 78 */         this.statement.close();
/* 79 */       if (this.conn != null) {
/* 80 */         this.conn.close();
/*    */       }
/*    */     } catch (SQLException e) {
/* 83 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

