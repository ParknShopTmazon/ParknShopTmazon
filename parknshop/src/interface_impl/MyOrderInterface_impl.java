/*     */ package interface_impl;
/*     */ 
/*     */ import interface_servlet.MyOrderInterface;
/*     */ import java.sql.Connection;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import jdbc.ConnectionManager;
/*     */ import vo.ProductDetail;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MyOrderInterface_impl
/*     */   implements MyOrderInterface
/*     */ {
/*     */   public String returndeliveryaddress(int order_id)
/*     */   {
/*  17 */     String str = "select *from consigneeinfo where ConsigneeInfoID in(select ConsigneeInfoID from userorder where OrderID=" + 
/*  18 */       order_id + ")";
/*  19 */     String address = "";
/*     */     try {
/*  21 */       Connection con = ConnectionManager.getConnection();
/*  22 */       Statement sta = con.createStatement();
/*  23 */       ResultSet rs = sta.executeQuery(str);
/*  24 */       while (rs.next()) {
/*  25 */         address = rs.getString("ConsigneeAddress");
/*     */       }
/*  27 */       ConnectionManager.close(sta);
/*  28 */       ConnectionManager.close(con);
/*     */     } catch (Exception e) {
/*  30 */       e.printStackTrace();
/*     */     }
/*  32 */     return address;
/*     */   }
/*     */   
/*     */   public String returnshopname(int order_id)
/*     */   {
/*  37 */     String str = "select * from shopinfo where ShopInfoID in(select ShopInfoID from shopproduct where ShopProductID in(select ShopProductID from userorder where OrderId=" + 
/*     */     
/*  39 */       order_id + "))";
/*  40 */     String shopname = "";
/*     */     try {
/*  42 */       Connection con = ConnectionManager.getConnection();
/*  43 */       Statement sta = con.createStatement();
/*  44 */       ResultSet rs = sta.executeQuery(str);
/*  45 */       while (rs.next()) {
/*  46 */         shopname = rs.getString("ShopInfoName");
/*     */       }
/*  48 */       ConnectionManager.close(sta);
/*  49 */       ConnectionManager.close(con);
/*     */     } catch (Exception e) {
/*  51 */       e.printStackTrace();
/*     */     }
/*  53 */     return shopname;
/*     */   }
/*     */   
/*     */   public ProductDetail returndetail(int order_id)
/*     */   {
/*  58 */     ProductDetail pro = new ProductDetail();
/*  59 */     String sql = "select *from productinfo where ProductID in(select ProductID from shopproduct where ShopProductID in(select ShopProductID from userorder where OrderId=" + 
/*     */     
/*  61 */       order_id + "))";
/*     */     try {
/*  63 */       Connection con = ConnectionManager.getConnection();
/*  64 */       Statement sta = con.createStatement();
/*  65 */       ResultSet rs = sta.executeQuery(sql);
/*  66 */       while (rs.next()) {
/*  67 */         pro.setProduct_ID(rs.getInt("ProductID"));
/*  68 */         pro.setProduct_description(rs.getString("ProductDescription"));
/*  69 */         pro.setProduct_img_url(rs.getString("ImagePath"));
/*  70 */         pro.setProduct_name(rs.getString("ProductName"));
/*  71 */         pro.setProduct_price(rs.getDouble("Price"));
/*  72 */         pro.setProduct_type_ID(rs.getInt("ProductTypeID"));
/*     */       }
/*  74 */       ConnectionManager.close(sta);
/*  75 */       ConnectionManager.close(con);
/*     */     } catch (Exception e) {
/*  77 */       e.printStackTrace();
/*     */     }
/*  79 */     return pro;
/*     */   }
/*     */   
/*     */   public double returntotalprice(int order_id)
/*     */   {
/*  84 */     String sql = "select *from userorder where OrderID=" + order_id;
/*  85 */     int num = 0;
/*  86 */     int shopproductid = 0;
/*  87 */     double totalprice = 0.0D;
/*     */     try {
/*  89 */       Connection con = ConnectionManager.getConnection();
/*  90 */       Statement sta = con.createStatement();
/*  91 */       ResultSet rs = sta.executeQuery(sql);
/*  92 */       while (rs.next()) {
/*  93 */         num = rs.getInt("ProductBuyNum");
/*  94 */         shopproductid = rs.getInt("ShopProductID");
/*     */       }
/*  96 */       sql = 
/*  97 */         "select *from productinfo where ProductID in(select ProductID from shopproduct where ShopProductID=" + shopproductid + ")";
/*  98 */       rs = sta.executeQuery(sql);
/*  99 */       while (rs.next()) {
/* 100 */         totalprice = rs.getDouble("Price") * num;
/*     */       }
/* 102 */       ConnectionManager.close(sta);
/* 103 */       ConnectionManager.close(con);
/*     */     } catch (Exception e) {
/* 105 */       e.printStackTrace();
/*     */     }
/* 107 */     return totalprice;
/*     */   }
/*     */   
/*     */   public void confirmgoods(int order_id)
/*     */   {
/* 112 */     String sql = "update userorder SET  userorder.CurrentState='4', FinishTime =CURDATE() WHERE OrderID=" + 
/* 113 */       order_id;
/*     */     try
/*     */     {
/* 116 */       Connection con = ConnectionManager.getConnection();
/* 117 */       Statement st = con.createStatement();
/* 118 */       st.executeUpdate(sql);
/* 119 */       ConnectionManager.close(con);
/* 120 */       ConnectionManager.close(st);
/*     */     } catch (Exception e) {
/* 122 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeOrder(int order_id)
/*     */   {
/* 128 */     String sql = "update userorder set state=0 where OrderID=" + order_id;
/*     */     try
/*     */     {
/* 131 */       Connection con = ConnectionManager.getConnection();
/* 132 */       Statement st = con.createStatement();
/* 133 */       st.executeUpdate(sql);
/* 134 */       ConnectionManager.close(con);
/* 135 */       ConnectionManager.close(st);
/*     */     } catch (Exception e) {
/* 137 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\interface_impl\MyOrderInterface_impl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */