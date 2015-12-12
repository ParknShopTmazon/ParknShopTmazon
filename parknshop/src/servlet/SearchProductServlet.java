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
/*    */ public class SearchProductServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 34 */     doPost(request, response);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 41 */     IndexInterface_impl iii = new IndexInterface_impl();
/* 42 */     String keyword = request.getParameter("keyword");
/* 43 */     List<ProductDetail> list = iii.SearchProduct(keyword);
/*    */     
/* 45 */     List<ProductDetail> list1 = ProductsNameChange.returnlist(list);
/*    */     
/* 47 */     request.setAttribute("product_list", list1);
/* 48 */     BestSell.addbestsell(request, response);
/* 49 */     request.getRequestDispatcher("search_products.jsp").forward(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\SearchProductServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */