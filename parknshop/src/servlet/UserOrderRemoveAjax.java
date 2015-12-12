/*    */ package servlet;
/*    */ 
/*    */ import interface_impl.MyOrderInterface_impl;
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
/*    */ 
/*    */ public class UserOrderRemoveAjax
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
/* 40 */     String order_id = request.getParameter("order_id");
/*    */     
/* 42 */     int result = 1;
/* 43 */     MyOrderInterface_impl moi = new MyOrderInterface_impl();
/* 44 */     moi.removeOrder(Integer.parseInt(order_id));
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


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\UserOrderRemoveAjax.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */