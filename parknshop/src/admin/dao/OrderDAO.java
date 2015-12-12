/*     */ package admin.dao;
/*     */ 
/*     */ import admin.entity.Userorder;
/*     */ import admin.util.DBHelper;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OrderDAO
/*     */ {
/*     */   public List<Userorder> getAllOrders()
/*     */   {
/*  15 */     List<Userorder> Cs = new ArrayList();
/*  16 */     String sql = "select * from userorder where CurrentState in(3,4)";
/*     */     
/*  18 */     DBHelper dbhelper = new DBHelper();
/*     */     try
/*     */     {
/*  21 */       ResultSet rs = dbhelper.executeQuery(sql, null);
/*  22 */       while (rs.next())
/*     */       {
/*  24 */         Userorder C = new Userorder();
/*  25 */         C.setOrderId(Integer.valueOf(rs.getInt("OrderID")));
/*  26 */         C.setConsigneeId(rs.getInt("ConsigneeInfoID"));
/*  27 */         C.setShopProductId(rs.getInt("ShopProductID"));
/*  28 */         C.setProductBuyNum(Integer.valueOf(rs.getInt("ProductBuyNum")));
/*  29 */         C.setOrderTime(rs.getDate("OrderTime"));
/*  30 */         C.setFinishTime(rs.getDate("FinishTime"));
/*     */         
/*  32 */         C.setCurrentState(Integer.valueOf(rs.getInt("CurrentState")));
/*  33 */         if (rs.getInt("CurrentState") == 1) {
/*  34 */           C.setState("Non-Payment");
/*  35 */         } else if (rs.getInt("CurrentState") == 2) {
/*  36 */           C.setState("Delivered");
/*  37 */         } else if (rs.getInt("CurrentState") == 3) {
/*  38 */           C.setState("Finished");
/*     */         }
/*  40 */         C.setAnythingElse(rs.getString("AnythingElse"));
/*  41 */         C.setTrackingNum(rs.getString("TrackingNum"));
/*  42 */         Cs.add(C);
/*     */       }
/*  44 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/*  47 */       e.printStackTrace();
/*     */     }
/*  49 */     return Cs;
/*     */   }
/*     */   
			public int getPriceById(int id)
			{
				String sql = "select ProducePrice from shopproduct where ShopProductID=?";
				DBHelper dbhelper = new DBHelper();
				Object[] values = new Object[1];
				values[0] = Integer.valueOf(id);
				int result=0;
				try{
					ResultSet rs = dbhelper.executeQuery(sql, values);
					if(rs.next()){
						 result=rs.getInt("ProducePrice");
							}
					 System.out.print(result);
					 dbhelper.closeDB();	
				 }
				  catch (Exception e) {
					 e.printStackTrace();
				}
				return result;	
			}
/*     */ 
/*     */   public List<Userorder> getSomeOrders(String about)
/*     */   {
/*  55 */     List<Userorder> Cs = new ArrayList();
/*  56 */     String sql = "select * from Userorder where OrderID=?";
/*     */     
/*  58 */     Object[] values = new Object[1];
/*     */     
/*  60 */     DBHelper dbhelper = new DBHelper();
/*     */     try
/*     */     {
/*  63 */       if (about.matches("[0-9]*"))
/*     */       {
/*  65 */         if (about.length() <= 10)
/*     */         {
/*  67 */           values[0] = Integer.valueOf(about);
/*  68 */           ResultSet rs = dbhelper.executeQuery(sql, values);
/*  69 */           while (rs.next())
/*     */           {
/*  71 */             Userorder C = new Userorder();
/*  72 */             C.setOrderId(Integer.valueOf(rs.getInt("OrderID")));
/*  73 */             C.setConsigneeId(rs.getInt("ConsigneeInfoID"));
/*  74 */             C.setShopProductId(rs.getInt("ShopProductID"));
/*  75 */             C.setProductBuyNum(Integer.valueOf(rs.getInt("ProductBuyNum")));
/*  76 */             C.setOrderTime(rs.getDate("OrderTime"));
/*  77 */             C.setFinishTime(rs.getDate("FinishTime"));
/*     */             
/*  79 */             C.setCurrentState(Integer.valueOf(rs.getInt("CurrentState")));
/*  80 */             if (rs.getInt("CurrentState") == 1) {
/*  81 */               C.setState("Non-Payment");
/*  82 */             } else if (rs.getInt("CurrentState") == 2) {
/*  83 */               C.setState("Delivered");
/*  84 */             } else if (rs.getInt("CurrentState") == 3) {
/*  85 */               C.setState("Finished");
/*     */             }
/*  87 */             C.setAnythingElse(rs.getString("AnythingElse"));
/*  88 */             C.setTrackingNum(rs.getString("TrackingNum"));
/*  89 */             Cs.add(C);
/*     */           }
/*     */         }
/*     */       }
/*  93 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/*  96 */       e.printStackTrace();
/*     */     }
/*  98 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Userorder> getAnyOrders(int OrderID)
/*     */   {
/* 106 */     List<Userorder> Cs = new ArrayList();
/* 107 */     String sql = "select * from Userorder where OrderID=?";
/*     */     
/* 109 */     Object[] values = new Object[1];
/* 110 */     values[0] = Integer.valueOf(OrderID);
/*     */     
/* 112 */     DBHelper dbhelper = new DBHelper();
/*     */     try
/*     */     {
/* 115 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/* 116 */       while (rs.next())
/*     */       {
/* 118 */         Userorder C = new Userorder();
/* 119 */         C.setOrderId(Integer.valueOf(rs.getInt("OrderID")));
/* 120 */         C.setConsigneeId(rs.getInt("ConsigneeInfoID"));
/* 121 */         C.setShopProductId(rs.getInt("ShopProductID"));
/* 122 */         C.setProductBuyNum(Integer.valueOf(rs.getInt("ProductBuyNum")));
/* 123 */         C.setOrderTime(rs.getDate("OrderTime"));
/* 124 */         C.setFinishTime(rs.getDate("FinishTime"));
/*     */         
/* 126 */         C.setCurrentState(Integer.valueOf(rs.getInt("CurrentState")));
/* 127 */         if (rs.getInt("CurrentState") == 1) {
/* 128 */           C.setState("Non-Payment");
/* 129 */         } else if (rs.getInt("CurrentState") == 2) {
/* 130 */           C.setState("Delivered");
/* 131 */         } else if (rs.getInt("CurrentState") == 3) {
/* 132 */           C.setState("Finished");
/*     */         }
/* 134 */         C.setAnythingElse(rs.getString("AnythingElse"));
/* 135 */         C.setTrackingNum(rs.getString("TrackingNum"));
/* 136 */         Cs.add(C);
/*     */       }
/* 138 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 141 */       e.printStackTrace();
/*     */     }
/* 143 */     return Cs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Userorder> getAllStatedOrders(int CurrentState)
/*     */   {
/* 150 */     List<Userorder> Cs = new ArrayList();
/* 151 */     String sql = "select * from Userorder where CurrentState=?";
/*     */     
/* 153 */     DBHelper dbhelper = new DBHelper();
/*     */     
/* 155 */     Object[] values = new Object[1];
/* 156 */     values[0] = Integer.valueOf(CurrentState);
/*     */     try
/*     */     {
/* 159 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/* 160 */       while (rs.next())
/*     */       {
/* 162 */         Userorder C = new Userorder();
/* 163 */         C.setOrderId(Integer.valueOf(rs.getInt("OrderID")));
/* 164 */         C.setConsigneeId(rs.getInt("ConsigneeInfoID"));
/* 165 */         C.setShopProductId(rs.getInt("ShopProductID"));
/* 166 */         C.setProductBuyNum(Integer.valueOf(rs.getInt("ProductBuyNum")));
/* 167 */         C.setOrderTime(rs.getDate("OrderTime"));
/* 168 */         C.setFinishTime(rs.getDate("FinishTime"));
/*     */         
/* 170 */         C.setCurrentState(Integer.valueOf(rs.getInt("CurrentState")));
/* 171 */         if (rs.getInt("CurrentState") == 1) {
/* 172 */           C.setState("Non-Payment");
/* 173 */         } else if (rs.getInt("CurrentState") == 2) {
/* 174 */           C.setState("Delivered");
/* 175 */         } else if (rs.getInt("CurrentState") == 3) {
/* 176 */           C.setState("Finished");
/*     */         }
/* 178 */         C.setAnythingElse(rs.getString("AnythingElse"));
/* 179 */         C.setTrackingNum(rs.getString("TrackingNum"));
/* 180 */         Cs.add(C);
/*     */       }
/* 182 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 185 */       e.printStackTrace();
/*     */     }
/* 187 */     return Cs;
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\dao\OrderDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */