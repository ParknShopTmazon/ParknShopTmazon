/*    */ package admin.util;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.sql.Connection;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Test_MySql
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/*    */     try
/*    */     {
/* 17 */       DBHelper dbhelper = new DBHelper();
/*    */       
/*    */ 
/* 20 */       Connection conn = dbhelper.createConnection();
/*    */       
/* 22 */       if (conn.isClosed()) {
/* 23 */         System.out.println("杩炴帴澶辫触");
/*    */       } else {
/* 25 */         System.out.println("杩炴帴鎴愬姛");
/*    */       }
/*    */       
/*    */ 
/* 29 */       conn.close();
/*    */     }
/*    */     catch (Exception e) {
/* 32 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }
