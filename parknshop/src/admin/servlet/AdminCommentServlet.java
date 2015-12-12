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
/*    */ public class AdminCommentServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 20 */     request.setCharacterEncoding("UTF-8");
/* 21 */     String id = request.getParameter("id");
/* 22 */     String operation = request.getParameter("operation");
/*    */     
/* 24 */     if (operation == null)
/*    */     {
/* 26 */       CommentsDAO cDAO = new CommentsDAO();
/* 27 */       List<Comments> c = new ArrayList();
/* 28 */       c = cDAO.getAnyComments(Integer.valueOf(id).intValue());
/*    */       
/* 30 */       request.setAttribute("comment", c);
/* 31 */       request.getRequestDispatcher("admin/Comment.jsp").forward(request, response);
/*    */     }
/*    */     else
/*    */     {
/* 35 */       CommentsDAO cDAO = new CommentsDAO();
/* 36 */       if (Integer.valueOf(operation).intValue() == 1)
/*    */       {
/* 38 */         cDAO.RecoverComments(Integer.valueOf(id).intValue());
/*    */         
/* 40 */         List<Comments> c = new ArrayList();
/* 41 */         c = cDAO.getAnyComments(Integer.valueOf(id).intValue());
/*    */         
/* 43 */         request.setAttribute("comment", c);
/* 44 */         request.getRequestDispatcher("admin/Comment.jsp").forward(request, response);
/*    */       }
/* 46 */       else if (Integer.valueOf(operation).intValue() == 2)
/*    */       {
/* 48 */         cDAO.DeleteComments(Integer.valueOf(id).intValue());
/*    */         
/* 50 */         CommentsDAO ccDAO = new CommentsDAO();
/* 51 */         List<Comments> c = new ArrayList();
/* 52 */         c = ccDAO.getAllComments();
/* 53 */         if (c.size() == 0) {
/* 54 */           request.setAttribute("msg", "Nothing here.");
/*    */         } else {
/* 56 */           request.setAttribute("comment", c);
/*    */         }
/* 58 */         request.getRequestDispatcher("admin/Comments.jsp").forward(request, response);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {}
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\servlet\AdminCommentServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */