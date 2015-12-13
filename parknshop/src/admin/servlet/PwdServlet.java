/*    */ package admin.servlet;
/*    */ 
/*    */ import admin.dao.AdminDAO;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class PwdServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {}
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 22 */     request.setCharacterEncoding("UTF-8");
/*    */     
/* 24 */     String AdminName = request.getSession().getAttribute("AdminName").toString();
/* 25 */     String CurrentPwd = request.getParameter("CurrentPwd");
/* 26 */     String NewPwd1 = request.getParameter("NewPwd1");
/* 27 */     String NewPwd2 = request.getParameter("NewPwd2");
/*    */     
/* 29 */     if ((CurrentPwd == "") || (NewPwd1 == "") || (NewPwd2 == ""))
/*    */     {
/* 31 */       request.setAttribute("msg", "You must fill all the blanks.");
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 36 */       AdminDAO a = new AdminDAO();
/* 37 */       int ans = a.ChangePwd(AdminName, CurrentPwd, NewPwd1, NewPwd2);
/*    */       
/* 39 */       if (ans == 0)
/*    */       {
/* 41 */         request.setAttribute("msg", "Successfully modified.");
/*    */       }
/* 43 */       else if (ans == 1)
/*    */       {
/* 45 */         request.setAttribute("msg", "Current Password Error.");
/*    */       }
/* 47 */       else if (ans == 2)
/*    */       {
/* 49 */         request.setAttribute("msg", "Two New Passwords are different.");
/*    */       }
/* 51 */       else if (ans == 3)
/*    */       {
/* 53 */         request.setAttribute("msg", "New Password's length should be less than 20.");
/*    */       }
/*    */     }
/*    */     
/* 57 */     request.getRequestDispatcher("admin/ChangePwd.jsp").forward(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\servlet\PwdServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */