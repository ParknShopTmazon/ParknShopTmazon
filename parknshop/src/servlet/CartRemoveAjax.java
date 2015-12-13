/*    */ package servlet;
/*    */ 
/*    */ import interface_impl.ShoppingCartInterface_impl;
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
/*    */ public class CartRemoveAjax
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 31 */     doPost(request, response);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 39 */     String customername = (String)request.getSession().getAttribute("customername");
/* 40 */     String product_ID = request.getParameter("product_ID") != null ? request.getParameter("product_ID") : "";
/* 41 */     System.out.println("product_ID=" + product_ID);
/*    */     
/* 43 */     ShoppingCartInterface_impl sci = new ShoppingCartInterface_impl();
/* 44 */     int result = sci.cartremove(customername, Integer.parseInt(product_ID));
/*    */     
/* 46 */     StringBuffer str = new StringBuffer();
/* 47 */     str.append("{");
/* 48 */     str.append("result:'" + result + "'");
/* 49 */     str.append("}");
/*    */     
/* 51 */     PrintWriter out = response.getWriter();
/* 52 */     out.write(str.toString());
/* 53 */     out.close();
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\CartRemoveAjax.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */