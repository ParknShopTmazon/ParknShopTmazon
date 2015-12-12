/*     */ package admin.dao;
/*     */ 
/*     */ import admin.entity.Productinfo;
/*     */ import admin.util.DBHelper;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ProductDAO
/*     */ {
/*     */   public List<Productinfo> getAnyProducts(String id)
/*     */   {
/*  15 */     List<Productinfo> Cs = new ArrayList();
/*  16 */     String sql = "select * from Productinfo where ProductId=?";
/*     */     
/*  18 */     ProductTypeDAO p = new ProductTypeDAO();
/*     */     
/*  20 */     DBHelper dbhelper = new DBHelper();
/*     */     
/*  22 */     Object[] values = new Object[1];
/*  23 */     if (id.length() >= 10)
/*     */     {
/*  25 */       return Cs;
/*     */     }
/*  27 */     values[0] = Integer.valueOf(id);
/*     */     try
/*     */     {
/*  30 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/*  31 */       while (rs.next())
/*     */       {
/*  33 */         Productinfo C = new Productinfo();
/*  34 */         C.setProductId(Integer.valueOf(rs.getInt("ProductID")));
/*     */         
/*  36 */         C.setProductTypeId(rs.getInt("ProductTypeID"));
/*  37 */         C.setProductType(p.getAnyTypes(rs.getInt("ProductTypeID")));
/*     */         
/*  39 */         C.setProductName(rs.getString("ProductName"));
/*  40 */         C.setProductDescription(rs.getString("ProductDescription"));
/*  41 */         C.setProductDetail(rs.getString("ProductDetail"));
/*     */         
/*  43 */         C.setPrice(Double.valueOf(rs.getDouble("Price")));
/*  44 */         Cs.add(C);
/*     */       }
/*  46 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/*  49 */       e.printStackTrace();
/*     */     }
/*  51 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Productinfo> getSomeProducts(String about)
/*     */   {
/*  58 */     List<Productinfo> Cs = new ArrayList();
/*  59 */     String sql = "select * from Productinfo where ProductId=?";
/*  60 */     String sql1 = "select * from Productinfo where ProductName=?";
/*     */     
/*  62 */     ProductTypeDAO p = new ProductTypeDAO();
/*  63 */     DBHelper dbhelper = new DBHelper();
/*  64 */     Object[] values = new Object[1];
/*     */     
/*     */     try
/*     */     {
/*  68 */       if (about.matches("[0-9]*"))
/*     */       {
/*  70 */         if (about.length() <= 10)
/*     */         {
/*  72 */           values[0] = Integer.valueOf(about);
/*  73 */           ResultSet rs = dbhelper.executeQuery(sql, values);
/*  74 */           while (rs.next())
/*     */           {
/*  76 */             Productinfo C = new Productinfo();
/*  77 */             C.setProductId(Integer.valueOf(rs.getInt("ProductID")));
/*     */             
/*  79 */             C.setProductTypeId(rs.getInt("ProductTypeID"));
/*  80 */             C.setProductType(p.getAnyTypes(rs.getInt("ProductTypeID")));
/*     */             
/*  82 */             C.setProductName(rs.getString("ProductName"));
/*  83 */             C.setProductDescription(rs.getString("ProductDescription"));
/*  84 */             C.setProductDetail(rs.getString("ProductDetail"));
/*     */             
/*  86 */             C.setPrice(Double.valueOf(rs.getDouble("Price")));
/*  87 */             Cs.add(C);
/*     */           }
/*     */           
/*  90 */           values[0] = about;
/*  91 */           rs = dbhelper.executeQuery(sql1, values);
/*  92 */           while (rs.next())
/*     */           {
/*  94 */             Productinfo C = new Productinfo();
/*  95 */             C.setProductId(Integer.valueOf(rs.getInt("ProductID")));
/*     */             
/*  97 */             C.setProductTypeId(rs.getInt("ProductTypeID"));
/*  98 */             C.setProductType(p.getAnyTypes(rs.getInt("ProductTypeID")));
/*     */             
/* 100 */             C.setProductName(rs.getString("ProductName"));
/* 101 */             C.setProductDescription(rs.getString("ProductDescription"));
/* 102 */             C.setProductDetail(rs.getString("ProductDetail"));
/*     */             
/* 104 */             C.setPrice(Double.valueOf(rs.getDouble("Price")));
/* 105 */             Cs.add(C);
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 112 */         values[0] = about;
/* 113 */         ResultSet rs = dbhelper.executeQuery(sql1, values);
/* 114 */         while (rs.next())
/*     */         {
/* 116 */           Productinfo C = new Productinfo();
/* 117 */           C.setProductId(Integer.valueOf(rs.getInt("ProductID")));
/*     */           
/* 119 */           C.setProductTypeId(rs.getInt("ProductTypeID"));
/* 120 */           C.setProductType(p.getAnyTypes(rs.getInt("ProductTypeID")));
/*     */           
/* 122 */           C.setProductName(rs.getString("ProductName"));
/* 123 */           C.setProductDescription(rs.getString("ProductDescription"));
/* 124 */           C.setProductDetail(rs.getString("ProductDetail"));
/*     */           
/* 126 */           C.setPrice(Double.valueOf(rs.getDouble("Price")));
/* 127 */           Cs.add(C);
/*     */         }
/*     */       }
/* 130 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 133 */       e.printStackTrace();
/*     */     }
/* 135 */     return Cs;
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\dao\ProductDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */