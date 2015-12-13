/*    */ package admin.servlet;
/*    */ 
/*    */ import admin.dao.ShopDAO;
/*    */ import admin.entity.Shopinfo;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShopsServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 25 */      request.setCharacterEncoding("UTF-8");
/* 26 */     String type = request.getParameter("type");
/*    */     
/* 28 */     if (Integer.valueOf(type).intValue() == 7)
/*    */     {
/* 30 */       ShopDAO sDAO = new ShopDAO();
/* 31 */       List<Shopinfo> c = new ArrayList();
/* 32 */       c = sDAO.getAllShops();
/* 33 */       if (c.size() == 0) {
/* 34 */         request.setAttribute("msg", "Nothing here.");
/*    */       } else {
/* 36 */         request.setAttribute("shop", c);
/*    */       }
/* 38 */       request.getRequestDispatcher("admin/Shops.jsp").forward(request, response);
/*    */     }
/* 40 */     else if (Integer.valueOf(type).intValue() == -1)
/*    */     {
/* 42 */       ShopDAO sDAO = new ShopDAO();
/* 43 */       List<Shopinfo> c = new ArrayList();
/* 44 */       c = sDAO.getShops(-1);
/* 45 */       if (c.size() == 0) {
/* 46 */         request.setAttribute("msg", "Nothing here.");
/*    */       } else {
/* 48 */         request.setAttribute("shop", c);
/*    */       }
/* 50 */       request.getRequestDispatcher("admin/Shops.jsp").forward(request, response);
/*    */     }
/* 52 */     else if (Integer.valueOf(type).intValue() == 1)
/*    */     {
/* 54 */       ShopDAO sDAO = new ShopDAO();
/* 55 */       List<Shopinfo> c = new ArrayList();
/* 56 */       c = sDAO.getShops(1);
/* 57 */       if (c.size() == 0) {
/* 58 */         request.setAttribute("msg", "Nothing here.");
/*    */       } else {
/* 60 */         request.setAttribute("shop", c);
/*    */       }
/* 62 */       request.getRequestDispatcher("admin/Shops.jsp").forward(request, response);
/*    */     }
/* 64 */     else if (Integer.valueOf(type).intValue() == 2)
/*    */     {
/* 66 */       ShopDAO sDAO = new ShopDAO();
/* 67 */       List<Shopinfo> c = new ArrayList();
/* 68 */       c = sDAO.getShops(2);
/* 69 */       if (c.size() == 0) {
/* 70 */         request.setAttribute("msg", "Nothing here.");
/*    */       } else {
/* 72 */         request.setAttribute("shop", c);
/*    */       }
/* 74 */       request.getRequestDispatcher("admin/Shops.jsp").forward(request, response);
/*    */     }
/* 76 */     else if (Integer.valueOf(type).intValue() == 0)//获取审核中的电子
/*    */     {
/* 78 */       ShopDAO sDAO = new ShopDAO();
/* 79 */       List<Shopinfo> c = new ArrayList();
/* 80 */       c = sDAO.getShops(0);
/* 81 */       if (c.size() == 0) {
/* 82 */         request.setAttribute("msg", "Nothing here.");
/*    */       } else {
/* 84 */         request.setAttribute("shop", c);
/*    */       }
/* 86 */       request.getRequestDispatcher("admin/Shops.jsp").forward(request, response);
/*    */     }
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {}
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\servlet\ShopsServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */