/*    */ package seller.servlet;
/*    */ 
/*    */ import seller.service.ProductService;
/*    */// import seller.service.ShopproductService;

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
/* 60 */	String ShopName=(String)request.getParameter("Shop Name");
            String ProductName=(String)request.getParameter("Product Name");
            String ProductPrice=(String)request.getParameter("Product Price");
            String Remark=(String)request.getParameter("Remark");
            String productid=(String)request.getParameter("Product Id");

             //	System.out.println(ShopName);
             ProductService ps=new ProductService();
             ps.modifyproduct(productid,ProductPrice);
/* 70 */     response.sendRedirect("product list.jsp");
/*    */   }
/*    */   
/*    */   public void init()
/*    */     throws ServletException
/*    */   {}
/*    */ }

