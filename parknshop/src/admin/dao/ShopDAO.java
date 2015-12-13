/*     */ package admin.dao;
/*     */ 
/*     */ import admin.entity.Productinfo;
/*     */ import admin.entity.Shopinfo;
/*     */ import admin.util.DBHelper;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShopDAO
/*     */ {
/*     */   public List<Shopinfo> getAllShops()
/*     */   {
/*  16 */     List<Shopinfo> Cs = new ArrayList();
/*  17 */     String sql = "select * from shopinfo";
/*     */     
/*  19 */     DBHelper dbhelper = new DBHelper();
/*     */     try
/*     */     {
/*  22 */       ResultSet rs = dbhelper.executeQuery(sql, null);
/*  23 */       while (rs.next())
/*     */       {
/*  25 */         Shopinfo C = new Shopinfo();
/*  26 */         C.setShopInfoId(Integer.valueOf(rs.getInt("ShopInfoID")));
/*  27 */         C.setCustomerName(rs.getString("CustomerName"));
/*  28 */         C.setShopInfoName(rs.getString("ShopInfoName"));
/*  29 */         C.setShopInfoDescription(rs.getString("ShopInfoDescription"));
/*  30 */         C.setStatus(rs.getInt("Status"));
/*  31 */         if (rs.getInt("Status") == -1) {
/*  32 */           C.setStatus1("Normal");
/*  33 */         } else if (rs.getInt("Status") == 1) {
/*  34 */           C.setStatus1("Reported");
/*  35 */         } else if (rs.getInt("Status") == 2) {
/*  36 */           C.setStatus1("Refused");
/*  37 */         } else if (rs.getInt("Status") == 0) {
/*  38 */           C.setStatus1("Examing");
/*     */         }
/*  40 */         Cs.add(C);
/*     */       }
/*  42 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/*  45 */       e.printStackTrace();
/*     */     }
/*  47 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Shopinfo> getShops(int Status)//选择和传过来参数一样的东西 0 代表审核中的店子
/*     */   {
/*  54 */     List<Shopinfo> Cs = new ArrayList();
/*  55 */     String sql = "select * from Shopinfo where Status=?";
/*     */     
/*  57 */     DBHelper dbhelper = new DBHelper();
/*     */     
/*  59 */     Object[] values = new Object[1];
/*  60 */     values[0] = Integer.valueOf(Status);
/*     */     try
/*     */     {
/*  63 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/*  64 */       while (rs.next())
/*     */       {
/*  66 */         Shopinfo C = new Shopinfo();
/*  67 */         C.setShopInfoId(Integer.valueOf(rs.getInt("ShopInfoID")));
/*  68 */         C.setCustomerName(rs.getString("CustomerName"));
/*  69 */         C.setShopInfoName(rs.getString("ShopInfoName"));
/*  70 */         C.setShopInfoDescription(rs.getString("ShopInfoDescription"));
/*  71 */         C.setStatus(rs.getInt("Status"));
/*  72 */         if (rs.getInt("Status") == -1) {
/*  73 */           C.setStatus1("Normal");
/*  74 */         } else if (rs.getInt("Status") == 1) {
/*  75 */           C.setStatus1("Reported");
/*  76 */         } else if (rs.getInt("Status") == 2) {
/*  77 */           C.setStatus1("Refused");
/*  78 */         } else if (rs.getInt("Status") == 0)
/*  79 */           C.setStatus1("Examing");
/*  80 */         Cs.add(C);
/*     */       }
/*  82 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/*  85 */       e.printStackTrace();
/*     */     }
/*  87 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Shopinfo> getSomeShops(String about)
/*     */   {
/*  95 */     List<Shopinfo> Cs = new ArrayList();
/*  96 */     String sql = "select * from Shopinfo where ShopInfoName=?";
/*  97 */     String sql1 = "select * from Shopinfo where ShopInfoID=?";
/*     */     
/*  99 */     DBHelper dbhelper = new DBHelper();
/*     */     
/* 101 */     Object[] values = new Object[1];
/*     */     
/*     */     try
/*     */     {
/* 105 */       if (about.matches("[0-9]*"))
/*     */       {
/* 107 */         if (about.length() <= 10)
/*     */         {
/* 109 */           values[0] = Integer.valueOf(about);
/* 110 */           ResultSet rs = dbhelper.executeQuery(sql1, values);
/* 111 */           while (rs.next())
/*     */           {
/* 113 */             Shopinfo C = new Shopinfo();
/* 114 */             C.setShopInfoId(Integer.valueOf(rs.getInt("ShopInfoID")));
/* 115 */             C.setCustomerName(rs.getString("CustomerName"));
/* 116 */             C.setShopInfoName(rs.getString("ShopInfoName"));
/* 117 */             C.setShopInfoDescription(rs.getString("ShopInfoDescription"));
/* 118 */             C.setStatus(rs.getInt("Status"));
/* 119 */             if (rs.getInt("Status") == -1) {
/* 120 */               C.setStatus1("Normal");
/* 121 */             } else if (rs.getInt("Status") == 1) {
/* 122 */               C.setStatus1("Reported");
/* 123 */             } else if (rs.getInt("Status") == 2) {
/* 124 */               C.setStatus1("Refused");
/* 125 */             } else if (rs.getInt("Status") == 0)
/* 126 */               C.setStatus1("Examing");
/* 127 */             Cs.add(C);
/*     */           }
/*     */           
/* 130 */           rs = dbhelper.executeQuery(sql, values);
/* 131 */           while (rs.next())
/*     */           {
/* 133 */             Shopinfo C = new Shopinfo();
/* 134 */             C.setShopInfoId(Integer.valueOf(rs.getInt("ShopInfoID")));
/* 135 */             C.setCustomerName(rs.getString("CustomerName"));
/* 136 */             C.setShopInfoName(rs.getString("ShopInfoName"));
/* 137 */             C.setShopInfoDescription(rs.getString("ShopInfoDescription"));
/* 138 */             C.setStatus(rs.getInt("Status"));
/* 139 */             if (rs.getInt("Status") == -1) {
/* 140 */               C.setStatus1("Normal");
/* 141 */             } else if (rs.getInt("Status") == 1) {
/* 142 */               C.setStatus1("Reported");
/* 143 */             } else if (rs.getInt("Status") == 2) {
/* 144 */               C.setStatus1("Refused");
/* 145 */             } else if (rs.getInt("Status") == 0)
/* 146 */               C.setStatus1("Examing");
/* 147 */             Cs.add(C);
/*     */           }
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 153 */         values[0] = about;
/* 154 */         ResultSet rs = dbhelper.executeQuery(sql, values);
/* 155 */         while (rs.next())
/*     */         {
/* 157 */           Shopinfo C = new Shopinfo();
/* 158 */           C.setShopInfoId(Integer.valueOf(rs.getInt("ShopInfoID")));
/* 159 */           C.setCustomerName(rs.getString("CustomerName"));
/* 160 */           C.setShopInfoName(rs.getString("ShopInfoName"));
/* 161 */           C.setShopInfoDescription(rs.getString("ShopInfoDescription"));
/* 162 */           C.setStatus(rs.getInt("Status"));
/* 163 */           if (rs.getInt("Status") == -1) {
/* 164 */             C.setStatus1("Normal");
/* 165 */           } else if (rs.getInt("Status") == 1) {
/* 166 */             C.setStatus1("Reported");
/* 167 */           } else if (rs.getInt("Status") == 2) {
/* 168 */             C.setStatus1("Refused");
/* 169 */           } else if (rs.getInt("Status") == 0)
/* 170 */             C.setStatus1("Examing");
/* 171 */           Cs.add(C);
/*     */         }
/*     */       }
/*     */       
/* 175 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 178 */       e.printStackTrace();
/*     */     }
/* 180 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Shopinfo> getAnyShops(int ShopInfoID)
/*     */   {
/* 187 */     List<Shopinfo> Cs = new ArrayList();
/* 188 */     String sql = "select * from Shopinfo where ShopInfoID=?";
/*     */     
/* 190 */     DBHelper dbhelper = new DBHelper();
/*     */     
/* 192 */     Object[] values = new Object[1];
/* 193 */     values[0] = Integer.valueOf(ShopInfoID);
/*     */     try
/*     */     {
/* 196 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/* 197 */       while (rs.next())
/*     */       {
/* 199 */         Shopinfo C = new Shopinfo();
/* 200 */         C.setShopInfoId(Integer.valueOf(rs.getInt("ShopInfoID")));
/* 201 */         C.setCustomerName(rs.getString("CustomerName"));
/* 202 */         C.setShopInfoName(rs.getString("ShopInfoName"));
/* 203 */         C.setShopInfoDescription(rs.getString("ShopInfoDescription"));
/* 204 */         C.setStatus(rs.getInt("Status"));
/* 205 */         if (rs.getInt("Status") == -1) {
/* 206 */           C.setStatus1("Normal");
/* 207 */         } else if (rs.getInt("Status") == 1) {
/* 208 */           C.setStatus1("Reported");
/* 209 */         } else if (rs.getInt("Status") == 2) {
/* 210 */           C.setStatus1("Refused");
/* 211 */         } else if (rs.getInt("Status") == 0)
/* 212 */           C.setStatus1("Examing");
/* 213 */         Cs.add(C);
/*     */       }
/* 215 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 218 */       e.printStackTrace();
/*     */     }
/* 220 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Productinfo> getAllProducts(int ShopInfoID)
/*     */   {
/* 227 */     List<Productinfo> Cs = new ArrayList();
/* 228 */     String sql = "select * from Productinfo where ProductID IN(select ProductID from ShopProduct where ShopInfoID=?)";
/*     */     
/* 230 */     DBHelper dbhelper = new DBHelper();
/*     */     
/* 232 */     Object[] values = new Object[1];
/* 233 */     values[0] = Integer.valueOf(ShopInfoID);
/*     */     try
/*     */     {
/* 236 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/*     */       
/*     */ 
/* 239 */       while (rs.next())
/*     */       {
/* 241 */         Productinfo C = new Productinfo();
/* 242 */         C.setProductId(Integer.valueOf(rs.getInt("ProductID")));
/* 243 */         C.setProductTypeId(rs.getInt("ProductTypeID"));
/*     */         
/* 245 */         C.setProductName(rs.getString("ProductName"));
/* 246 */         C.setProductDescription(rs.getString("ProductDescription"));
/* 247 */         C.setProductDetail(rs.getString("ProductDetail"));
/*     */         
/* 249 */         C.setPrice(Double.valueOf(rs.getDouble("Price")));
/* 250 */         Cs.add(C);
/*     */       }
/* 252 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 255 */       e.printStackTrace();
/*     */     }
/* 257 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int AddShop(String CustomerName, String ShopInfoName, String ShopInfoDescription)
/*     */   {
/* 264 */     String sql = "select * from where ShopInfoName=?";
/* 265 */     int a = 0;
/*     */     
/* 267 */     DBHelper dbhelper = new DBHelper();
/*     */     
/* 269 */     Object[] values = new Object[1];
/* 270 */     values[0] = ShopInfoName;
/*     */     try
/*     */     {
/* 273 */       if (ShopInfoName.length() <= 45)
/*     */       {
/* 275 */         ResultSet rs = dbhelper.executeQuery(sql, values);
/* 276 */         if (!rs.next())
/*     */         {
/* 278 */           sql = "insert into Shopinfo(CustomerName,ShopInfoName,ShopInfoDescription,Status) VALUES(?,?,?,-1)";
/*     */           
/* 280 */           Object[] valuess = new Object[3];
/* 281 */           valuess[0] = CustomerName;
/* 282 */           valuess[1] = ShopInfoName;
/* 283 */           valuess[2] = ShopInfoDescription;
/*     */           
/* 285 */           dbhelper.executeUpdate(sql, valuess);
/*     */         }
/*     */         else {
/* 288 */           a = 2;
/*     */         }
/*     */       } else {
/* 291 */         a = 1;
/*     */       }
/* 293 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 296 */       e.printStackTrace();
/*     */     }
/* 298 */     return a;
/*     */   }
/*     */   
/*     */ 
/*     */   public int RefuseShop(int ShopInfoID)
/*     */   {
/* 304 */     String sql = "select * from Shopinfo where ShopInfoID=?";
/* 305 */     int a = 0;
/*     */     
/* 307 */     DBHelper dbhelper = new DBHelper();
/*     */     
/* 309 */     Object[] values = new Object[1];
/* 310 */     values[0] = Integer.valueOf(ShopInfoID);
/*     */     try
/*     */     {
/* 313 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/* 314 */       if (rs.next())
/*     */       {
/* 316 */         sql = "update Shopinfo set Status=2 where ShopInfoID=?";
/* 317 */         dbhelper.executeUpdate(sql, values);
/*     */       }
/*     */       else {
/* 320 */         a = -1; }
/* 321 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 324 */       e.printStackTrace();
/*     */     }
/* 326 */     return a;
/*     */   }
/*     */   
/*     */ 
/*     */   public void ApproveShop(int ShopInfoID)
/*     */   {
/* 332 */     String sql = "update Shopinfo set Status=-1 where ShopInfoID=?";//批准就是设置status=-1
/*     */     
/* 334 */     DBHelper dbhelper = new DBHelper();
/*     */     
/* 336 */     Object[] values = new Object[1];
/* 337 */     values[0] = Integer.valueOf(ShopInfoID);
/*     */     
/*     */     try
/*     */     {
/* 341 */       dbhelper.executeUpdate(sql, values);
/* 342 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 346 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public int NormalizeShop(int ShopInfoID)
/*     */   {
/* 353 */     String sql = "select * from Shopinfo where ShopInfoID=?";
/* 354 */     int a = 0;
/*     */     
/* 356 */     DBHelper dbhelper = new DBHelper();
/*     */     
/* 358 */     Object[] values = new Object[1];
/* 359 */     values[0] = Integer.valueOf(ShopInfoID);
/*     */     try
/*     */     {
/* 362 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/* 363 */       if (rs.next())
/*     */       {
/* 365 */         sql = "update Shopinfo set Status=-1 where ShopInfoID=?";
/* 366 */         dbhelper.executeUpdate(sql, values);
/*     */       }
/*     */       else {
/* 369 */         a = -1; }
/* 370 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 373 */       e.printStackTrace();
/*     */     }
/* 375 */     return a;
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\dao\ShopDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */