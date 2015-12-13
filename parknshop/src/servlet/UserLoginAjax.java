/*    */ package servlet;
/*    */ 
/*    */ import interface_impl.UserLoginInterface_impl;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.io.PrintWriter;
/*    */ import javax.servlet.RequestDispatcher;
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
/*    */ public class UserLoginAjax
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
/* 40 */     String customername = request.getParameter("customername") != null ? request.getParameter("customername") : "";
/* 41 */     String password = request.getParameter("password") != null ? request.getParameter("password") : "";
/* 42 */     String logintype = request.getParameter("logintype") != null ? request.getParameter("logintype") : "";
/*    */     
/* 44 */     System.out.println("type:" + logintype);
/*    */     
/* 46 */     UserLoginInterface_impl uli = new UserLoginInterface_impl();
/* 47 */     int result = uli.userlogin(customername, password, Integer.parseInt(logintype));
/* 48 */     request.getSession().setAttribute("customername", customername);
/*    */     
/* 50 */     StringBuffer str = new StringBuffer();
/* 51 */     str.append("{");
/* 52 */     str.append("result:'" + result + "'");
/* 53 */     str.append("}");
/* 54 */     PrintWriter out = response.getWriter();
/* 55 */     out.write(str.toString());
/* 56 */     out.close();
/* 57 */     request.getRequestDispatcher("").forward(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\UserLoginAjax.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */