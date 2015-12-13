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
/*    */ public class ConfirmGoodAjax
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
/* 40 */     String order_id = request.getParameter("order_id") != null ? request.getParameter("order_id") : "";
/*    */     
/* 42 */     MyOrderInterface_impl moi = new MyOrderInterface_impl();
/* 43 */     moi.confirmgoods(Integer.parseInt(order_id));
/*    */     
/* 45 */     String result = "1";
/* 46 */     StringBuffer str = new StringBuffer();
/* 47 */     str.append("{");
/* 48 */     str.append("result:'" + result + "'");
/* 49 */     str.append("}");
/* 50 */     PrintWriter out = response.getWriter();
/* 51 */     out.write(str.toString());
/* 52 */     out.close();
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\ConfirmGoodAjax.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */