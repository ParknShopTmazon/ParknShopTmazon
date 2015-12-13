/*     */ package com.seller.servlet;
/*     */ 
/*     */ import com.seller.dao.CommentDao;
/*     */ import com.seller.vo.Comments;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.servlet.RequestDispatcher;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShowcommentsServlet
/*     */   extends HttpServlet
/*     */ {
/*     */   public void destroy()
/*     */   {
/*  29 */     super.destroy();
/*     */   }
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
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/*  46 */     response.setContentType("text/html");
/*  47 */     PrintWriter out = response.getWriter();
/*  48 */     out
/*  49 */       .println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
/*  50 */     out.println("<HTML>");
/*  51 */     out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
/*  52 */     out.println("  <BODY>");
/*  53 */     out.print("    This is ");
/*  54 */     out.print(getClass());
/*  55 */     out.println(", using the GET method");
/*  56 */     out.println("  </BODY>");
/*  57 */     out.println("</HTML>");
/*  58 */     out.flush();
/*  59 */     out.close();
/*     */   }
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
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/*  75 */     int shopid = Integer.parseInt(request.getParameter("shopid"));
/*  76 */     int level = Integer.parseInt(request.getParameter("level"));
/*  77 */     String sql = "";
/*  78 */     if (level == 0)
/*     */     {
/*  80 */       sql = 
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  86 */         "select a.Comment,d.ProductName,e.TypeName,a.Time,f.CustomerName from comments as a, userorder as b,shopproduct as c,productinfo as d,producttype as e,consigneeinfo as f where a.OrderID=b.OrderID AND b.ShopProductID=c.ShopProductID and  c.ShopInfoID=" + shopid + " " + "and c.ProductID=d.ProductID " + "and d.ProductTypeID=e.TypeID " + "and b.ConsigneeInfoID=f.ConsigneeInfoID";
/*     */     }
/*     */     
/*  89 */     if (level == 1)
/*     */     {
/*     */ 
/*  92 */       sql = 
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  99 */         "select a.Comment,d.ProductName,e.TypeName,a.Time,f.CustomerName from comments as a, userorder as b,shopproduct as c,productinfo as d,producttype as e,consigneeinfo as f where a.OrderID=b.OrderID AND b.ShopProductID=c.ShopProductID and  c.ShopInfoID=" + shopid + " " + "and c.ProductID=d.ProductID " + "and d.ProductTypeID=e.TypeID " + "and b.ConsigneeInfoID=f.ConsigneeInfoID " + "and a.Level=1";
/*     */     }
/* 101 */     if (level == 2)
/*     */     {
/* 103 */       sql = 
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 110 */         "select a.Comment,d.ProductName,e.TypeName,a.Time,f.CustomerName from comments as a, userorder as b,shopproduct as c,productinfo as d,producttype as e,consigneeinfo as f where a.OrderID=b.OrderID AND b.ShopProductID=c.ShopProductID and  c.ShopInfoID=" + shopid + " " + "and c.ProductID=d.ProductID " + "and d.ProductTypeID=e.TypeID " + "and b.ConsigneeInfoID=f.ConsigneeInfoID " + "and a.Level=2";
/*     */     }
/* 112 */     if (level == 3)
/*     */     {
/* 114 */       sql = 
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 121 */         "select a.Comment,d.ProductName,e.TypeName,a.Time,f.CustomerName from comments as a, userorder as b,shopproduct as c,productinfo as d,producttype as e,consigneeinfo as f where a.OrderID=b.OrderID AND b.ShopProductID=c.ShopProductID and c.ShopInfoID=" + shopid + " " + "and c.ProductID=d.ProductID " + "and d.ProductTypeID=e.TypeID " + "and b.ConsigneeInfoID=f.ConsigneeInfoID " + "and a.Level=3";
/*     */     }
/*     */     
/* 124 */     CommentDao cd = new CommentDao();
/* 125 */     List<Comments> list = new ArrayList();
/* 126 */     System.out.println(sql);
/* 127 */     list = cd.showcomment(sql);
/*     */     
/* 129 */     request.setAttribute("commentlist", list);
/* 130 */     request.getRequestDispatcher("../seller/myRate.jsp").forward(request, response);
/*     */   }
/*     */   
/*     */   public void init()
/*     */     throws ServletException
/*     */   {}
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\com\seller\servlet\ShowcommentsServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */