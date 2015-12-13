/*     */ package admin.dao;
/*     */ 
/*     */ import admin.entity.Result;
/*     */ import admin.util.DBHelper;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ public class SearchDAO
/*     */ {
/*     */   public List<Result> getAll(String about)
/*     */   {
/*  14 */     List<Result> Cs = new ArrayList();
/*     */     
/*  16 */     DBHelper dbhelper = new DBHelper();
/*  17 */     Object[] values = new Object[1];
/*     */     
/*  19 */     String sql = null;
/*     */     
/*     */     try
/*     */     {
/*  23 */       if (about.matches("[0-9]*"))
/*     */       {
/*  25 */         if (about.length() <= 10)
/*     */         {
/*  27 */           values[0] = Integer.valueOf(about);
/*  28 */           sql = "select * from Comments where CommentID=?";
/*  29 */           ResultSet rs = dbhelper.executeQuery(sql, values);
/*  30 */           while (rs.next())
/*     */           {
/*  32 */             Result C = new Result();
/*  33 */             C.setType("Comments");
/*  34 */             C.setIdint(Integer.valueOf(rs.getInt("CommentID")));
/*  35 */             C.setT(Integer.valueOf(2));
/*  36 */             C.setIdstring(Integer.valueOf(rs.getInt("CommentID")).toString());
/*  37 */             Cs.add(C);
/*     */           }
/*     */           
/*     */ 
/*  41 */           values[0] = about;
/*  42 */           sql = "select * from Customerinfo where CustomerName=? ORDER BY CustomerName";
/*  43 */           rs = dbhelper.executeQuery(sql, values);
/*  44 */           while (rs.next())
/*     */           {
/*  46 */             Result C = new Result();
/*  47 */             C.setType("Customers");
/*  48 */             C.setT(Integer.valueOf(1));
/*  49 */             C.setIdstring(rs.getString("CustomerName"));
/*  50 */             Cs.add(C);
/*     */           }
/*     */           
/*  53 */           values[0] = Integer.valueOf(about);
/*  54 */           sql = "select * from Userorder where OrderID=?";
/*  55 */           rs = dbhelper.executeQuery(sql, values);
/*  56 */           while (rs.next())
/*     */           {
/*  58 */             Result C = new Result();
/*  59 */             C.setType("Orders");
/*  60 */             C.setIdint(Integer.valueOf(rs.getInt("OrderID")));
/*  61 */             C.setT(Integer.valueOf(4));
/*  62 */             C.setIdstring(Integer.valueOf(rs.getInt("OrderID")).toString());
/*  63 */             Cs.add(C);
/*     */           }
/*     */           
/*     */ 
/*  67 */           values[0] = Integer.valueOf(about);
/*  68 */           sql = "select * from Shopinfo where ShopInfoID=?";
/*  69 */           rs = dbhelper.executeQuery(sql, values);
/*  70 */           while (rs.next())
/*     */           {
/*  72 */             Result C = new Result();
/*  73 */             C.setType("Shops");
/*  74 */             C.setIdint(Integer.valueOf(rs.getInt("ShopInfoID")));
/*  75 */             C.setT(Integer.valueOf(3));
/*  76 */             C.setIdstring(Integer.valueOf(rs.getInt("ShopInfoID")).toString());
/*  77 */             Cs.add(C);
/*     */           }
/*     */           
/*     */ 
/*  81 */           values[0] = about;
/*  82 */           sql = "select * from Shopinfo where ShopInfoName=?";
/*  83 */           rs = dbhelper.executeQuery(sql, values);
/*  84 */           while (rs.next())
/*     */           {
/*  86 */             Result C = new Result();
/*  87 */             C.setType("Shops");
/*  88 */             C.setT(Integer.valueOf(3));
/*  89 */             C.setIdint(Integer.valueOf(rs.getInt("ShopInfoID")));
/*  90 */             C.setIdstring(Integer.valueOf(rs.getInt("ShopInfoID")).toString());
/*  91 */             Cs.add(C);
/*     */           }
/*     */           
/*     */ 
/*  95 */           values[0] = Integer.valueOf(about);
/*  96 */           sql = "select * from Productinfo where ProductID=?";
/*  97 */           rs = dbhelper.executeQuery(sql, values);
/*  98 */           while (rs.next())
/*     */           {
/* 100 */             Result C = new Result();
/* 101 */             C.setType("Products");
/* 102 */             C.setIdint(Integer.valueOf(rs.getInt("ProductID")));
/* 103 */             C.setT(Integer.valueOf(5));
/* 104 */             C.setIdstring(Integer.valueOf(rs.getInt("ProductID")).toString());
/* 105 */             Cs.add(C);
/*     */           }
/*     */           
/*     */ 
/* 109 */           values[0] = about;
/* 110 */           sql = "select * from Productinfo where ProductName=?";
/* 111 */           rs = dbhelper.executeQuery(sql, values);
/* 112 */           while (rs.next())
/*     */           {
/* 114 */             Result C = new Result();
/* 115 */             C.setType("Products");
/* 116 */             C.setT(Integer.valueOf(5));
/* 117 */             C.setIdint(Integer.valueOf(rs.getInt("ProductID")));
/* 118 */             C.setIdstring(Integer.valueOf(rs.getInt("ProductID")).toString());
/* 119 */             Cs.add(C);
/*     */           }
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 125 */         values[0] = about;
/* 126 */         sql = "select * from Customerinfo where CustomerName=? ORDER BY CustomerName";
/* 127 */         ResultSet rs = dbhelper.executeQuery(sql, values);
/* 128 */         while (rs.next())
/*     */         {
/* 130 */           Result C = new Result();
/* 131 */           C.setType("Customers");
/* 132 */           C.setT(Integer.valueOf(1));
/* 133 */           C.setIdstring(rs.getString("CustomerName"));
/* 134 */           Cs.add(C);
/*     */         }
/*     */         
/* 137 */         values[0] = about;
/* 138 */         sql = "select * from Shopinfo where ShopInfoName=?";
/* 139 */         rs = dbhelper.executeQuery(sql, values);
/* 140 */         while (rs.next())
/*     */         {
/* 142 */           Result C = new Result();
/* 143 */           C.setType("Shops");
/* 144 */           C.setT(Integer.valueOf(3));
/* 145 */           C.setIdint(Integer.valueOf(rs.getInt("ShopInfoID")));
/* 146 */           C.setIdstring(Integer.valueOf(rs.getInt("ShopInfoID")).toString());
/* 147 */           Cs.add(C);
/*     */         }
/*     */         
/*     */ 
/* 151 */         values[0] = about;
/* 152 */         sql = "select * from Productinfo where ProductName=?";
/* 153 */         rs = dbhelper.executeQuery(sql, values);
/* 154 */         while (rs.next())
/*     */         {
/* 156 */           Result C = new Result();
/* 157 */           C.setType("Products");
/* 158 */           C.setT(Integer.valueOf(5));
/* 159 */           C.setIdint(Integer.valueOf(rs.getInt("ProductID")));
/* 160 */           C.setIdstring(Integer.valueOf(rs.getInt("ProductID")).toString());
/* 161 */           Cs.add(C);
/*     */         }
/*     */       }
/*     */       
/* 165 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 168 */       e.printStackTrace();
/*     */     }
/* 170 */     return Cs;
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\dao\SearchDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */