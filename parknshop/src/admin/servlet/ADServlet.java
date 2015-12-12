/*    */ package admin.servlet;
/*    */ 
/*    */ import admin.dao.ADDAO;
/*    */ import admin.entity.ADs;
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
/*    */ public class ADServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 21 */     request.setCharacterEncoding("UTF-8");
/* 22 */     String id = request.getParameter("id");
/* 23 */     String operation = request.getParameter("operation");
/*    */     
/* 25 */     if (operation == null)
/*    */     {
/* 27 */       ADDAO a = new ADDAO();
/* 28 */       List<ADs> c = new ArrayList();
/* 29 */       c = a.getAnyADs(Integer.valueOf(id).intValue());
/* 30 */       request.setAttribute("ads", c);
/*    */       
/* 32 */       request.getRequestDispatcher("admin/AD.jsp").forward(request, response);
/*    */     }
/*    */     else
/*    */     {
/* 36 */       ADDAO a = new ADDAO();
/* 37 */       a.DeleteAD(Integer.valueOf(id).intValue());
/*    */       
/* 39 */       List<ADs> c = new ArrayList();
/* 40 */       c = a.getAllADs();
/* 41 */       if (c.size() == 0) {
/* 42 */         request.setAttribute("msg", "Nothing here.");
/*    */       } else {
/* 44 */         request.setAttribute("ads", c);
/*    */       }
/* 46 */       request.getRequestDispatcher("admin/ADs.jsp").forward(request, response);
/*    */     }
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {}
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\servlet\ADServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */