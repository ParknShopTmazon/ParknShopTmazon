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
/*    */ import servlethelp.BestSell;
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
/*    */ 
/*    */ public class ProductDetailServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 39 */     doPost(request, response);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 47 */     String product_ID = request.getParameter("product_ID") != null ? request.getParameter("product_ID") : "";
/*    */     
/* 49 */     ProductDetail_Impl pdi = new ProductDetail_Impl();
/* 50 */     ProductDetail pd = pdi.searchproductdetail(Integer.parseInt(product_ID));
/*    */     
/* 52 */     CommentInterface_impl cii = new CommentInterface_impl();
/*    */     
/* 54 */     request.setAttribute("product_id", Integer.valueOf(pd.getProduct_ID()));
/* 55 */     request.setAttribute("product_name", pd.getProduct_name());
/* 56 */     request.setAttribute("product_img_url", pd.getProduct_img_url());
/* 57 */     request.setAttribute("product_price", Double.valueOf(pd.getProduct_price()));
/* 58 */     request.setAttribute("product_availability", "In Stock");
/* 59 */     request.setAttribute("product_model", "Product 14");
/* 60 */     request.setAttribute("product_manufacturer", "Apple");
/* 61 */     request.setAttribute("product_description", pd.getProduct_description());
/*    */     
/* 63 */     BestSell.addbestsell(request, response);
/*    */     
/* 65 */     List<Comment> list = cii.returncommentlistbyproductid(Integer.parseInt(product_ID));
/* 66 */     List<NewComment> list2 = new LinkedList();
/*    */     try
/*    */     {
/* 69 */       list2 = changecommentlist(list);
/*    */     }
/*    */     catch (Exception e) {
/* 72 */       System.out.println("comment list error!");
/* 73 */       System.out.println(e);
/*    */     }
/*    */     
/* 76 */     request.setAttribute("comment_list", list2);
/* 77 */     request.getRequestDispatcher("about_product.jsp").forward(request, response);
/*    */   }
/*    */   
/*    */   public List<NewComment> changecommentlist(List<Comment> list1) {
/* 81 */     List<NewComment> list2 = new LinkedList();
/* 82 */     Iterator<Comment> it = list1.iterator();
/* 83 */     while (it.hasNext()) {
/* 84 */       Comment c = (Comment)it.next();
/* 85 */       NewComment cl = new NewComment();
/* 86 */       cl.setCustomername(c.getCustomerName());
/* 87 */       cl.setLevel(c.getComment());
/* 88 */       cl.setTime(c.getTime().toString());
/* 89 */       list2.add(cl);
/*    */     }
/* 91 */     return list2;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\ProductDetailServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */