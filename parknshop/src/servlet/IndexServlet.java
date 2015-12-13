/*     */ package servlet;
/*     */ 
/*     */ import interface_impl.IndexInterface_impl;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import javax.servlet.RequestDispatcher;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import servlethelp.Animation;
/*     */ import servlethelp.BestSell;
/*     */ import servlethelp.ProductsNameChange;
/*     */ import vo.Picture;
/*     */ import vo.ProductDetail;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IndexServlet
/*     */   extends HttpServlet
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   protected void doGet(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/*  39 */     doPost(request, response);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void doPost(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/*  46 */     System.out.println("session: " + request.getSession().getAttribute("customername"));
/*     */     
/*  48 */     IndexInterface_impl iii = new IndexInterface_impl();
/*     */     
/*  50 */     List<ProductDetail> list = iii.NewProduct();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  58 */     List<ProductDetail> list1 = ProductsNameChange.returnlist(list);
/*     */     
/*  60 */     Animation a = new Animation();
/*  61 */     List<Picture> list2 = a.getImageInformation();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  81 */     List<Picture> list3 = new LinkedList();
/*  82 */     Iterator<Picture> it = list2.iterator();
/*  83 */     int i = 1;
/*  84 */     while (it.hasNext()) {
/*  85 */       Picture pd = (Picture)it.next();
/*  86 */       pd.setNum(i);
/*  87 */       list3.add(pd);
/*  88 */       i++;
/*     */     }
/*  90 */     Picture pd = (Picture)list2.get(0);
/*     */     
/*  92 */     System.out.println("size:" + list2.size());
/*     */     
/*  94 */     request.setAttribute("product_list", list1);
/*  95 */     request.setAttribute("picture_list", list3);
/*  96 */     System.out.println("size:" + list3.size());
/*  97 */     request.setAttribute("picture_help", pd);
/*  98 */     request.setAttribute("picture_size", Integer.valueOf(list3.size()));
/*  99 */     BestSell.addbestsell(request, response);
/* 100 */     request.getRequestDispatcher("index.jsp").forward(request, response);
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlet\IndexServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */