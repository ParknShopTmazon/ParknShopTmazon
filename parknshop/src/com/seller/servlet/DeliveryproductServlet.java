/*    */ package com.seller.servlet;
/*    */ 
/*    */ import com.seller.dao.UserorderDao;
/*    */ import com.seller.service.OrderService;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DeliveryproductServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   public void destroy()
/*    */   {
/* 29 */     super.destroy();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 46 */     int orderid = Integer.parseInt(request.getParameter("orderid"));
/* 47 */     String ordertime = request.getParameter("ordertime");
/*    */     
/* 49 */     OrderService os = new OrderService();
/* 50 */     os.delivery(orderid);
/*    */     
/* 52 */     UserorderDao ud = new UserorderDao();
/* 53 */     ud.createTackingNum(orderid, ordertime);
/*    */     
/* 55 */     response.sendRedirect("../seller/goods.jsp");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 73 */     response.setContentType("text/html");
/* 74 */     PrintWriter out = response.getWriter();
/* 75 */     out
/* 76 */       .println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
/* 77 */     out.println("<HTML>");
/* 78 */     out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
/* 79 */     out.println("  <BODY>");
/* 80 */     out.print("    This is ");
/* 81 */     out.print(getClass());
/* 82 */     out.println(", using the POST method");
/* 83 */     out.println("  </BODY>");
/* 84 */     out.println("</HTML>");
/* 85 */     out.flush();
/* 86 */     out.close();
/*    */   }
/*    */   
/*    */   public void init()
/*    */     throws ServletException
/*    */   {}
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\com\seller\servlet\DeliveryproductServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */