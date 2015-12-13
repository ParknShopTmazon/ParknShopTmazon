/*     */ package admin.dao;
/*     */ 
/*     */ import admin.entity.Comments;
/*     */ import admin.entity.Shopinfo;
/*     */ import admin.entity.Shopproduct;
/*     */ import admin.util.DBHelper;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CommentsDAO
/*     */ {
/*     */   public List<Comments> getAllComments()
/*     */   {
/*  15 */     List<Comments> Cs = new ArrayList();
/*  16 */     String sql = "select * from Comments";
/*     */     
/*  18 */     DBHelper dbhelper = new DBHelper();
/*     */     try
/*     */     {
/*  21 */       ResultSet rs = dbhelper.executeQuery(sql, null);
/*  22 */       while (rs.next())
/*     */       {
/*  24 */         Comments C = new Comments();
/*  25 */         C.setCommentId(Integer.valueOf(rs.getInt("CommentID")));
/*  26 */         C.setUserorder(Integer.valueOf(rs.getInt("OrderID")));
/*  27 */         C.setComment(rs.getString("Comment"));
/*  28 */         C.setTime(rs.getDate("Time"));
/*  29 */         C.setLevel(Integer.valueOf(rs.getInt("Level")));
/*  30 */         C.setStatus(Integer.valueOf(rs.getInt("Status")));
/*  31 */         if (rs.getInt("Status") == 0) {
/*  32 */           C.setStatus1("Normal");
/*  33 */         } else if (rs.getInt("Status") == 1)
/*  34 */           C.setStatus1("Reported");
/*  35 */         Cs.add(C);
/*     */       }
/*  37 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/*  40 */       e.printStackTrace();
/*     */     }
/*  42 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Comments> getAnyComments(int CommentID)
/*     */   {
/*  49 */     List<Comments> Cs = new ArrayList();
/*  50 */     String sql = "select * from Comments where CommentID=?";
/*     */     
/*  52 */     DBHelper dbhelper = new DBHelper();
/*     */     
/*  54 */     Object[] values = new Object[1];
/*  55 */     values[0] = Integer.valueOf(CommentID);
/*     */     try
/*     */     {
/*  58 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/*  59 */       while (rs.next())
/*     */       {
/*  61 */         Comments C = new Comments();
/*  62 */         C.setCommentId(Integer.valueOf(rs.getInt("CommentID")));
/*  63 */         C.setUserorder(Integer.valueOf(rs.getInt("OrderID")));
/*     */         
/*  65 */         OrderDAO order = new OrderDAO();
/*  66 */         int consigneeId = ((admin.entity.Userorder)order.getAnyOrders(rs.getInt("OrderID")).get(0)).getConsigneeId();
/*  67 */         int shopProductId = ((admin.entity.Userorder)order.getAnyOrders(rs.getInt("OrderID")).get(0)).getShopProductId();
/*     */         
/*  69 */         ConsigneeDAO consignee = new ConsigneeDAO();
/*  70 */         C.setBuyerName(((admin.entity.Consigneeinfo)consignee.getAnyConsignees(consigneeId).get(0)).getCustomerinfo());
/*     */         
/*  72 */         ShopProductDAO shopproduct = new ShopProductDAO();
/*  73 */         Integer productId = ((Shopproduct)shopproduct.getAny(shopProductId).get(0)).getProductId();
/*  74 */         int shopInfoId = ((Shopproduct)shopproduct.getAny(shopProductId).get(0)).getShopInfoId().intValue();
/*     */         
/*  76 */         ProductDAO product = new ProductDAO();
/*  77 */         C.setProductName(((admin.entity.Productinfo)product.getAnyProducts(productId.toString()).get(0)).getProductName());
/*  78 */         C.setProductId(((admin.entity.Productinfo)product.getAnyProducts(productId.toString()).get(0)).getProductId());
/*     */         
/*  80 */         ShopDAO shop = new ShopDAO();
/*  81 */         C.setSellerName(((Shopinfo)shop.getAnyShops(shopInfoId).get(0)).getCustomerName());
/*  82 */         C.setShopName(((Shopinfo)shop.getAnyShops(shopInfoId).get(0)).getShopInfoName());
/*  83 */         C.setShopId(((Shopinfo)shop.getAnyShops(shopInfoId).get(0)).getShopInfoId());
/*     */         
/*  85 */         C.setComment(rs.getString("Comment"));
/*  86 */         C.setTime(rs.getDate("Time"));
/*  87 */         C.setLevel(Integer.valueOf(rs.getInt("Level")));
/*  88 */         C.setStatus(Integer.valueOf(rs.getInt("Status")));
/*  89 */         if (rs.getInt("Status") == 0) {
/*  90 */           C.setStatus1("Normal");
/*  91 */         } else if (rs.getInt("Status") == 1)
/*  92 */           C.setStatus1("Reported");
/*  93 */         Cs.add(C);
/*     */       }
/*  95 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/*  98 */       e.printStackTrace();
/*     */     }
/* 100 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Comments> getSomeComments(String about)
/*     */   {
/* 106 */     List<Comments> Cs = new ArrayList();
/* 107 */     String sql = "select * from Comments where CommentID=?";
/*     */     
/* 109 */     DBHelper dbhelper = new DBHelper();
/*     */     
/* 111 */     Object[] values = new Object[1];
/*     */     try
/*     */     {
/* 114 */       if (about.matches("[0-9]*"))
/*     */       {
/* 116 */         if (about.length() <= 10)
/*     */         {
/* 118 */           values[0] = Integer.valueOf(about);
/* 119 */           ResultSet rs = dbhelper.executeQuery(sql, values);
/* 120 */           while (rs.next())
/*     */           {
/* 122 */             Comments C = new Comments();
/* 123 */             C.setCommentId(Integer.valueOf(rs.getInt("CommentID")));
/* 124 */             C.setUserorder(Integer.valueOf(rs.getInt("OrderID")));
/* 125 */             C.setComment(rs.getString("Comment"));
/* 126 */             C.setTime(rs.getDate("Time"));
/* 127 */             C.setLevel(Integer.valueOf(rs.getInt("Level")));
/* 128 */             C.setStatus(Integer.valueOf(rs.getInt("Status")));
/* 129 */             if (rs.getInt("Status") == 0) {
/* 130 */               C.setStatus1("Normal");
/* 131 */             } else if (rs.getInt("Status") == 1)
/* 132 */               C.setStatus1("Reported");
/* 133 */             Cs.add(C);
/*     */           }
/*     */         }
/*     */       }
/* 137 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 140 */       e.printStackTrace();
/*     */     }
/* 142 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Comments> getComments(int Status)
/*     */   {
/* 150 */     List<Comments> Cs = new ArrayList();
/* 151 */     String sql = "select * from Comments where Status=?";
/*     */     
/* 153 */     DBHelper dbhelper = new DBHelper();
/*     */     
/* 155 */     Object[] values = new Object[1];
/* 156 */     values[0] = Integer.valueOf(Status);
/*     */     try
/*     */     {
/* 159 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/* 160 */       while (rs.next())
/*     */       {
/* 162 */         Comments C = new Comments();
/* 163 */         C.setCommentId(Integer.valueOf(rs.getInt("CommentID")));
/* 164 */         C.setUserorder(Integer.valueOf(rs.getInt("OrderID")));
/* 165 */         C.setComment(rs.getString("Comment"));
/* 166 */         C.setTime(rs.getDate("Time"));
/* 167 */         C.setLevel(Integer.valueOf(rs.getInt("Level")));
/* 168 */         C.setStatus(Integer.valueOf(rs.getInt("Status")));
/* 169 */         if (rs.getInt("Status") == 0) {
/* 170 */           C.setStatus1("Normal");
/* 171 */         } else if (rs.getInt("Status") == 1)
/* 172 */           C.setStatus1("Reported");
/* 173 */         Cs.add(C);
/*     */       }
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
/*     */   public int DeleteComments(int CommentID)
/*     */   {
/* 187 */     String sql = "select * from Comments where CommentID=?";
/* 188 */     int a = 0;
/*     */     
/* 190 */     DBHelper dbhelper = new DBHelper();
/*     */     
/* 192 */     Object[] values = new Object[1];
/* 193 */     values[0] = Integer.valueOf(CommentID);
/*     */     try
/*     */     {
/* 196 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/* 197 */       if (rs.next())
/*     */       {
/* 199 */         sql = "delete from Comments where CommentID=?";
/* 200 */         dbhelper.executeUpdate(sql, values);
/*     */       }
/*     */       else {
/* 203 */         a = -1; }
/* 204 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 207 */       e.printStackTrace();
/*     */     }
/* 209 */     return a;
/*     */   }
/*     */   
/*     */   public int RecoverComments(int CommentID)
/*     */   {
/* 214 */     String sql = "select * from Comments where CommentID=?";
/* 215 */     int a = 0;
/*     */     
/* 217 */     DBHelper dbhelper = new DBHelper();
/*     */     
/* 219 */     Object[] values = new Object[1];
/* 220 */     values[0] = Integer.valueOf(CommentID);
/*     */     try
/*     */     {
/* 223 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/* 224 */       if (rs.next())
/*     */       {
/* 226 */         sql = "Update Comments set Status=0 where CommentID=?";
/* 227 */         dbhelper.executeUpdate(sql, values);
/*     */       }
/*     */       else {
/* 230 */         a = -1; }
/* 231 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 234 */       e.printStackTrace();
/*     */     }
/* 236 */     return a;
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\dao\CommentsDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */