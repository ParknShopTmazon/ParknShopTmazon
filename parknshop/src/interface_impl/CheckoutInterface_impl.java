/*     */ package interface_impl;
/*     */ 
/*     */ import interface_servlet.CheckoutInterface;
/*     */ import interface_servlet.ShoppingCartInterface;
/*     */ import interface_servlet.UserAccountInterface;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.List;
/*     */ import jdbc.ConnectionManager;
/*     */ import vo.ShoppingCart;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CheckoutInterface_impl
/*     */   implements CheckoutInterface
/*     */ {
/*     */   public int checkout(String customername, List<ShoppingCart> list, double useraccount, String receivename, String receiveaddress, String receivecity, String receivecountry, String receiveemail, String receivephone)
/*     */   {
/*  26 */     UserAccountInterface account = new UserAccountInterface_impl();
/*  27 */     double balence = account.useraccount(customername);
/*     */     
/*     */ 
/*     */ 
/*  31 */     if (balence < useraccount) {
/*  32 */       return 0;
/*     */     }
/*  34 */     Connection con = null;
/*  35 */     PreparedStatement ps = null;
/*  36 */     Statement statement = null;
/*     */     try {
/*  38 */       con = ConnectionManager.getConnection();
/*  39 */       con.setAutoCommit(false);
/*     */       
/*  41 */       String sqlConsignee = "INSERT INTO consigneeinfo(CustomerName,ConsigneeName,ConsigneeAddress,ConsigneePhoneNumber) VALUES(?,?,?,?)";
/*  42 */       ps = con.prepareStatement(sqlConsignee, 
/*  43 */         1);
/*  44 */       ps.setString(1, customername);
/*  45 */       ps.setString(2, receivename);
/*  46 */       ps.setString(3, receiveaddress);
/*  47 */       ps.setString(4, receivephone);
/*     */       
/*  49 */       ps.execute();
/*     */       
/*  51 */       ResultSet rs = ps.getGeneratedKeys();
/*  52 */       rs.next();
/*  53 */       int mainkey = rs.getInt(1);
/*     */       
/*     */ 
/*  56 */       ShoppingCart sc = null;
/*  57 */       String sqlOrder = "INSERT INTO userorder(ConsigneeInfoID,ShopProductID,ProductBuyNum,CurrentState,TrackingNum,OrderTime) VALUES(?,?,?,?,?,?)";
/*  58 */       int i = 0; for (int len = list.size(); i < len; i++) {
/*  59 */         sc = (ShoppingCart)list.get(i);
/*     */         
/*  61 */         statement = con.createStatement();
/*  62 */         String SqlShopProductId = "SELECT ShopProductID FROM productinfo,shopproduct WHERE productinfo.ProductID=shopproduct.ProductID AND productinfo.ProductID=" + 
/*  63 */           sc.getProduct_ID();
/*  64 */         rs = statement.executeQuery(SqlShopProductId);
/*  65 */         rs.next();
/*  66 */         int shopProductId = rs.getInt("ShopProductID");
/*     */         
/*  68 */         updateStock(shopProductId, sc.getProduct_stock() - sc.getProduct_quantity());
/*     */         
/*     */ 
/*  71 */         ps = con.prepareStatement(sqlOrder);
/*  72 */         ps.setInt(1, mainkey);
/*  73 */         ps.setInt(2, shopProductId);
/*  74 */         ps.setInt(3, sc.getProduct_quantity());
/*  75 */         ps.setInt(4, 1);
/*  76 */         ps.setInt(5, 123);
/*  77 */         ps.setDate(6, new Date(System.currentTimeMillis()));
/*  78 */         ps.execute();
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  83 */       ShoppingCartInterface scI = new ShoppingCartInterface_impl();
/*     */       
/*  85 */       i = 0; for (int len = list.size(); i < len; i++) {
/*  86 */         sc = (ShoppingCart)list.get(i);
/*  87 */         scI.cartremove(customername, 
/*  88 */           Integer.parseInt(sc.getProduct_ID()));
/*     */       }
/*     */       
/*  91 */       double Account = balence - useraccount;
/*  92 */       String sqlAccount = "UPDATE customerinfo SET AccountBalence=" + 
/*  93 */         Account + " where CustomerName='" + customername + "'";
/*  94 */       statement = con.createStatement();
/*  95 */       statement.executeUpdate(sqlAccount);
/*     */       
/*  97 */       con.commit();
/*     */       
/*  99 */       ConnectionManager.close(con);
/* 100 */       ConnectionManager.close(rs);
/* 101 */       ConnectionManager.close(ps);
/* 102 */       return 1;
/*     */     } catch (Exception e) {
/*     */       try {
/* 105 */         con.rollback();
/*     */       } catch (Exception f) {
/* 107 */         f.printStackTrace();
/* 108 */         return 0;
/*     */       }
/* 110 */       e.printStackTrace(); }
/* 111 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   private void updateStock(int product_id, int buynum)
/*     */   {
/* 117 */     Connection con = null;
/* 118 */     PreparedStatement ps = null;
/* 119 */     String sql = "update shopproduct set ProductStock=? where productID=? ";
/*     */     
/*     */     try
/*     */     {
/* 123 */       con = ConnectionManager.getConnection();
/* 124 */       ps = con.prepareStatement(sql);
/* 125 */       ps.setInt(1, product_id);
/* 126 */       ps.setInt(2, buynum);
/* 127 */       ps.executeUpdate();
/*     */       
/*     */ 
/* 130 */       ConnectionManager.close(con);
/* 131 */       ConnectionManager.close(ps);
/*     */     }
/*     */     catch (Exception e) {
/* 134 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\interface_impl\CheckoutInterface_impl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */