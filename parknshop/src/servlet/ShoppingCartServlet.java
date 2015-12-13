/*    */ package servlet;
/*    */ 
/*    */ import interface_impl.ShoppingCartInterface_impl;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import servlethelp.BestSell;
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
/*    */ public class ShoppingCartServlet
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 59 */     String customername = (String)request.getSession().getAttribute("customername");
/* 60 */     ShoppingCartInterface_impl sci = new ShoppingCartInterface_impl();
/*    */     
/*    */ 
/* 63 */     List<ShoppingCart> list = sci.returncartlist(customername);
/*    */     
/* 65 */     request.setAttribute("product_list", list);
/* 66 */     BestSell.addbestsell(request, response);
/* 67 */     request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\ShoppingCartServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */