/*     */ package admin.dao;
/*     */ 
/*     */ import admin.entity.ADs;
/*     */ import admin.util.DBHelper;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ public class ADDAO
/*     */ {
/*     */   public List<ADs> getAllADs()
/*     */   {
/*  14 */     List<ADs> Cs = new ArrayList();
/*  15 */     String sql = "select * from ads";
/*     */     
/*  17 */     DBHelper dbhelper = new DBHelper();
/*     */     try
/*     */     {
/*  20 */       ResultSet rs = dbhelper.executeQuery(sql, null);
/*  21 */       while (rs.next())
/*     */       {
/*  23 */         ADs C = new ADs();
/*  24 */         C.setAdId(Integer.valueOf(rs.getInt("AdID")));
/*  25 */         C.setProductId(rs.getString("ProductID"));
/*  26 */         C.setImagePath(rs.getString("ImagePath"));
/*  27 */         C.setURL(rs.getString("URL"));
/*  28 */         Cs.add(C);
/*     */       }
/*  30 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/*  33 */       e.printStackTrace();
/*     */     }
/*  35 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<ADs> getAnyADs(int AdId)
/*     */   {
/*  41 */     List<ADs> Cs = new ArrayList();
/*  42 */     String sql = "select * from ads where AdId=?";
/*     */     
/*  44 */     DBHelper dbhelper = new DBHelper();
/*     */     
/*  46 */     Object[] values = new Object[1];
/*  47 */     values[0] = Integer.valueOf(AdId);
/*     */     try
/*     */     {
/*  50 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/*  51 */       while (rs.next())
/*     */       {
/*  53 */         ADs C = new ADs();
/*  54 */         C.setAdId(Integer.valueOf(rs.getInt("AdID")));
/*  55 */         C.setProductId(rs.getString("ProductID"));
/*  56 */         C.setImagePath(rs.getString("ImagePath"));
/*  57 */         C.setURL(rs.getString("URL"));
/*  58 */         Cs.add(C);
/*     */       }
/*  60 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/*  63 */       e.printStackTrace();
/*     */     }
/*  65 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void AddProductAD(String ProductID, String ImagePath)
/*     */   {
/*  72 */     DBHelper dbhelper = new DBHelper();
/*     */     try
/*     */     {
/*  75 */       Object[] values1 = new Object[3];
/*  76 */       values1[0] = Integer.valueOf(ProductID);
/*  77 */       values1[1] = ImagePath;
/*  78 */       values1[2] = ("ProductDetailServlet?product_ID=" + ProductID);
/*     */       
/*  80 */       String sql = "insert into ads(ProductID,ImagePath,URL) values(?,?,?)";
/*  81 */       dbhelper.executeUpdate(sql, values1);
/*  82 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/*  85 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void AddImageAD(String ImagePath)
/*     */   {
/*  92 */     String sql = "insert into ads(ImagePath) values(?)";
/*     */     
/*  94 */     Object[] values = new Object[1];
/*  95 */     values[0] = ImagePath;
/*     */     
/*  97 */     DBHelper dbhelper = new DBHelper();
/*     */     try
/*     */     {
/* 100 */       dbhelper.executeUpdate(sql, values);
/*     */       
/* 102 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 105 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void AddLinkAD(String ImagePath, String URL)
/*     */   {
/* 113 */     String sql = "insert into ads(ImagePath,URL) values(?,?)";
/*     */     
/* 115 */     Object[] values = new Object[2];
/* 116 */     values[0] = ImagePath;
/* 117 */     values[1] = URL;
/*     */     
/* 119 */     DBHelper dbhelper = new DBHelper();
/*     */     try
/*     */     {
/* 122 */       dbhelper.executeUpdate(sql, values);
/*     */       
/* 124 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 127 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void DeleteAD(int AdId)
/*     */   {
/* 134 */     String sql = "delete from ads where AdID=?";
/*     */     
/* 136 */     Object[] values = new Object[1];
/* 137 */     values[0] = Integer.valueOf(AdId);
/*     */     
/* 139 */     DBHelper dbhelper = new DBHelper();
/*     */     try
/*     */     {
/* 142 */       dbhelper.executeUpdate(sql, values);
/*     */       
/* 144 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 147 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\dao\ADDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */