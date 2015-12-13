/*     */ package admin.servlet;
/*     */ 
/*     */ import admin.dao.CustomerDAO;
/*     */ import admin.entity.Customerinfo;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.servlet.RequestDispatcher;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustomersServlet
/*     */   extends HttpServlet
/*     */ {
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/*  22 */     request.setCharacterEncoding("UTF-8");
/*  23 */     String role = request.getParameter("role");
/*  24 */     String type = request.getParameter("type");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  29 */     if (role == null)
/*     */     {
/*  31 */       if (Integer.valueOf(type).intValue() == 1)
/*     */       {
/*  33 */         CustomerDAO cDAO = new CustomerDAO();
/*  34 */         List<Customerinfo> c = new ArrayList();
/*  35 */         c = cDAO.getCustomers(1);
/*  36 */         if (c.size() == 0) {
/*  37 */           request.setAttribute("msg", "Nothing here.");
/*     */         } else {
/*  39 */           request.setAttribute("customer", c);
/*     */         }
/*  41 */         request.getRequestDispatcher("admin/Customers.jsp").forward(request, response);
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*  46 */     else if (Integer.valueOf(role).intValue() == 0)
/*     */     {
/*  48 */       if (Integer.valueOf(type).intValue() == 7)
/*     */       {
/*  50 */         CustomerDAO cDAO = new CustomerDAO();
/*  51 */         List<Customerinfo> c = new ArrayList();
/*  52 */         c = cDAO.getALLBuyers();
/*  53 */         if (c.size() == 0) {
/*  54 */           request.setAttribute("msg", "Nothing here.");
/*     */         } else {
/*  56 */           request.setAttribute("customer", c);
/*     */         }
/*  58 */         request.getRequestDispatcher("admin/Customers.jsp").forward(request, response);
/*     */       }
/*  60 */       else if (Integer.valueOf(type).intValue() == 0)
/*     */       {
/*  62 */         CustomerDAO cDAO = new CustomerDAO();
/*  63 */         List<Customerinfo> c = new ArrayList();
/*  64 */         c = cDAO.getBuyers(0);
/*  65 */         if (c.size() == 0) {
/*  66 */           request.setAttribute("msg", "Nothing here.");
/*     */         } else {
/*  68 */           request.setAttribute("customer", c);
/*     */         }
/*  70 */         request.getRequestDispatcher("admin/Customers.jsp").forward(request, response);
/*     */       }
/*  72 */       else if (Integer.valueOf(type).intValue() == 1)
/*     */       {
/*  74 */         CustomerDAO cDAO = new CustomerDAO();
/*  75 */         List<Customerinfo> c = new ArrayList();
/*  76 */         c = cDAO.getBuyers(1);
/*  77 */         if (c.size() == 0) {
/*  78 */           request.setAttribute("msg", "Nothing here.");
/*     */         } else {
/*  80 */           request.setAttribute("customer", c);
/*     */         }
/*  82 */         request.getRequestDispatcher("admin/Customers.jsp").forward(request, response);
/*     */       }
/*  84 */       else if (Integer.valueOf(type).intValue() == 2)
/*     */       {
/*  86 */         CustomerDAO cDAO = new CustomerDAO();
/*  87 */         List<Customerinfo> c = new ArrayList();
/*  88 */         c = cDAO.getBuyers(2);
/*  89 */         if (c.size() == 0) {
/*  90 */           request.setAttribute("msg", "Nothing here.");
/*     */         } else {
/*  92 */           request.setAttribute("customer", c);
/*     */         }
/*  94 */         request.getRequestDispatcher("admin/Customers.jsp").forward(request, response);
/*     */       }
/*     */     }
/*  97 */     else if (Integer.valueOf(role).intValue() == 1)
/*     */     {
/*  99 */       if (Integer.valueOf(type).intValue() == 7)
/*     */       {
/* 101 */         CustomerDAO cDAO = new CustomerDAO();
/* 102 */         List<Customerinfo> c = new ArrayList();
/* 103 */         c = cDAO.getALLSellers();
/* 104 */         if (c.size() == 0) {
/* 105 */           request.setAttribute("msg", "Nothing here.");
/*     */         } else {
/* 107 */           request.setAttribute("customer", c);
/*     */         }
/* 109 */         request.getRequestDispatcher("admin/Customers.jsp").forward(request, response);
/*     */       }
/* 111 */       else if (Integer.valueOf(type).intValue() == 0)
/*     */       {
/* 113 */         CustomerDAO cDAO = new CustomerDAO();
/* 114 */         List<Customerinfo> c = new ArrayList();
/* 115 */         c = cDAO.getSellers(0);
/* 116 */         if (c.size() == 0) {
/* 117 */           request.setAttribute("msg", "Nothing here.");
/*     */         } else {
/* 119 */           request.setAttribute("customer", c);
/*     */         }
/* 121 */         request.getRequestDispatcher("admin/Customers.jsp").forward(request, response);
/*     */       }
/* 123 */       else if (Integer.valueOf(type).intValue() == 1)
/*     */       {
/*     */ 
/* 126 */         CustomerDAO cDAO = new CustomerDAO();
/* 127 */         List<Customerinfo> c = new ArrayList();
/* 128 */         c = cDAO.getSellers(1);
/* 129 */         if (c.size() == 0) {
/* 130 */           request.setAttribute("msg", "Nothing here.");
/*     */         } else {
/* 132 */           request.setAttribute("customer", c);
/*     */         }
/* 134 */         request.getRequestDispatcher("admin/Customers.jsp").forward(request, response);
/*     */       }
/* 136 */       else if (Integer.valueOf(type).intValue() == 2)
/*     */       {
/* 138 */         CustomerDAO cDAO = new CustomerDAO();
/* 139 */         List<Customerinfo> c = new ArrayList();
/* 140 */         c = cDAO.getSellers(2);
/* 141 */         if (c.size() == 0) {
/* 142 */           request.setAttribute("msg", "Nothing here.");
/*     */         } else {
/* 144 */           request.setAttribute("customer", c);
/*     */         }
/* 146 */         request.getRequestDispatcher("admin/Customers.jsp").forward(request, response);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {}
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\servlet\CustomersServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */