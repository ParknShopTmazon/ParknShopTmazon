/*     */ package admin.servlet;
/*     */ 
/*     */ import admin.dao.AdminDAO;
/*     */ import admin.dao.CommentsDAO;
/*     */ import admin.dao.CustomerDAO;
/*     */ import admin.dao.ShopDAO;
/*     */ import admin.entity.Comments;
/*     */ import admin.entity.Customerinfo;
/*     */ import admin.entity.Shopinfo;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.servlet.RequestDispatcher;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class AdminLoginServlet
/*     */   extends HttpServlet
/*     */ {
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  26 */     request.setCharacterEncoding("UTF-8");
/*     */     
/*  28 */     AdminDAO a = new AdminDAO();
/*     */     
/*  30 */     Date d = new Date();//设置session的属性
/*  31 */     request.getSession().setAttribute("Account", Double.valueOf(a.getAccount()));
/*  32 */     request.getSession().setAttribute("Rate", Double.valueOf(a.getRate() * 100.0D));
/*  33 */     int year = d.getYear() + 1900;
/*  34 */     int month = d.getMonth() + 1;
/*  35 */     int date = d.getDate();
/*  36 */     request.getSession().setAttribute("CurrentDate", year + "/" + month + "/" + date);
/*     */     
/*     */ 
/*  39 */     CommentsDAO comments = new CommentsDAO();
/*  40 */     List<Comments> Cs1 = new ArrayList();
/*  41 */     Cs1 = comments.getComments(1);
/*  42 */     if (Cs1.size() == 0)
/*     */     {
/*  44 */       request.getSession().setAttribute("Comments", null);
/*  45 */       request.getSession().setAttribute("CommentsMsg1", "Nothing Here");
/*  46 */       request.getSession().setAttribute("CommentsMsg2", "");
/*     */     }
/*  48 */     else if (Cs1.size() > 3)
/*     */     {
/*  50 */       List<Comments> Cs11 = new ArrayList();
/*  51 */       Cs11.add((Comments)Cs1.get(0));
/*  52 */       Cs11.add((Comments)Cs1.get(1));
/*  53 */       Cs11.add((Comments)Cs1.get(2));
/*  54 */       request.getSession().setAttribute("Comments", Cs11);
/*  55 */       request.getSession().setAttribute("CommentsMsg1", "");
/*  56 */       request.getSession().setAttribute("CommentsMsg2", ">>See More");
/*     */     }
/*     */     else {
/*  59 */       request.getSession().setAttribute("Comments", Cs1);
/*  60 */       request.getSession().setAttribute("CommentsMsg1", "");
/*  61 */       request.getSession().setAttribute("CommentsMsg2", "");
/*     */     }
/*     */     
/*     */ 
/*  65 */     ShopDAO shops = new ShopDAO();
/*  66 */     List<Shopinfo> Cs2 = new ArrayList();
/*  67 */     Cs2 = shops.getShops(-1);
/*  68 */     if (Cs2.size() == 0)
/*     */     {
/*  70 */       request.getSession().setAttribute("Shops", null);
/*  71 */       request.getSession().setAttribute("ShopsMsg1", "Nothing Here");
/*  72 */       request.getSession().setAttribute("ShopsMsg2", "");
/*     */     }
/*  74 */     else if (Cs2.size() > 3)
/*     */     {
/*  76 */       List<Shopinfo> Cs22 = new ArrayList();
/*  77 */       Cs22.add((Shopinfo)Cs2.get(0));
/*  78 */       Cs22.add((Shopinfo)Cs2.get(1));
/*  79 */       Cs22.add((Shopinfo)Cs2.get(2));
/*  80 */       request.getSession().setAttribute("Shops", Cs22);
/*  81 */       request.getSession().setAttribute("ShopsMsg1", "");
/*  82 */       request.getSession().setAttribute("ShopsMsg2", ">>See More");
/*     */     }
/*     */     else
/*     */     {
/*  86 */       request.getSession().setAttribute("Shops", Cs2);
/*  87 */       request.getSession().setAttribute("ShopsMsg1", "");
/*  88 */       request.getSession().setAttribute("ShopsMsg2", "");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  93 */     CustomerDAO customers = new CustomerDAO();
/*  94 */     List<Customerinfo> Cs3 = new ArrayList();
/*  95 */     Cs3 = customers.getCustomers(1);
/*  96 */     if (Cs3.size() == 0)
/*     */     {
/*  98 */       request.getSession().setAttribute("Customers", null);
/*  99 */       request.getSession().setAttribute("CustomersMsg1", "Nothing Here");
/* 100 */       request.getSession().setAttribute("CustomersMsg2", "");
/*     */     }
/* 102 */     else if (Cs3.size() > 3)
/*     */     {
/* 104 */       List<Customerinfo> Cs33 = new ArrayList();
/* 105 */       Cs33.add((Customerinfo)Cs3.get(0));
/* 106 */       Cs33.add((Customerinfo)Cs3.get(1));
/* 107 */       Cs33.add((Customerinfo)Cs3.get(2));
/* 108 */       request.getSession().setAttribute("Customers", Cs33);
/* 109 */       request.getSession().setAttribute("CustomersMsg1", "");
/* 110 */       request.getSession().setAttribute("CustomersMsg2", ">>See More");
/*     */     }
/*     */     else {
/* 113 */       request.getSession().setAttribute("Customers", Cs3);
/* 114 */       request.getSession().setAttribute("CustomersMsg1", "");
/* 115 */       request.getSession().setAttribute("CustomersMsg2", "");
/*     */     }
/*     */     
/* 118 */     request.getRequestDispatcher("admin/index.jsp").forward(request, response);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/* 126 */     request.setCharacterEncoding("UTF-8");
/* 127 */     String AdminName = request.getParameter("AdminName");
/* 128 */     String AdminPwd = request.getParameter("AdminPwd");
/*     */     
/*     */ 
/* 131 */     AdminDAO admin = new AdminDAO();
/* 132 */     int b = admin.adminlogin(AdminName, AdminPwd);
/*     */     
/* 134 */     if (b == -1)
/*     */     {
/* 136 */       request.setAttribute("msg", "Illegal username or password!");
/* 137 */       request.getRequestDispatcher("admin/login.jsp").forward(request, response);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 142 */       request.getSession().setAttribute("AdminName", AdminName);
/* 143 */       Date d = new Date();
/* 144 */       request.getSession().setAttribute("Account", Double.valueOf(admin.getAccount()));
/* 145 */       request.getSession().setAttribute("Rate", Double.valueOf(admin.getRate() * 100.0D));
/* 146 */       request.getSession().setAttribute("CurrentDate", d.getYear() + 1900 + "/" + d.getMonth() + "/" + d.getDate());
/*     */       
/*     */ 
/* 149 */       CommentsDAO comments = new CommentsDAO();
/* 150 */       List<Comments> Cs1 = new ArrayList();
/* 151 */       Cs1 = comments.getComments(1);
/* 152 */       if (Cs1.size() == 0)
/*     */       {
/* 154 */         request.getSession().setAttribute("Comments", null);
/* 155 */         request.getSession().setAttribute("CommentsMsg1", "Nothing Here");
/* 156 */         request.getSession().setAttribute("CommentsMsg2", "");
/*     */       }
/* 158 */       else if (Cs1.size() > 3)
/*     */       {
/* 160 */         List<Comments> Cs11 = new ArrayList();
/* 161 */         Cs11.add((Comments)Cs1.get(0));
/* 162 */         Cs11.add((Comments)Cs1.get(1));
/* 163 */         Cs11.add((Comments)Cs1.get(2));
/* 164 */         request.getSession().setAttribute("Comments", Cs11);
/* 165 */         request.getSession().setAttribute("CommentsMsg1", "");
/* 166 */         request.getSession().setAttribute("CommentsMsg2", ">>See More");
/*     */       }
/*     */       else {
/* 169 */         request.getSession().setAttribute("Comments", Cs1);
/* 170 */         request.getSession().setAttribute("CommentsMsg1", "");
/* 171 */         request.getSession().setAttribute("CommentsMsg2", "");
/*     */       }
/*     */       
/*     */ 
/* 175 */       ShopDAO shops = new ShopDAO();
/* 176 */       List<Shopinfo> Cs2 = new ArrayList();
/* 177 */       Cs2 = shops.getShops(-1);
/* 178 */       if (Cs2.size() == 0)
/*     */       {
/* 180 */         request.getSession().setAttribute("Shops", null);
/* 181 */         request.getSession().setAttribute("ShopsMsg1", "Nothing Here");
/* 182 */         request.getSession().setAttribute("ShopsMsg2", "");
/*     */       }
/* 184 */       else if (Cs2.size() > 3)
/*     */       {
/* 186 */         List<Shopinfo> Cs22 = new ArrayList();
/* 187 */         Cs22.add((Shopinfo)Cs2.get(0));
/* 188 */         Cs22.add((Shopinfo)Cs2.get(1));
/* 189 */         Cs22.add((Shopinfo)Cs2.get(2));
/* 190 */         request.getSession().setAttribute("Shops", Cs22);
/* 191 */         request.getSession().setAttribute("ShopsMsg1", "");
/* 192 */         request.getSession().setAttribute("ShopsMsg2", ">>See More");
/*     */       }
/*     */       else
/*     */       {
/* 196 */         request.getSession().setAttribute("Shops", Cs2);
/* 197 */         request.getSession().setAttribute("ShopsMsg1", "");
/* 198 */         request.getSession().setAttribute("ShopsMsg2", "");
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 203 */       CustomerDAO customers = new CustomerDAO();
/* 204 */       List<Customerinfo> Cs3 = new ArrayList();
/* 205 */       Cs3 = customers.getCustomers(1);
/* 206 */       if (Cs3.size() == 0)
/*     */       {
/* 208 */         request.getSession().setAttribute("Customers", null);
/* 209 */         request.getSession().setAttribute("CustomersMsg1", "Nothing Here");
/* 210 */         request.getSession().setAttribute("CustomersMsg2", "");
/*     */       }
/* 212 */       else if (Cs3.size() > 3)
/*     */       {
/* 214 */         List<Customerinfo> Cs33 = new ArrayList();
/* 215 */         Cs33.add((Customerinfo)Cs3.get(0));
/* 216 */         Cs33.add((Customerinfo)Cs3.get(1));
/* 217 */         Cs33.add((Customerinfo)Cs3.get(2));
/* 218 */         request.getSession().setAttribute("Customers", Cs33);
/* 219 */         request.getSession().setAttribute("CustomersMsg1", "");
/* 220 */         request.getSession().setAttribute("CustomersMsg2", ">>See More");
/*     */       }
/*     */       else {
/* 223 */         request.getSession().setAttribute("Customers", Cs3);
/* 224 */         request.getSession().setAttribute("CustomersMsg1", "");
/* 225 */         request.getSession().setAttribute("CustomersMsg2", "");
/*     */       }
/*     */       
/* 228 */       request.getRequestDispatcher("admin/index.jsp").forward(request, response);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\servlet\AdminLoginServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */