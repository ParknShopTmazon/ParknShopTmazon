/*    */ package servlet;
/*    */ 
/*    */ import interface_impl.CommentInterface_impl;
/*    */ import interface_impl.ProductDetail_Impl;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.sql.Date;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import vo.Comment;
/*    */ import vo.NewComment;
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
/*    */ public class CommentServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 37 */     doPost(request, response);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 44 */     String order_id = request.getParameter("order_id") != null ? request.getParameter("order_id") : "";
/* 45 */     String product_id = request.getParameter("product_id") != null ? request.getParameter("product_id") : "";
/* 46 */     System.out.println(order_id + product_id);
/*    */     
/* 48 */     CommentInterface_impl cii = new CommentInterface_impl();
/* 49 */     List<Comment> list1 = cii.returncommentlistbyproductid(Integer.parseInt(product_id));
/*    */     
/* 51 */     ProductDetail_Impl pdi = new ProductDetail_Impl();
/* 52 */     ProductDetail pd = pdi.searchproductdetail(Integer.parseInt(product_id));
/*    */     
/* 54 */     request.setAttribute("product_id", Integer.valueOf(pd.getProduct_ID()));
/* 55 */     request.setAttribute("product_name", pd.getProduct_name());
/* 56 */     request.setAttribute("product_img_url", pd.getProduct_img_url());
/* 57 */     request.setAttribute("product_price", Double.valueOf(pd.getProduct_price()));
/* 58 */     request.setAttribute("product_description", pd.getProduct_description());
/*    */     
/* 60 */     List<NewComment> list2 = new LinkedList();
/*    */     try
/*    */     {
/* 63 */       list2 = changecommentlist(list1);
/*    */     }
/*    */     catch (Exception e) {
/* 66 */       System.out.println("comment list error!");
/*    */     }
/*    */     
/* 69 */     request.setAttribute("order_id", order_id);
/* 70 */     request.setAttribute("commentlist", list2);
/*    */     
/* 72 */     request.getRequestDispatcher("comment.jsp").forward(request, response);
/*    */   }
/*    */   
/*    */   public List<NewComment> changecommentlist(List<Comment> list1) {
/* 76 */     List<NewComment> list2 = new LinkedList();
/*    */     
/* 78 */     Iterator<Comment> it = list1.iterator();
/* 79 */     while (it.hasNext()) {
/* 80 */       Comment c = (Comment)it.next();
/* 81 */       NewComment cl = new NewComment();
/* 82 */       cl.setCustomername(c.getCustomerName());
/* 83 */       if (c.getLevel() == 1)
/* 84 */         cl.setLevel("Good");
/* 85 */       if (c.getLevel() == 2)
/* 86 */         cl.setLevel("General");
/* 87 */       if (c.getLevel() == 3)
/* 88 */         cl.setLevel("Bad");
/* 89 */       cl.setTime(c.getTime().toString());
/* 90 */       list2.add(cl);
/*    */     }
/*    */     
/* 93 */     return list2;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\CommentServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */