/*    */ package admin.dao;
/*    */ 
/*    */ import admin.util.DBHelper;
/*    */ 
/*    */ public class ProductTypeDAO
/*    */ {
/*    */   public String getAnyTypes(int TypeID)
/*    */   {
/*  9 */     String sql = "select TypeName from Producttype where TypeID=?";
/* 10 */     String TypeName = null;
/*    */     
/* 12 */     DBHelper dbhelper = new DBHelper();
/*    */     
/* 14 */     Object[] values = new Object[1];
/* 15 */     values[0] = Integer.valueOf(TypeID);
/*    */     try
/*    */     {
/* 18 */       java.sql.ResultSet rs = dbhelper.executeQuery(sql, values);
/* 19 */       if (rs.next())
/*    */       {
/* 21 */         return rs.getString("TypeName");
/*    */       }
/*    */       
/* 24 */       dbhelper.closeDB();
/*    */     }
/*    */     catch (Exception e) {
/* 27 */       e.printStackTrace();
/*    */     }
/* 29 */     return TypeName;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int AddTypes(String TypeName)
/*    */   {
/* 36 */     String sql = "select TypeID from Producttype where TypeName=?";
/* 37 */     int a = 0;
/*    */     
/* 39 */     DBHelper dbhelper = new DBHelper();
/*    */     
/* 41 */     Object[] values = new Object[1];
/* 42 */     values[0] = TypeName;
/*    */     try
/*    */     {
/* 45 */       java.sql.ResultSet rs = dbhelper.executeQuery(sql, values);
/* 46 */       if (rs.next())
/*    */       {
/* 48 */         a = rs.getInt("TypeID");
/* 49 */         a = 0 - a;
/*    */ 
/*    */ 
/*    */       }
/* 53 */       else if (TypeName.length() <= 45)
/*    */       {
/* 55 */         sql = "insert into Producttype(TypeName) values(?)";
/* 56 */         dbhelper.executeUpdate(sql, values);
/*    */         
/* 58 */         sql = "select TypeID from Producttype where TypeName=?";
/* 59 */         rs = dbhelper.executeQuery(sql, values);
/* 60 */         if (rs.next()) {
/* 61 */           a = rs.getInt("TypeID");
/*    */         }
/*    */       } else {
/* 64 */         a = 0;
/*    */       }
/* 66 */       dbhelper.closeDB();
/*    */     }
/*    */     catch (Exception e) {
/* 69 */       e.printStackTrace();
/*    */     }
/* 71 */     return a;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\dao\ProductTypeDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */