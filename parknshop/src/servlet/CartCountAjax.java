/*    */ package servlet;
/*    */ 
/*    */ import interface_impl.ShoppingCartInterface_impl;
/*    */ import java.io.IOException;
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
/*    */ 
/*    */ public class CartCountAjax
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
/* 40 */     String customername = (String)request.getSession().getAttribute("customername");
/*    */     
/* 42 */     int result = 0;
/*    */     
/* 44 */     if ((customername == null) || (customername == "")) {
/* 45 */       result = 0;
/*    */     } else {
/* 47 */       ShoppingCartInterface_impl sci = new ShoppingCartInterface_impl();
/* 48 */       result = sci.usercount(customername);
/*    */     }
/*    */     
/* 51 */     StringBuffer str = new StringBuffer();
/* 52 */     str.append("{");
/* 53 */     str.append("result:'" + result + "'");
/* 54 */     str.append("}");
/* 55 */     PrintWriter out = response.getWriter();
/* 56 */     out.write(str.toString());
/* 57 */     out.close();
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\CartCountAjax.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */