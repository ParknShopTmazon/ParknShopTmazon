/*    */ package admin.servlet;
/*    */ 
/*    */ import admin.dao.ConsigneeDAO;
/*    */ import admin.entity.Consigneeinfo;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ public class ConsigneeServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 20 */     request.setCharacterEncoding("UTF-8");
/* 21 */     String id = request.getParameter("id");
/*    */     
/* 23 */     ConsigneeDAO cDAO = new ConsigneeDAO();
/* 24 */     List<Consigneeinfo> c = new ArrayList();
/* 25 */     c = cDAO.getAnyConsignees(Integer.valueOf(id).intValue());
/*    */     
/* 27 */     request.setAttribute("consignee", c);
/* 28 */     request.getRequestDispatcher("admin/Consignee.jsp").forward(request, response);
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {}
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\servlet\ConsigneeServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */