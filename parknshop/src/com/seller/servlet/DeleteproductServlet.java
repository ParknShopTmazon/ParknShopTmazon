/*    */ package com.seller.servlet;
/*    */ 
/*    */ import com.seller.service.ProductService;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
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
/*    */ 
/*    */ public class DeleteproductServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   public void destroy()
/*    */   {
/* 27 */     super.destroy();
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
/* 44 */     int productid = Integer.parseInt(request.getParameter("del_productid"));
/*    */     
/* 46 */     System.out.print(productid);
/* 47 */     ProductService ps = new ProductService();
/* 48 */     ps.delproduct(productid);
/*    */     
/* 50 */     RequestDispatcher dispatcher = request.getRequestDispatcher("../seller/ku_list.jsp");
/* 51 */     dispatcher.forward(request, response);
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
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 68 */     int productid = Integer.parseInt(request.getParameter("del_productid"));
/*    */     
/* 70 */     System.out.print(productid);
/* 71 */     ProductService ps = new ProductService();
/* 72 */     ps.delproduct(productid);
/*    */   }
/*    */   
/*    */   public void init()
/*    */     throws ServletException
/*    */   {}
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\com\seller\servlet\DeleteproductServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */