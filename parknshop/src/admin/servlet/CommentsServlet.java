/*    */ package admin.servlet;
/*    */ 
/*    */ import admin.dao.CommentsDAO;
/*    */ import admin.entity.Comments;
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
/*    */ public class CommentsServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 21 */     request.setCharacterEncoding("UTF-8");
/* 22 */     String type = request.getParameter("type");
/*    */     
/* 24 */     if (Integer.valueOf(type).intValue() == 7)
/*    */     {
/* 26 */       CommentsDAO cDAO = new CommentsDAO();
/* 27 */       List<Comments> c = new ArrayList();
/* 28 */       c = cDAO.getAllComments();
/* 29 */       if (c.size() == 0) {
/* 30 */         request.setAttribute("msg", "Nothing here.");
/*    */       } else {
/* 32 */         request.setAttribute("comment", c);
/*    */       }
/* 34 */       request.getRequestDispatcher("admin/Comments.jsp").forward(request, response);
/*    */     }
/* 36 */     else if (Integer.valueOf(type).intValue() == 0)
/*    */     {
/* 38 */       CommentsDAO cDAO = new CommentsDAO();
/* 39 */       List<Comments> c = new ArrayList();
/* 40 */       c = cDAO.getComments(0);
/* 41 */       if (c.size() == 0) {
/* 42 */         request.setAttribute("msg", "Nothing here.");
/*    */       } else {
/* 44 */         request.setAttribute("comment", c);
/*    */       }
/* 46 */       request.getRequestDispatcher("admin/Comments.jsp").forward(request, response);
/*    */     }
/* 48 */     else if (Integer.valueOf(type).intValue() == 1)
/*    */     {
/* 50 */       CommentsDAO cDAO = new CommentsDAO();
/* 51 */       List<Comments> c = new ArrayList();
/* 52 */       c = cDAO.getComments(1);
/* 53 */       if (c.size() == 0) {
/* 54 */         request.setAttribute("msg", "Nothing here.");
/*    */       } else {
/* 56 */         request.setAttribute("comment", c);
/*    */       }
/* 58 */       request.getRequestDispatcher("admin/Comments.jsp").forward(request, response);
/*    */     }
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {}
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\servlet\CommentsServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */