/*    */ package admin.servlet;
/*    */ 
/*    */ import admin.dao.ShopDAO;
/*    */ import admin.entity.Productinfo;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ public class ProductsServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 20 */     request.setCharacterEncoding("UTF-8");
/* 21 */     String id = request.getParameter("id");
/*    */     
/* 23 */     ShopDAO cDAO = new ShopDAO();
/* 24 */     List<Productinfo> c = new ArrayList();
/* 25 */     c = cDAO.getAllProducts(Integer.valueOf(id).intValue());
/*    */     
/* 27 */     if (c.size() == 0)
/*    */     {
/* 29 */       request.setAttribute("msg", "Nothing here.");
/* 30 */       request.setAttribute("product", c);
/*    */     }
/*    */     else {
/* 33 */       request.setAttribute("product", c);
/*    */     }
/* 35 */     request.getRequestDispatcher("admin/Products.jsp").forward(request, response);
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {}
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\servlet\ProductsServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */