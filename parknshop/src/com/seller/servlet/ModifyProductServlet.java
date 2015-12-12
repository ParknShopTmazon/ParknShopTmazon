/*    */ package com.seller.servlet;
/*    */ 
/*    */ import com.seller.service.ProductService;
/*    */ import com.seller.service.ShopproductService;
/*    */ import java.io.IOException;
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
/*    */ public class ModifyProductServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   public void destroy()
/*    */   {
/* 26 */     super.destroy();
/*    */   }
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
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {}
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
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 60 */     int mID = Integer.parseInt(request.getParameter("mid"));
/* 61 */     double mPrice = Double.parseDouble(request.getParameter("mprice"));
/* 62 */     int mStock = Integer.parseInt(request.getParameter("mstock"));
/*    */     
/* 64 */     ProductService ps = new ProductService();
/* 65 */     ps.modifyproduct(mID, mPrice);
/*    */     
/* 67 */     ShopproductService sds = new ShopproductService();
/* 68 */     sds.modify(mID, mPrice, mStock);
/*    */     
/* 70 */     response.sendRedirect("../seller/ku_list.jsp");
/*    */   }
/*    */   
/*    */   public void init()
/*    */     throws ServletException
/*    */   {}
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\com\seller\servlet\ModifyProductServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */