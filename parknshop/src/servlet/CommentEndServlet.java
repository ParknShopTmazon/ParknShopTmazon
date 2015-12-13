/*    */ package servlet;
/*    */ 
/*    */ import interface_impl.CommentInterface_impl;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommentEndServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 30 */     doPost(request, response);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 38 */     String level = request.getParameter("level");
/* 39 */     String comment = request.getParameter("commenttext");
/* 40 */     String order_id = request.getParameter("order_id");
/* 41 */     System.out.println(level + comment + order_id);
/*    */     
/* 43 */     CommentInterface_impl cii = new CommentInterface_impl();
/* 44 */     cii.usercomment(Integer.parseInt(order_id), comment, Integer.parseInt(level));
/*    */     
/* 46 */     request.getRequestDispatcher("MyHomeServlet").forward(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\CommentEndServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */