/*    */ package servlet;
/*    */ 
/*    */ import interface_impl.UserAccountInterface_impl;
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
/*    */ public class UserAccountAjax
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
/* 42 */     UserAccountInterface_impl uai = new UserAccountInterface_impl();
/* 43 */     double result = uai.useraccount(customername);
/* 44 */     StringBuffer str = new StringBuffer();
/* 45 */     str.append("{");
/* 46 */     str.append("result:'" + result + "'");
/* 47 */     str.append("}");
/*    */     
/* 49 */     PrintWriter out = response.getWriter();
/* 50 */     out.write(str.toString());
/* 51 */     out.close();
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\UserAccountAjax.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */