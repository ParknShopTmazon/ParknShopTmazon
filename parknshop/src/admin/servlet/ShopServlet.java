/*    */ package admin.servlet;
/*    */ 
/*    */ import admin.dao.ShopDAO;
/*    */ import admin.entity.Shopinfo;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShopServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 22 */     request.setCharacterEncoding("UTF-8");
/* 23 */     String operation = request.getParameter("operation");
/* 24 */     String id = request.getParameter("id");
/*    */     
/* 26 */     if (operation == null)
/*    */     {
/* 28 */       ShopDAO cDAO = new ShopDAO();
/* 29 */       List<Shopinfo> c = new ArrayList();
/* 30 */       c = cDAO.getAnyShops(Integer.valueOf(id).intValue());
/*    */       
/* 32 */       request.setAttribute("shop", c);
/*    */     }
/*    */     else
/*    */     {
/* 36 */       ShopDAO cDAO = new ShopDAO();
/* 37 */       if (Integer.valueOf(operation).intValue() == 0)
/*    */       {
/* 39 */         cDAO.ApproveShop(Integer.valueOf(id).intValue());
/*    */       }
/* 41 */       else if (Integer.valueOf(operation).intValue() == 1)
/*    */       {
/* 43 */         cDAO.NormalizeShop(Integer.valueOf(id).intValue());
/*    */       }
/* 45 */       else if (Integer.valueOf(operation).intValue() == 2)
/*    */       {
/* 47 */         cDAO.RefuseShop(Integer.valueOf(id).intValue());
/*    */       }
/*    */       
/* 50 */       List<Shopinfo> c = new ArrayList();
/* 51 */       c = cDAO.getAnyShops(Integer.valueOf(id).intValue());
/*    */       
/* 53 */       request.setAttribute("shop", c);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 58 */     request.getRequestDispatcher("admin/Shop.jsp").forward(request, response);
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {}
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\servlet\ShopServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */