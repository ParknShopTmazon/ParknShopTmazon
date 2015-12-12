/*    */ package admin.servlet;
/*    */ 
/*    */ import admin.dao.CustomerDAO;
/*    */ import admin.entity.Customerinfo;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CustomerServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 24 */     request.setCharacterEncoding("UTF-8");
/* 25 */     String operation = request.getParameter("operation");
/* 26 */     String id = request.getParameter("id");
/*    */     
/* 28 */     if (operation == null)
/*    */     {
/* 30 */       CustomerDAO cDAO = new CustomerDAO();
/* 31 */       List<Customerinfo> c = new ArrayList();
/* 32 */       c = cDAO.getAnyCustomers(id);
/*    */       
/* 34 */       request.setAttribute("customer", c);
/*    */     }
/*    */     else
/*    */     {
/* 38 */       CustomerDAO cDAO = new CustomerDAO();
/* 39 */       if (Integer.valueOf(operation).intValue() == 1)
/*    */       {
/* 41 */         cDAO.RecoverCustomers(id);
/*    */       }
/* 43 */       else if (Integer.valueOf(operation).intValue() == 2)
/*    */       {
/* 45 */         cDAO.DeleteCustomers(id);
				
/*    */       }
/*    */       
/* 48 */       List<Customerinfo> c = new ArrayList();
/* 49 */       c = cDAO.getAnyCustomers(id);
/*    */       
/* 51 */       request.setAttribute("customer", c);
/*    */     }
/*    */     
/*    */ 
/* 55 */     request.getRequestDispatcher("admin/Customer.jsp").forward(request, response);
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {}
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\servlet\CustomerServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */