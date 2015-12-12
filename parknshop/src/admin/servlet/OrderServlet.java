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
/*    */ public class OrderServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 20 */     request.setCharacterEncoding("UTF-8");
/* 21 */     String id = request.getParameter("id");
/*    */     
/* 23 */     OrderDAO cDAO = new OrderDAO();
/* 24 */     List<Userorder> c = new ArrayList();
/* 25 */     c = cDAO.getAnyOrders(Integer.valueOf(id).intValue());
/*    */     
/* 27 */     request.setAttribute("order", c);
/*    */     
/* 29 */     request.getRequestDispatcher("admin/Order.jsp").forward(request, response);
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {}
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\servlet\OrderServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */