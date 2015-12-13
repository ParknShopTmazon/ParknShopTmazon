/*    */ package servlet;
/*    */ 
/*    */ import interface_impl.AddToCartInterface_impl;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.io.PrintWriter;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
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
/*    */ public class AddToCartAjax
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 32 */     doPost(request, response);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 40 */     String product_ID = request.getParameter("product_ID") != null ? request.getParameter("product_ID") : "";
/* 41 */     String product_quantity = request.getParameter("product_quantity") != null ? request.getParameter("product_quantity") : "";
/* 42 */     String customername = (String)request.getSession().getAttribute("customername");
/* 43 */     System.out.println("product_ID=" + product_ID + "product_quantity=" + product_quantity);
/*    */     
/* 45 */     int result = 0;
/* 46 */     AddToCartInterface_impl atci = new AddToCartInterface_impl();
/* 47 */     result = atci.addtocart(customername, Integer.parseInt(product_ID), Integer.parseInt(product_quantity));
/*    */     
/* 49 */     StringBuffer str = new StringBuffer();
/* 50 */     str.append("{");
/* 51 */     str.append("result:'" + result + "'");
/* 52 */     str.append("}");
/*    */     
/* 54 */     PrintWriter out = response.getWriter();
/* 55 */     out.write(str.toString());
/* 56 */     out.close();
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\AddToCartAjax.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */