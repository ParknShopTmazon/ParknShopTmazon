/*    */ package servlet;
/*    */ 
/*    */ import interface_impl.MyFavoriteProductsInterface_impl;
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
/*    */ public class AddToFavoriteAjax
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
/* 41 */     String product_ID = request.getParameter("product_ID") != null ? request.getParameter("product_ID") : "";
/*    */     
/*    */ 
/* 44 */     MyFavoriteProductsInterface_impl mfpi = new MyFavoriteProductsInterface_impl();
/* 45 */     int result = mfpi.addtomyfavorite(customername, Integer.parseInt(product_ID));
/*    */     
/* 47 */     StringBuffer str = new StringBuffer();
/* 48 */     str.append("{");
/* 49 */     str.append("result:'" + result + "'");
/* 50 */     str.append("}");
/*    */     
/* 52 */     PrintWriter out = response.getWriter();
/* 53 */     out.write(str.toString());
/* 54 */     out.close();
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\AddToFavoriteAjax.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */