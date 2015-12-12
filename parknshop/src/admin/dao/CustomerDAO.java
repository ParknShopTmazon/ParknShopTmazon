/*     */ package admin.dao;
/*     */ 
/*     */ import admin.entity.Customerinfo;
/*     */ import admin.util.DBHelper;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustomerDAO
/*     */ {
/*     */   public List<Customerinfo> getALLCustomers()
/*     */   {
/*  15 */     List<Customerinfo> Cs = new ArrayList();
/*  16 */     String sql = "select * from Customerinfo ORDER BY CustomerName";
/*     */     
/*  18 */     DBHelper dbhelper = new DBHelper();
/*     */     try
/*     */     {
/*  21 */       ResultSet rs = dbhelper.executeQuery(sql, null);
/*  22 */       while (rs.next())
/*     */       {
/*  24 */         Customerinfo C = new Customerinfo();
/*  25 */         C.setCustomerName(rs.getString("CustomerName"));
/*  26 */         C.setCustomerPwd(rs.getString("CustomerPwd"));
/*  27 */         C.setRealName(rs.getString("RealName"));
/*  28 */         C.setSex(rs.getString("Sex"));
/*  29 */         C.setEmail(rs.getString("Email"));
/*  30 */         C.setPhoneNumber(rs.getString("PhoneNumber"));
/*  31 */         C.setIdentityId(rs.getString("IdentityId"));
/*  32 */         C.setAddress(rs.getString("Address"));
/*     */         
/*  34 */         C.setAccountState(Short.valueOf(rs.getShort("AccountState")));
/*  35 */         if (rs.getShort("AccountState") == 1) {
/*  36 */           C.setState("Buyer");
/*  37 */         } else if (rs.getShort("AccountState") == 2) {
/*  38 */           C.setState("Seller");
/*     */         }
/*  40 */         C.setRegTime(rs.getDate("RegTime"));
/*  41 */         C.setAccountBalence(Double.valueOf(rs.getDouble("AccountBalence")));
/*     */         
/*  43 */         C.setStatus(Integer.valueOf(rs.getInt("Status")));
/*  44 */         if (rs.getInt("Status") == 0) {
/*  45 */           C.setStatus1("Normal");
/*  46 */         } else if (rs.getInt("Status") == 1) {
/*  47 */           C.setStatus1("Reported");
/*  48 */         } else if (rs.getInt("Status") == 2)
/*  49 */           C.setStatus1("Covered");
/*  50 */         Cs.add(C);
/*     */       }
/*  52 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/*  55 */       e.printStackTrace();
/*     */     }
/*  57 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Customerinfo> getALLBuyers()
/*     */   {
/*  64 */     List<Customerinfo> Cs = new ArrayList();
/*  65 */     String sql = "select * from Customerinfo where AccountState=1 AND STATUS<>2 ORDER BY CustomerName";
/*     */     
/*  67 */     DBHelper dbhelper = new DBHelper();
/*     */     try
/*     */     {
/*  70 */       ResultSet rs = dbhelper.executeQuery(sql, null);
/*  71 */       while (rs.next())
/*     */       {
/*  73 */         Customerinfo C = new Customerinfo();
/*  74 */         C.setCustomerName(rs.getString("CustomerName"));
/*  75 */         C.setCustomerPwd(rs.getString("CustomerPwd"));
/*  76 */         C.setRealName(rs.getString("RealName"));
/*  77 */         C.setSex(rs.getString("Sex"));
/*  78 */         C.setEmail(rs.getString("Email"));
/*  79 */         C.setPhoneNumber(rs.getString("PhoneNumber"));
/*  80 */         C.setIdentityId(rs.getString("IdentityId"));
/*  81 */         C.setAddress(rs.getString("Address"));
/*     */         
/*  83 */         C.setAccountState(Short.valueOf(rs.getShort("AccountState")));
/*  84 */         if (rs.getShort("AccountState") == 1) {
/*  85 */           C.setState("Buyer");
/*  86 */         } else if (rs.getShort("AccountState") == 2) {
/*  87 */           C.setState("Seller");
/*     */         }
/*  89 */         C.setRegTime(rs.getDate("RegTime"));
/*  90 */         C.setAccountBalence(Double.valueOf(rs.getDouble("AccountBalence")));
/*     */         
/*  92 */         C.setStatus(Integer.valueOf(rs.getInt("Status")));
/*  93 */         if (rs.getInt("Status") == 0) {
/*  94 */           C.setStatus1("Normal");
/*  95 */         } else if (rs.getInt("Status") == 1) {
/*  96 */           C.setStatus1("Reported");
/*  97 */         } else if (rs.getInt("Status") == 2)
/*  98 */           C.setStatus1("Covered");
/*  99 */         Cs.add(C);
/*     */       }
/* 101 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 104 */       e.printStackTrace();
/*     */     }
/* 106 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Customerinfo> getALLSellers()
/*     */   {
/* 112 */     List<Customerinfo> Cs = new ArrayList();
/* 113 */     String sql = "select * from Customerinfo where AccountState=2 ORDER BY CustomerName";
/*     */     
/* 115 */     DBHelper dbhelper = new DBHelper();
/*     */     try
/*     */     {
/* 118 */       ResultSet rs = dbhelper.executeQuery(sql, null);
/* 119 */       while (rs.next())
/*     */       {
/* 121 */         Customerinfo C = new Customerinfo();
/* 122 */         C.setCustomerName(rs.getString("CustomerName"));
/* 123 */         C.setCustomerPwd(rs.getString("CustomerPwd"));
/* 124 */         C.setRealName(rs.getString("RealName"));
/* 125 */         C.setSex(rs.getString("Sex"));
/* 126 */         C.setEmail(rs.getString("Email"));
/* 127 */         C.setPhoneNumber(rs.getString("PhoneNumber"));
/* 128 */         C.setIdentityId(rs.getString("IdentityId"));
/* 129 */         C.setAddress(rs.getString("Address"));
/*     */         
/* 131 */         C.setAccountState(Short.valueOf(rs.getShort("AccountState")));
/* 132 */         if (rs.getShort("AccountState") == 1) {
/* 133 */           C.setState("Buyer");
/* 134 */         } else if (rs.getShort("AccountState") == 2) {
/* 135 */           C.setState("Seller");
/*     */         }
/* 137 */         C.setRegTime(rs.getDate("RegTime"));
/* 138 */         C.setAccountBalence(Double.valueOf(rs.getDouble("AccountBalence")));
/*     */         
/* 140 */         C.setStatus(Integer.valueOf(rs.getInt("Status")));
/* 141 */         if (rs.getInt("Status") == 0) {
/* 142 */           C.setStatus1("Normal");
/* 143 */         } else if (rs.getInt("Status") == 1) {
/* 144 */           C.setStatus1("Reported");
/* 145 */         } else if (rs.getInt("Status") == 2)
/* 146 */           C.setStatus1("Covered");
/* 147 */         Cs.add(C);
/*     */       }
/* 149 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 152 */       e.printStackTrace();
/*     */     }
/* 154 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Customerinfo> getSomeCustomers(String CustomerName)
/*     */   {
/* 162 */     List<Customerinfo> Cs = new ArrayList();
/* 163 */     String sql = "select * from Customerinfo where CustomerName=? ORDER BY CustomerName";
/*     */     
/* 165 */     DBHelper dbhelper = new DBHelper();
/*     */     
/* 167 */     Object[] values = new Object[1];
/* 168 */     values[0] = CustomerName;
/*     */     try
/*     */     {
/* 171 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/* 172 */       while (rs.next())
/*     */       {
/* 174 */         Customerinfo C = new Customerinfo();
/* 175 */         C.setCustomerName(rs.getString("CustomerName"));
/* 176 */         C.setCustomerPwd(rs.getString("CustomerPwd"));
/* 177 */         C.setRealName(rs.getString("RealName"));
/* 178 */         C.setSex(rs.getString("Sex"));
/* 179 */         C.setEmail(rs.getString("Email"));
/* 180 */         C.setPhoneNumber(rs.getString("PhoneNumber"));
/* 181 */         C.setIdentityId(rs.getString("IdentityId"));
/* 182 */         C.setAddress(rs.getString("Address"));
/*     */         
/* 184 */         C.setAccountState(Short.valueOf(rs.getShort("AccountState")));
/* 185 */         if (rs.getShort("AccountState") == 1) {
/* 186 */           C.setState("Buyer");
/* 187 */         } else if (rs.getShort("AccountState") == 2) {
/* 188 */           C.setState("Seller");
/*     */         }
/* 190 */         C.setRegTime(rs.getDate("RegTime"));
/* 191 */         C.setAccountBalence(Double.valueOf(rs.getDouble("AccountBalence")));
/*     */         
/* 193 */         C.setStatus(Integer.valueOf(rs.getInt("Status")));
/* 194 */         if (rs.getInt("Status") == 0) {
/* 195 */           C.setStatus1("Normal");
/* 196 */         } else if (rs.getInt("Status") == 1) {
/* 197 */           C.setStatus1("Reported");
/* 198 */         } else if (rs.getInt("Status") == 2) {
/* 199 */           C.setStatus1("Covered");
/*     */         }
/* 201 */         Cs.add(C);
/*     */       }
/* 203 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 206 */       e.printStackTrace();
/*     */     }
/* 208 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Customerinfo> getAnyCustomers(String CustomerName)
/*     */   {
/* 215 */     List<Customerinfo> Cs = new ArrayList();
/* 216 */     String sql = "select * from Customerinfo where CustomerName=?";
/*     */     
/* 218 */     DBHelper dbhelper = new DBHelper();
/*     */     
/* 220 */     Object[] values = new Object[1];
/* 221 */     values[0] = CustomerName;
/*     */     try
/*     */     {
/* 224 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/* 225 */       while (rs.next())
/*     */       {
/* 227 */         Customerinfo C = new Customerinfo();
/* 228 */         C.setCustomerName(rs.getString("CustomerName"));
/* 229 */         C.setCustomerPwd(rs.getString("CustomerPwd"));
/* 230 */         C.setRealName(rs.getString("RealName"));
/* 231 */         C.setSex(rs.getString("Sex"));
/* 232 */         C.setEmail(rs.getString("Email"));
/* 233 */         C.setPhoneNumber(rs.getString("PhoneNumber"));
/* 234 */         C.setIdentityId(rs.getString("IdentityId"));
/* 235 */         C.setAddress(rs.getString("Address"));
/*     */         
/* 237 */         C.setAccountState(Short.valueOf(rs.getShort("AccountState")));
/* 238 */         if (rs.getShort("AccountState") == 1) {
/* 239 */           C.setState("Buyer");
/* 240 */         } else if (rs.getShort("AccountState") == 2) {
/* 241 */           C.setState("Seller");
/*     */         }
/* 243 */         C.setRegTime(rs.getDate("RegTime"));
/* 244 */         C.setAccountBalence(Double.valueOf(rs.getDouble("AccountBalence")));
/*     */         
/* 246 */         C.setStatus(Integer.valueOf(rs.getInt("Status")));
/* 247 */         if (rs.getInt("Status") == 0) {
/* 248 */           C.setStatus1("Normal");
/* 249 */         } else if (rs.getInt("Status") == 1) {
/* 250 */           C.setStatus1("Reported");
/* 251 */         } else if (rs.getInt("Status") == 2)
/* 252 */           C.setStatus1("Covered");
/* 253 */         Cs.add(C);
/*     */       }
/* 255 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 258 */       e.printStackTrace();
/*     */     }
/* 260 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Customerinfo> getCustomers(int Status)
/*     */   {
/* 268 */     List<Customerinfo> Cs = new ArrayList();
/* 269 */     String sql = "select * from Customerinfo where Status=? ORDER BY CustomerName";
/*     */     
/* 271 */     DBHelper dbhelper = new DBHelper();
/*     */     
/* 273 */     Object[] values = new Object[1];
/* 274 */     values[0] = Integer.valueOf(Status);
/*     */     try
/*     */     {
/* 277 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/* 278 */       while (rs.next())
/*     */       {
/* 280 */         Customerinfo C = new Customerinfo();
/* 281 */         C.setCustomerName(rs.getString("CustomerName"));
/* 282 */         C.setCustomerPwd(rs.getString("CustomerPwd"));
/* 283 */         C.setRealName(rs.getString("RealName"));
/* 284 */         C.setSex(rs.getString("Sex"));
/* 285 */         C.setEmail(rs.getString("Email"));
/* 286 */         C.setPhoneNumber(rs.getString("PhoneNumber"));
/* 287 */         C.setIdentityId(rs.getString("IdentityId"));
/* 288 */         C.setAddress(rs.getString("Address"));
/*     */         
/* 290 */         C.setAccountState(Short.valueOf(rs.getShort("AccountState")));
/* 291 */         if (rs.getShort("AccountState") == 1) {
/* 292 */           C.setState("Buyer");
/* 293 */         } else if (rs.getShort("AccountState") == 2) {
/* 294 */           C.setState("Seller");
/*     */         }
/* 296 */         C.setRegTime(rs.getDate("RegTime"));
/* 297 */         C.setAccountBalence(Double.valueOf(rs.getDouble("AccountBalence")));
/*     */         
/* 299 */         C.setStatus(Integer.valueOf(rs.getInt("Status")));
/* 300 */         if (rs.getInt("Status") == 0) {
/* 301 */           C.setStatus1("Normal");
/* 302 */         } else if (rs.getInt("Status") == 1) {
/* 303 */           C.setStatus1("Reported");
/* 304 */         } else if (rs.getInt("Status") == 2)
/* 305 */           C.setStatus1("Covered");
/* 306 */         Cs.add(C);
/*     */       }
/* 308 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 311 */       e.printStackTrace();
/*     */     }
/* 313 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Customerinfo> getBuyers(int Status)
/*     */   {
/* 320 */     List<Customerinfo> Cs = new ArrayList();
/* 321 */     String sql = "select * from Customerinfo where Status=? and AccountState=1 ORDER BY CustomerName";
/*     */     
/* 323 */     DBHelper dbhelper = new DBHelper();
/*     */     
/* 325 */     Object[] values = new Object[1];
/* 326 */     values[0] = Integer.valueOf(Status);
/*     */     try
/*     */     {
/* 329 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/* 330 */       while (rs.next())
/*     */       {
/* 332 */         Customerinfo C = new Customerinfo();
/* 333 */         C.setCustomerName(rs.getString("CustomerName"));
/* 334 */         C.setCustomerPwd(rs.getString("CustomerPwd"));
/* 335 */         C.setRealName(rs.getString("RealName"));
/* 336 */         C.setSex(rs.getString("Sex"));
/* 337 */         C.setEmail(rs.getString("Email"));
/* 338 */         C.setPhoneNumber(rs.getString("PhoneNumber"));
/* 339 */         C.setIdentityId(rs.getString("IdentityId"));
/* 340 */         C.setAddress(rs.getString("Address"));
/*     */         
/* 342 */         C.setAccountState(Short.valueOf(rs.getShort("AccountState")));
/* 343 */         if (rs.getShort("AccountState") == 1) {
/* 344 */           C.setState("Buyer");
/* 345 */         } else if (rs.getShort("AccountState") == 2) {
/* 346 */           C.setState("Seller");
/*     */         }
/* 348 */         C.setRegTime(rs.getDate("RegTime"));
/* 349 */         C.setAccountBalence(Double.valueOf(rs.getDouble("AccountBalence")));
/*     */         
/* 351 */         C.setStatus(Integer.valueOf(rs.getInt("Status")));
/* 352 */         if (rs.getInt("Status") == 0) {
/* 353 */           C.setStatus1("Normal");
/* 354 */         } else if (rs.getInt("Status") == 1) {
/* 355 */           C.setStatus1("Reported");
/* 356 */         } else if (rs.getInt("Status") == 2)
/* 357 */           C.setStatus1("Covered");
/* 358 */         Cs.add(C);
/*     */       }
/* 360 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 363 */       e.printStackTrace();
/*     */     }
/* 365 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Customerinfo> getSellers(int Status)
/*     */   {
/* 372 */     List<Customerinfo> Cs = new ArrayList();
/* 373 */     String sql = "select * from Customerinfo where Status=? and AccountState=2 ORDER BY CustomerName";
/*     */     
/* 375 */     DBHelper dbhelper = new DBHelper();
/*     */     
/* 377 */     Object[] values = new Object[1];
/* 378 */     values[0] = Integer.valueOf(Status);
/*     */     try
/*     */     {
/* 381 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/* 382 */       while (rs.next())
/*     */       {
/* 384 */         Customerinfo C = new Customerinfo();
/* 385 */         C.setCustomerName(rs.getString("CustomerName"));
/* 386 */         C.setCustomerPwd(rs.getString("CustomerPwd"));
/* 387 */         C.setRealName(rs.getString("RealName"));
/* 388 */         C.setSex(rs.getString("Sex"));
/* 389 */         C.setEmail(rs.getString("Email"));
/* 390 */         C.setPhoneNumber(rs.getString("PhoneNumber"));
/* 391 */         C.setIdentityId(rs.getString("IdentityId"));
/* 392 */         C.setAddress(rs.getString("Address"));
/*     */         
/* 394 */         C.setAccountState(Short.valueOf(rs.getShort("AccountState")));
/* 395 */         if (rs.getShort("AccountState") == 1) {
/* 396 */           C.setState("Buyer");
/* 397 */         } else if (rs.getShort("AccountState") == 2) {
/* 398 */           C.setState("Seller");
/*     */         }
/* 400 */         C.setRegTime(rs.getDate("RegTime"));
/* 401 */         C.setAccountBalence(Double.valueOf(rs.getDouble("AccountBalence")));
/*     */         
/* 403 */         C.setStatus(Integer.valueOf(rs.getInt("Status")));
/* 404 */         if (rs.getInt("Status") == 0) {
/* 405 */           C.setStatus1("Normal");
/* 406 */         } else if (rs.getInt("Status") == 1) {
/* 407 */           C.setStatus1("Reported");
/* 408 */         } else if (rs.getInt("Status") == 2)
/* 409 */           C.setStatus1("Covered");
/* 410 */         Cs.add(C);
/*     */       }
/* 412 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 415 */       e.printStackTrace();
/*     */     }
/* 417 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */   public int DeleteCustomers(String CustomerName)
/*     */   {
/* 423 */     String sql = "select * from Customerinfo where CustomerName=?";
/* 424 */     int a = 0;
/*     */     
/* 426 */     DBHelper dbhelper = new DBHelper();
/*     */     
/* 428 */     Object[] values = new Object[1];
/* 429 */     values[0] = CustomerName;
/*     */     try
/*     */     {
/* 432 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/* 433 */       if (rs.next())
/*     */       {
/* 435 */         sql = "update Customerinfo set Status=2 where CustomerName=?";
/* 436 */         dbhelper.executeUpdate(sql, values);
/*     */       }
/*     */       else {
/* 439 */         a = -1; }
/* 440 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 443 */       e.printStackTrace();
/*     */     }
/* 445 */     return a;
/*     */   }
/*     */   
/*     */ 
/*     */   public int RecoverCustomers(String CustomerName)
/*     */   {
/* 451 */     String sql = "select * from Customerinfo where CustomerName=?";
/* 452 */     int a = 0;
/*     */     
/* 454 */     DBHelper dbhelper = new DBHelper();
/*     */     
/* 456 */     Object[] values = new Object[1];
/* 457 */     values[0] = CustomerName;
/*     */     try
/*     */     {
/* 460 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/* 461 */       if (rs.next())
/*     */       {
/* 463 */         sql = "update Customerinfo set Status=1 where CustomerName=?";
/* 464 */         dbhelper.executeUpdate(sql, values);
/*     */       }
/*     */       else {
/* 467 */         a = -1; }
/* 468 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 471 */       e.printStackTrace();
/*     */     }
/* 473 */     return a;
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\dao\CustomerDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */