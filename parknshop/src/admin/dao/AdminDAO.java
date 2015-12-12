/*     */ package admin.dao;
/*     */ 
/*     */ import admin.util.DBHelper;
/*     */ import java.sql.ResultSet;
/*     */ 
/*     */ 
/*     */ public class AdminDAO
/*     */ {
/*     */   public int adminlogin(String userName, String pwd)
/*     */   {
/*  11 */     String sql = "select * from admininfo where AdminName=? and AdminPwd=?";
/*  12 */     int b = -1;
/*     */     
/*  14 */     Object[] values = new Object[2];
/*  15 */     values[0] = userName;
/*  16 */     values[1] = pwd;
/*     */     
/*  18 */     DBHelper dbhelper = new DBHelper();
/*     */     try
/*     */     {
/*  21 */       if ((userName.length() <= 45) && (pwd.length() <= 20))
/*     */       {
/*  23 */         ResultSet rs = dbhelper.executeQuery(sql, values);
/*     */         
/*  25 */         if (rs.next()) {
/*  26 */           b = 0;
/*     */         } else {
/*  28 */           b = -1;
/*     */         }
/*     */       } else {
/*  31 */         b = -1; }
/*  32 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/*  35 */       e.printStackTrace();
/*     */     }
/*  37 */     return b;//登陆时，此函数返回b=0代表用户验证通过
/*     */   }
/*     */   
/*     */   public int ChangePwd(String Name, String OldPwd, String NewPwd1, String NewPwd2)
/*     */   {
/*  42 */     String sql = "select AdminPwd from Admininfo where AdminName=?";
/*  43 */     int a = 0;
/*     */     
/*  45 */     DBHelper dbhelper = new DBHelper();
/*  46 */     Object[] values = new Object[1];
/*  47 */     values[0] = Name;
/*     */     try
/*     */     {
/*  50 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/*  51 */       if (rs.next())
/*     */       {
/*  53 */         if (OldPwd.equals(rs.getString("AdminPwd")))
/*     */         {
/*  55 */           if (NewPwd1.equals(NewPwd2))
/*     */           {
/*  57 */             if (NewPwd1.length() <= 20)
/*     */             {
/*  59 */               sql = "Update Admininfo set AdminPwd=? where AdminName=?";
/*  60 */               Object[] valuess = new Object[2];
/*  61 */               valuess[0] = NewPwd1;
/*  62 */               valuess[1] = Name;
/*  63 */               dbhelper.executeUpdate(sql, valuess);
/*     */             }
/*     */             else {
/*  66 */               a = 3;
/*     */             }
/*     */           } else {
/*  69 */             a = 2;
/*     */           }
/*     */         } else
/*  72 */           a = 1;
/*     */       }
/*  74 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/*  77 */       e.printStackTrace();
/*     */     }
/*  79 */     return a;
/*     */   }
/*     */   
/*     */   public void ChangeRate(double rate)
/*     */   {
/*  84 */     String sql = "update Admininfo set rate=?";
/*     */     
/*  86 */     Object[] values = new Object[1];
/*  87 */     values[0] = Double.valueOf(rate);
/*     */     
/*  89 */     DBHelper dbhelper = new DBHelper();
/*     */     try
/*     */     {
/*  92 */       dbhelper.executeUpdate(sql, values);
/*     */       
/*  94 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/*  97 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public double getAccount()//获取数据库里的account 居然是100000
/*     */   {
/* 104 */     String sql = "select Account from Admininfo";
/* 105 */     double a = 0.0D;
/*     */     
/* 107 */     DBHelper dbhelper = new DBHelper();
/*     */     try
/*     */     {
/* 110 */       ResultSet rs = dbhelper.executeQuery(sql, null);
/* 111 */       if (rs.next())
/* 112 */         a = rs.getDouble("Account");
/* 113 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 116 */       e.printStackTrace();
/*     */     }
/* 118 */     return a;
/*     */   }
/*     */   
/*     */ 
/*     */   public double getRate()
/*     */   {
/* 124 */     String sql = "select Rate from Admininfo";
/* 125 */     double a = 0.0D;
/*     */     
/* 127 */     DBHelper dbhelper = new DBHelper();
/*     */     try
/*     */     {
/* 130 */       ResultSet rs = dbhelper.executeQuery(sql, null);
/* 131 */       if (rs.next())
/* 132 */         a = rs.getDouble("Rate");
/* 133 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 136 */       e.printStackTrace();
/*     */     }
/* 138 */     return a;
/*     */   }
/*     */   
/*     */ 
/*     */   public void RefreashAccount(double price, double rate)
/*     */   {
/* 144 */     String sql = "select Account from Admininfo";
/* 145 */     double CurrentPrice = 0.0D;
/*     */     
/* 147 */     Object[] values = new Object[1];
/* 148 */     values[0] = Double.valueOf(CurrentPrice);
/*     */     
/* 150 */     DBHelper dbhelper = new DBHelper();
/*     */     try
/*     */     {
/* 153 */       ResultSet rs = dbhelper.executeQuery(sql, null);
/* 154 */       if (rs.next())
/*     */       {
/* 156 */         CurrentPrice = rs.getDouble("Account") + price * rate;
/* 157 */         sql = "update Admininfo set Account=?";
/*     */         
/* 159 */         values[0] = Double.valueOf(CurrentPrice);
/* 160 */         dbhelper.executeUpdate(sql, values);
/*     */       }
/*     */       
/* 163 */       dbhelper.closeDB();
/*     */     }
/*     */     catch (Exception e) {
/* 166 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\dao\AdminDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */