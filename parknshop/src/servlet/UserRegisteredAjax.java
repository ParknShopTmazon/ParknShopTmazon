/*    */ package servlet;
/*    */ 
/*    */ import interface_impl.UserRegisteredInterface_impl;
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
/*    */ public class UserRegisteredAjax
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
/* 40 */     String username = request.getParameter("username") != null ? request.getParameter("username") : "";
/* 41 */     String password = request.getParameter("password") != null ? request.getParameter("password") : "";
/* 42 */     String realname = request.getParameter("realname") != null ? request.getParameter("realname") : "";
/* 43 */     String email = request.getParameter("email") != null ? request.getParameter("email") : "";
/* 44 */     String phonenumber = request.getParameter("phonenumber") != null ? request.getParameter("phonenumber") : "";
/* 45 */     String identityid = request.getParameter("identityid") != null ? request.getParameter("identityid") : "";
/*    */     
/* 47 */     UserRegisteredInterface_impl uri = new UserRegisteredInterface_impl();
/* 48 */     int result = uri.userregistered(username, password, realname, email, phonenumber, identityid);
/*    */     
/* 50 */     System.out.println(username + password + realname + email + phonenumber + identityid);
/*    */     
/* 52 */     request.getSession().setAttribute("customername", username);
/* 53 */     StringBuffer str = new StringBuffer();
/* 54 */     str.append("{");
/* 55 */     str.append("result:'" + result + "'");
/* 56 */     str.append("}");
/* 57 */     PrintWriter out = response.getWriter();
/* 58 */     out.write(str.toString());
/* 59 */     out.close();
/* 60 */     request.getRequestDispatcher("").forward(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\UserRegisteredAjax.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */