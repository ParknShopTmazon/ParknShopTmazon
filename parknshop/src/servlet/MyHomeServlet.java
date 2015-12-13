/*    */ package servlet;
/*    */ 
/*    */ import interface_impl.MyFavoriteProductsInterface_impl;
/*    */ import interface_impl.PurchasedProductsInterface_impl;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import vo.NewPurchase;
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
/*    */ public class MyHomeServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 35 */     doPost(request, response);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 43 */     String divtype = request.getParameter("divtype") != null ? request.getParameter("divtype") : "1";
/* 44 */     String customername = (String)request.getSession().getAttribute("customername");
/* 45 */     request.setAttribute("divtype", divtype);
/*    */     
/* 47 */     PurchasedProductsInterface_impl ppi = new PurchasedProductsInterface_impl();
/* 48 */     List<NewPurchase> list1 = ppi.returnPurchasedProductlist(customername);
/*    */     
/* 50 */     request.setAttribute("abc_list", list1);
/*    */     
/* 52 */     MyFavoriteProductsInterface_impl mfpi = new MyFavoriteProductsInterface_impl();
/* 53 */     List<ProductDetail> list2 = mfpi.returnmyfavoritelist(customername);
/*    */     
/* 55 */     request.setAttribute("myfavorite_list", list2);
/*    */     
/* 57 */     request.getRequestDispatcher("my_home.jsp").forward(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\MyHomeServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */