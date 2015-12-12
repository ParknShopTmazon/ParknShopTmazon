/*    */ package servlet;
/*    */ 
/*    */ import interface_impl.CheckoutInterface_impl;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import vo.ShoppingCart;
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
/*    */ public class CheckoutEndServlet
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
/* 43 */     String customername = (String)request.getSession().getAttribute("customername");
/* 44 */     String product_id_all = request.getParameter("product_id_all") != null ? request.getParameter("product_id_all") : "";
/* 45 */     String product_quantity_all = request.getParameter("product_quantity_all") != null ? request.getParameter("product_quantity_all") : "";
/*    */     
/* 47 */     double useraccount = Double.parseDouble(request.getParameter("useraccount"));
/* 48 */     String receivename = request.getParameter("receivename") != null ? request.getParameter("receivename") : "";
/* 49 */     String receiveaddress = request.getParameter("receiveaddress") != null ? request.getParameter("receiveaddress") : "";
/* 50 */     String receivecity = request.getParameter("receivecity") != null ? request.getParameter("receivecity") : "";
/* 51 */     String receivecountry = request.getParameter("receivecountry") != null ? request.getParameter("receivecountry") : "";
/* 52 */     String receiveemail = request.getParameter("receiveemail") != null ? request.getParameter("receiveemail") : "";
/* 53 */     String receivephone = request.getParameter("receivephone") != null ? request.getParameter("receivephone") : "";
/* 54 */     System.out.println(customername + product_id_all + product_quantity_all);
/* 55 */     String[] list1 = product_id_all.split(",");
/* 56 */     String[] list2 = product_quantity_all.split(",");
/*    */     
/* 58 */     List<ShoppingCart> list3 = new LinkedList();
/* 59 */     for (int i = 0; i < list1.length; i++) {
/* 60 */       ShoppingCart sc = new ShoppingCart();
/* 61 */       sc.setProduct_ID(list1[i]);
/* 62 */       sc.setProduct_quantity(Integer.valueOf(list2[i]).intValue());
/* 63 */       list3.add(sc);
/*    */     }
/*    */     
/* 66 */     CheckoutInterface_impl coi = new CheckoutInterface_impl();
/* 67 */     coi.checkout(customername, list3, useraccount, receivename, receiveaddress, receivecity, receivecountry, receiveemail, receivephone);
/* 68 */     request.getRequestDispatcher("IndexServlet").forward(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\CheckoutEndServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */