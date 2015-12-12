/*    */ package servlet;
/*    */ 
/*    */ import interface_impl.IndexInterface_impl;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import servlethelp.BestSell;
/*    */ import servlethelp.ProductsNameChange;
/*    */ import vo.ProductDetail;
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
/*    */ 
/*    */ 
/*    */ public class SearchProductByTypeServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 36 */     doPost(request, response);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 44 */     String type = request.getParameter("type");
/*    */     
/* 46 */     IndexInterface_impl iii = new IndexInterface_impl();
/*    */     
/* 48 */     List<ProductDetail> list = iii.SearchProductByType(Integer.parseInt(type));
/*    */     
/* 50 */     List<ProductDetail> list1 = ProductsNameChange.returnlist(list);
/*    */     
/* 52 */     request.setAttribute("product_list", list1);
/* 53 */     BestSell.addbestsell(request, response);
/* 54 */     request.getRequestDispatcher("search_products.jsp").forward(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\SearchProductByTypeServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */