/*    */ package admin.servlet;
/*    */ 
/*    */ import admin.dao.OrderDAO;
/*    */ import admin.entity.Userorder;
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
/*    */ public class OrdersServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 21 */     request.setCharacterEncoding("UTF-8");
/* 22 */     String type = request.getParameter("type");
/*    */     
/* 24 */     if (Integer.valueOf(type).intValue() == 7)
/*    */     {
/* 26 */       OrderDAO oDAO = new OrderDAO();
/* 27 */       List<Userorder> c = new ArrayList();
/* 28 */       c = oDAO.getAllOrders();
/* 29 */       if (c.size() == 0) {
/* 30 */         request.setAttribute("msg", "Nothing here.");
/*    */       } else {
/* 32 */         request.setAttribute("order", c);
/*    */       }
/* 34 */       request.getRequestDispatcher("admin/Orders.jsp").forward(request, response);
/*    */     }
/* 36 */     else if (Integer.valueOf(type).intValue() == 1)
/*    */     {
/* 38 */       OrderDAO oDAO = new OrderDAO();
/* 39 */       List<Userorder> c = new ArrayList();
/* 40 */       c = oDAO.getAllStatedOrders(1);
/* 41 */       if (c.size() == 0) {
/* 42 */         request.setAttribute("msg", "Nothing here.");
/*    */       } else {
/* 44 */         request.setAttribute("order", c);
/*    */       }
/* 46 */       request.getRequestDispatcher("admin/Orders.jsp").forward(request, response);
/*    */     }
/* 48 */     else if (Integer.valueOf(type).intValue() == 2)
/*    */     {
/* 50 */       OrderDAO oDAO = new OrderDAO();
/* 51 */       List<Userorder> c = new ArrayList();
/* 52 */       c = oDAO.getAllStatedOrders(2);
/* 53 */       if (c.size() == 0) {
/* 54 */         request.setAttribute("msg", "Nothing here.");
/*    */       } else {
/* 56 */         request.setAttribute("order", c);
/*    */       }
/* 58 */       request.getRequestDispatcher("admin/Orders.jsp").forward(request, response);
/*    */     }
/* 60 */     else if (Integer.valueOf(type).intValue() == 3)
/*    */     {
/* 62 */       OrderDAO oDAO = new OrderDAO();
/* 63 */       List<Userorder> c = new ArrayList();
/* 64 */       c = oDAO.getAllStatedOrders(3);
/* 65 */       if (c.size() == 0) {
/* 66 */         request.setAttribute("msg", "Nothing here.");
/*    */       } else {
/* 68 */         request.setAttribute("order", c);
/*    */       }
/* 70 */       request.getRequestDispatcher("admin/Orders.jsp").forward(request, response);
/*    */     }
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {}
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\servlet\OrdersServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */