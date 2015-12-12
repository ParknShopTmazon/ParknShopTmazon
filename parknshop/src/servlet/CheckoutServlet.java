/*    */ package servlet;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import servlethelp.BestSell;
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
/*    */ public class CheckoutServlet
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
/* 38 */     BestSell.addbestsell(request, response);
/* 39 */     String product_id_all = request.getParameter("product_id_all") != null ? request.getParameter("product_id_all") : "";
/* 40 */     String product_quantity_all = request.getParameter("product_quantity_all") != null ? request.getParameter("product_quantity_all") : "";
/* 41 */     String total_price = request.getParameter("total_price") != null ? request.getParameter("total_price") : "";
/* 42 */     request.setAttribute("product_id_all", product_id_all);
/* 43 */     request.setAttribute("product_quantity_all", product_quantity_all);
/* 44 */     request.setAttribute("total_price", total_price);
/* 45 */     request.getRequestDispatcher("check_out.jsp").forward(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\CheckoutServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */