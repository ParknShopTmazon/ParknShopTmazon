/*     */ package admin.servlet;
/*     */ 
/*     */ import admin.dao.CommentsDAO;
/*     */ import admin.dao.CustomerDAO;
/*     */ import admin.dao.OrderDAO;
/*     */ import admin.dao.ProductDAO;
/*     */ import admin.dao.SearchDAO;
/*     */ import admin.dao.ShopDAO;
/*     */ import admin.entity.Comments;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.servlet.RequestDispatcher;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ 
/*     */ public class SearchServlet extends javax.servlet.http.HttpServlet
/*     */ {
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
/*     */   {
/*  21 */     request.setCharacterEncoding("UTF-8");
/*  22 */     String t = request.getParameter("t");
/*  23 */     String id = request.getParameter("id");
/*     */     
/*     */ 
/*     */ 
/*  27 */     if (Integer.valueOf(t).intValue() == 1)
/*     */     {
/*  29 */       CustomerDAO cDAO = new CustomerDAO();
/*  30 */       List<admin.entity.Customerinfo> c = new ArrayList();
/*  31 */       c = cDAO.getAnyCustomers(id);
/*  32 */       request.setAttribute("customer", c);
/*  33 */       request.getRequestDispatcher("admin/Customer.jsp").forward(request, response);
/*     */     }
/*  35 */     else if (Integer.valueOf(t).intValue() == 2)
/*     */     {
/*  37 */       CommentsDAO cDAO = new CommentsDAO();
/*  38 */       List<Comments> c = new ArrayList();
/*  39 */       c = cDAO.getAnyComments(Integer.valueOf(id).intValue());
/*     */       
/*  41 */       request.setAttribute("comment", c);
/*  42 */       request.getRequestDispatcher("admin/Comment.jsp").forward(request, response);
/*     */     }
/*  44 */     else if (Integer.valueOf(t).intValue() == 3)
/*     */     {
/*  46 */       ShopDAO cDAO = new ShopDAO();
/*  47 */       List<admin.entity.Shopinfo> c = new ArrayList();
/*  48 */       c = cDAO.getAnyShops(Integer.valueOf(id).intValue());
/*     */       
/*  50 */       request.setAttribute("shop", c);
/*  51 */       request.getRequestDispatcher("admin/Shop.jsp").forward(request, response);
/*     */     }
/*  53 */     else if (Integer.valueOf(t).intValue() == 4)
/*     */     {
/*  55 */       OrderDAO cDAO = new OrderDAO();
/*  56 */       List<admin.entity.Userorder> c = new ArrayList();
/*  57 */       c = cDAO.getAnyOrders(Integer.valueOf(id).intValue());
/*     */       
/*  59 */       request.setAttribute("order", c);
/*     */       
/*  61 */       request.getRequestDispatcher("admin/Order.jsp").forward(request, response);
/*     */     }
/*  63 */     else if (Integer.valueOf(t).intValue() == 5)
/*     */     {
/*  65 */       ProductDAO pDAO = new ProductDAO();
/*  66 */       List<admin.entity.Productinfo> c = new ArrayList();
/*  67 */       c = pDAO.getAnyProducts(id);
/*     */       
/*  69 */       request.setAttribute("product", c);
/*     */       
/*  71 */       request.getRequestDispatcher("admin/Product.jsp").forward(request, response);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, java.io.IOException
/*     */   {
/*  79 */     request.setCharacterEncoding("UTF-8");
/*  80 */     String SearchInput = request.getParameter("SearchInput");
/*  81 */     String SearchType = request.getParameter("SearchType");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  86 */     if (SearchInput == "")
/*     */     {
/*  88 */       request.setAttribute("msg", "You can't input nothing.");
/*  89 */       request.getRequestDispatcher("admin/search.jsp").forward(request, response);
/*     */ 
/*     */ 
/*     */     }
/*  93 */     else if (Integer.valueOf(SearchType).intValue() == 0)
/*     */     {
/*  95 */       SearchDAO c0 = new SearchDAO();
/*  96 */       List<admin.entity.Result> c00 = new ArrayList();
/*  97 */       c00 = c0.getAll(SearchInput);
/*  98 */       if (c00.size() == 0)
/*     */       {
/* 100 */         request.setAttribute("msg", "Nothing here.");
/* 101 */         request.setAttribute("result", c00);
/*     */       }
/*     */       else {
/* 104 */         request.setAttribute("result", c00);
/*     */       }
/* 106 */       request.getRequestDispatcher("admin/search.jsp").forward(request, response);
/*     */     }
/* 108 */     else if (Integer.valueOf(SearchType).intValue() == 1)
/*     */     {
/* 110 */       CustomerDAO c1 = new CustomerDAO();
/* 111 */       List<admin.entity.Customerinfo> c11 = new ArrayList();
/* 112 */       c11 = c1.getSomeCustomers(SearchInput);
/* 113 */       if (c11.size() == 0)
/*     */       {
/* 115 */         request.setAttribute("msg", "Nothing here.");
/* 116 */         request.setAttribute("customer", c11);
/*     */       }
/*     */       else {
/* 119 */         request.setAttribute("customer", c11);
/*     */       }
/* 121 */       request.getRequestDispatcher("admin/Customers.jsp").forward(request, response);
/*     */     }
/* 123 */     else if (Integer.valueOf(SearchType).intValue() == 2)
/*     */     {
/* 125 */       CommentsDAO c2 = new CommentsDAO();
/* 126 */       List<Comments> c22 = new ArrayList();
/* 127 */       c22 = c2.getSomeComments(SearchInput);
/* 128 */       if (c22.size() == 0)
/*     */       {
/* 130 */         request.setAttribute("msg", "Nothing here.");
/* 131 */         request.setAttribute("comment", c22);
/*     */       }
/*     */       else {
/* 134 */         request.setAttribute("comment", c22); }
/* 135 */       request.getRequestDispatcher("admin/Comments.jsp").forward(request, response);
/*     */     }
/* 137 */     else if (Integer.valueOf(SearchType).intValue() == 3)
/*     */     {
/* 139 */       ShopDAO c3 = new ShopDAO();
/* 140 */       List<admin.entity.Shopinfo> c33 = new ArrayList();
/* 141 */       c33 = c3.getSomeShops(SearchInput);
/* 142 */       if (c33.size() == 0)
/*     */       {
/* 144 */         request.setAttribute("msg", "Nothing here.");
/* 145 */         request.setAttribute("shop", c33);
/*     */       }
/*     */       else {
/* 148 */         request.setAttribute("shop", c33); }
/* 149 */       request.getRequestDispatcher("admin/Shops.jsp").forward(request, response);
/*     */     }
/* 151 */     else if (Integer.valueOf(SearchType).intValue() == 4)
/*     */     {
/* 153 */       OrderDAO c4 = new OrderDAO();
/* 154 */       List<admin.entity.Userorder> c44 = new ArrayList();
/* 155 */       c44 = c4.getSomeOrders(SearchInput);
/* 156 */       if (c44.size() == 0)
/*     */       {
/* 158 */         request.setAttribute("msg", "Nothing here.");
/* 159 */         request.setAttribute("order", c44);
/*     */       }
/*     */       else {
/* 162 */         request.setAttribute("order", c44); }
/* 163 */       request.getRequestDispatcher("admin/Orders.jsp").forward(request, response);
/*     */     }
/* 165 */     else if (Integer.valueOf(SearchType).intValue() == 5)
/*     */     {
/* 167 */       ProductDAO c5 = new ProductDAO();
/* 168 */       List<admin.entity.Productinfo> c55 = new ArrayList();
/* 169 */       c55 = c5.getSomeProducts(SearchInput);
/* 170 */       if (c55.size() == 0)
/*     */       {
/* 172 */         request.setAttribute("msg", "Nothing here.");
/* 173 */         request.setAttribute("product", c55);
/*     */       }
/*     */       else {
/* 176 */         request.setAttribute("product", c55); }
/* 177 */       request.getRequestDispatcher("admin/Products.jsp").forward(request, response);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\servlet\SearchServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */