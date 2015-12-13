/*    */ package servlet;
/*    */ 
/*    */ import interface_impl.UserRegisteredInterface_impl;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
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
/*    */ public class CheckNameAjax
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
/* 40 */     String name = request.getParameter("name") != null ? request.getParameter("name") : "";
/* 41 */     UserRegisteredInterface_impl uri = new UserRegisteredInterface_impl();
/* 42 */     int result = uri.checkusername(name);
/* 43 */     System.out.println(name);
/*    */     
/* 45 */     System.out.println(result);
/* 46 */     StringBuffer str = new StringBuffer();
/* 47 */     str.append("{");
/* 48 */     str.append("result:'" + result + "'");
/* 49 */     str.append("}");
/* 50 */     PrintWriter out = response.getWriter();
/* 51 */     out.write(str.toString());
/* 52 */     out.close();
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\CheckNameAjax.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */