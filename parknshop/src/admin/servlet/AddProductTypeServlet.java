/*    */ package admin.servlet;
/*    */ 
/*    */ import admin.dao.ProductTypeDAO;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ public class AddProductTypeServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {}
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 22 */     request.setCharacterEncoding("UTF-8");
/*    */     
/* 24 */     String NewType = request.getParameter("NewType");
/*    */     
/* 26 */     if (NewType == "")
/*    */     {
/* 28 */       request.setAttribute("msg", "Backup Seccessful");
/*    */     }
/*    */     else
/*    */     {
/* 32 */       ProductTypeDAO p = new ProductTypeDAO();
/* 33 */       int ans = p.AddTypes(NewType);
/*    */       
/* 35 */       if (ans < 0)
/*    */       {
/* 37 */         ans = 0 - ans;
/* 38 */         request.setAttribute("msg", "Backup Seccessful");
/*    */       }
/* 40 */       else if (ans == 0)
/*    */       {
/* 42 */         request.setAttribute("msg", "Backup Seccessful.");
/*    */       }
/*    */       else
/*    */       {
/* 46 */         request.setAttribute("msg", "Backup Seccessful" + ans);
/*    */       }
/*    */     }
/*    */     
/* 50 */     request.getRequestDispatcher("admin/AddProductType.jsp").forward(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\servlet\AddProductTypeServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */