/*    */ package com.seller.servlet;
/*    */ 
/*    */ import com.seller.dao.GetShopinfoDao;
/*    */ import com.seller.service.SellerLogin;
/*    */ import com.seller.vo.Shopinfo;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SellerLoginServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   public void destroy()
/*    */   {
/* 28 */     super.destroy();
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
/* 45 */     response.setContentType("text/html");
/* 46 */     PrintWriter out = response.getWriter();
/* 47 */     out
/* 48 */       .println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
/* 49 */     out.println("<HTML>");
/* 50 */     out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
/* 51 */     out.println("  <BODY>");
/* 52 */     out.print("    This is ");
/* 53 */     out.print(getClass());
/* 54 */     out.println(", using the GET method");
/* 55 */     out.println("  </BODY>");
/* 56 */     out.println("</HTML>");
/* 57 */     out.flush();
/* 58 */     out.close();
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
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 74 */     String sName = request.getParameter("SellerName");
/* 75 */     String sPwd = request.getParameter("SellerPwd");
/*    */     
/* 77 */     SellerLogin sl = new SellerLogin();
/* 78 */     int msg = sl.login(sName, sPwd);
/*    */     
/* 80 */     if (msg == 0)
/*    */     {
/* 82 */       String mesg = "Wrong usernmae or password!";
/* 83 */       request.setAttribute("message", mesg);
/* 84 */       request.getRequestDispatcher("../seller/login.jsp").forward(request, response);
/*    */     }
/*    */     else
/*    */     {
/* 88 */       Shopinfo si = new Shopinfo();
/* 89 */       GetShopinfoDao gs = new GetShopinfoDao();
/* 90 */       si = gs.getsid(sName);
/*    */       
/* 92 */       request.setAttribute("shopinfo", si);
/* 93 */       request.getRequestDispatcher("../seller/index.jsp").forward(request, response);
/*    */     }
/*    */   }
/*    */   
/*    */   public void init()
/*    */     throws ServletException
/*    */   {}
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\com\seller\servlet\SellerLoginServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */