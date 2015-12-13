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
/*    */ public class RateServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*    */   {
/* 17 */     request.setCharacterEncoding("UTF-8");
/* 18 */     AdminDAO a = new AdminDAO();
/*    */     
/* 20 */     request.getSession().setAttribute("Rate", Double.valueOf(a.getRate() * 100.0D));
/* 21 */     request.getRequestDispatcher("admin/ChangeRate.jsp").forward(request, response);
/*    */   }
/*    */   
/*    */ 
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 28 */     request.setCharacterEncoding("UTF-8");
/*    */     
/* 30 */     String NewRate = request.getParameter("NewRate");
/* 31 */     if (NewRate == null)
/*    */     {
/* 33 */       request.setAttribute("msg", "You can't input nothing.");
/*    */     }
/* 35 */     else if (!NewRate.matches("^[+-]?\\d*[.]?\\d*$"))
/*    */     {
/* 37 */       request.setAttribute("msg", "You can only input Numbers.");
/*    */     }
/*    */     else
/*    */     {
/* 41 */       AdminDAO a = new AdminDAO();
/* 42 */       if (NewRate.length() > 30)
/*    */       {
/* 44 */         request.setAttribute("msg", "The length of numbers should be less than 30.");
/*    */       }
/*    */       else
/*    */       {
/* 48 */         double temp = Double.valueOf(NewRate).doubleValue();
/* 49 */         if ((temp >= 0.0D) && (temp <= 100.0D))
/*    */         {
/* 51 */           a.ChangeRate(temp / 100.0D);
/* 52 */           request.getSession().setAttribute("Rate", Double.valueOf(a.getRate() * 100.0D));
/* 53 */           request.setAttribute("msg", "Successfully modified.");
/*    */         }
/*    */         else {
/* 56 */           request.setAttribute("msg", "You can only input Numbers between 0 and 100.");
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 61 */     request.getRequestDispatcher("admin/ChangeRate.jsp").forward(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\servlet\RateServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */