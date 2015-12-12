/*    */ package servlet;
/*    */ 
/*    */ import interface_impl.MyOrderInterface_impl;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
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
/*    */ public class MyOrderServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 32 */     doPost(request, response);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 41 */     String order_id = request.getParameter("order_id") != null ? request.getParameter("order_id") : "";
/* 42 */     String order_state = request.getParameter("order_state") != null ? request.getParameter("order_state") : "";
/* 43 */     if (order_state.equals("1"))
/* 44 */       order_state = "Paid";
/* 45 */     if (order_state.equals("2"))
/* 46 */       order_state = "Shipped";
/* 47 */     if (order_state.equals("3"))
/* 48 */       order_state = "Not receiving";
/* 49 */     if (order_state.equals("4"))
/* 50 */       order_state = "No comment";
/* 51 */     if (order_state.equals("5")) {
/* 52 */       order_state = "Have comments";
/*    */     }
/*    */     
/* 55 */     MyOrderInterface_impl moi = new MyOrderInterface_impl();
/* 56 */     ProductDetail pd = moi.returndetail(Integer.parseInt(order_id));
/* 57 */     String address = moi.returndeliveryaddress(Integer.parseInt(order_id));
/* 58 */     String shopname = moi.returnshopname(Integer.parseInt(order_id));
/* 59 */     double totalprice = moi.returntotalprice(Integer.parseInt(order_id));
/*    */     
/* 61 */     request.setAttribute("address", address);
/* 62 */     request.setAttribute("order_id", order_id);
/* 63 */     request.setAttribute("shopname", shopname);
/* 64 */     request.setAttribute("order_state", order_state);
/* 65 */     request.setAttribute("product_id", Integer.valueOf(pd.getProduct_ID()));
/* 66 */     request.setAttribute("product_img_url", pd.getProduct_img_url());
/* 67 */     request.setAttribute("product_description", pd.getProduct_description());
/* 68 */     request.setAttribute("product_price", Double.valueOf(pd.getProduct_price()));
/* 69 */     request.setAttribute("total_price", Double.valueOf(totalprice));
/*    */     
/* 71 */     request.getRequestDispatcher("my_order.jsp").forward(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\MyOrderServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */