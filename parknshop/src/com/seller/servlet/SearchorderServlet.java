/*     */ package com.seller.servlet;
/*     */ 
/*     */ import com.seller.service.OrderService;
/*     */ import com.seller.vo.Sendorderinfo;
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
/*     */ public class SearchorderServlet
/*     */   extends HttpServlet
/*     */ {
/*     */   public void destroy()
/*     */   {
/*  28 */     super.destroy();
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
/*  45 */     response.setContentType("text/html");
/*  46 */     PrintWriter out = response.getWriter();
/*  47 */     out
/*  48 */       .println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
/*  49 */     out.println("<HTML>");
/*  50 */     out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
/*  51 */     out.println("  <BODY>");
/*  52 */     out.print("    This is ");
/*  53 */     out.print(getClass());
/*  54 */     out.println(", using the GET method");
/*  55 */     out.println("  </BODY>");
/*  56 */     out.println("</HTML>");
/*  57 */     out.flush();
/*  58 */     out.close();
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
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/*  75 */     String orderid = request.getParameter("OrderId");
/*  76 */     int status = Integer.parseInt(request.getParameter("Status"));
/*  77 */     System.out.println(status);
/*  78 */     int shopid = Integer.parseInt(request.getParameter("hide"));
/*  79 */     String sql = "";
/*  80 */     if ((orderid == null) || (orderid.length() == 0))
/*     */     {
/*  82 */       if (status == 1)
/*     */       {
/*  84 */         sql = 
/*     */         
/*     */ 
/*  87 */           "select c.OrderID,c.TrackingNum,b.ProductName,c.ProductBuyNum,c.OrderTime,d.ConsigneeName,d.ConsigneePhoneNumber,d.ConsigneeAddress,d.ConsigneePostcode,c.CurrentState from shopproduct as a,productinfo as b,userorder as c,consigneeinfo as d WHERE a.ShopInfoID=" + shopid + " and c.ShopProductID=a.ShopProductID and a.ProductID=b.ProductID and c.CurrentState=1 and c.ConsigneeInfoID=d.ConsigneeInfoID";
/*     */       }
/*  89 */       if (status == 3)
/*     */       {
/*  91 */         sql = 
/*     */         
/*     */ 
/*  94 */           "select c.OrderID,c.TrackingNum,b.ProductName,c.ProductBuyNum,c.OrderTime,d.ConsigneeName,d.ConsigneePhoneNumber,d.ConsigneeAddress,d.ConsigneePostcode,c.CurrentState from shopproduct as a,productinfo as b,userorder as c,consigneeinfo as d WHERE a.ShopInfoID=" + shopid + " and c.ShopProductID=a.ShopProductID and a.ProductID=b.ProductID and c.CurrentState=3 and c.ConsigneeInfoID=d.ConsigneeInfoID";
/*     */       }
/*  96 */       if (status == 4)
/*     */       {
/*  98 */         sql = 
/*     */         
/*     */ 
/* 101 */           "select c.OrderID,c.TrackingNum,b.ProductName,c.ProductBuyNum,c.OrderTime,d.ConsigneeName,d.ConsigneePhoneNumber,d.ConsigneeAddress,d.ConsigneePostcode,c.CurrentState from shopproduct as a,productinfo as b,userorder as c,consigneeinfo as d WHERE a.ShopInfoID=" + shopid + " and c.ShopProductID=a.ShopProductID and a.ProductID=b.ProductID and c.CurrentState=4 and c.ConsigneeInfoID=d.ConsigneeInfoID";
/*     */       }
/* 103 */       if (status == 0)
/*     */       {
/* 105 */         sql = 
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
/*     */ 
/*     */ 
/* 127 */           "select c.OrderID,c.TrackingNum,b.ProductName,c.ProductBuyNum,c.OrderTime,d.ConsigneeName,d.ConsigneePhoneNumber,d.ConsigneeAddress,d.ConsigneePostcode,c.CurrentState from shopproduct as a,productinfo as b,userorder as c,consigneeinfo as d WHERE a.ShopInfoID=" + shopid + " and c.ConsigneeInfoID=d.ConsigneeInfoID" + " and c.ShopProductID=a.ShopProductID" + " and a.ProductID=b.ProductID" + " and c.CurrentState=1" + " UNION" + " select c.OrderID,c.TrackingNum,b.ProductName,c.ProductBuyNum,c.OrderTime,d.ConsigneeName,d.ConsigneePhoneNumber,d.ConsigneeAddress,d.ConsigneePostcode,c.CurrentState" + " from shopproduct as a,productinfo as b,userorder as c,consigneeinfo as d" + " WHERE a.ShopInfoID=" + shopid + " and c.ConsigneeInfoID=d.ConsigneeInfoID" + " and c.ShopProductID=a.ShopProductID" + " and a.ProductID=b.ProductID" + " and c.CurrentState=3" + " UNION" + " select c.OrderID,c.TrackingNum,b.ProductName,c.ProductBuyNum,c.OrderTime,d.ConsigneeName,d.ConsigneePhoneNumber,d.ConsigneeAddress,d.ConsigneePostcode,c.CurrentState" + " from shopproduct as a,productinfo as b,userorder as c,consigneeinfo as d" + " WHERE a.ShopInfoID=" + shopid + " and c.ConsigneeInfoID=d.ConsigneeInfoID" + " and c.ShopProductID=a.ShopProductID" + " and a.ProductID=b.ProductID" + " and c.CurrentState=4";
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 132 */       int id = Integer.parseInt(orderid);
/* 133 */       if (status == 1)
/*     */       {
/* 135 */         sql = 
/*     */         
/*     */ 
/* 138 */           "select c.OrderID,c.TrackingNum,b.ProductName,c.ProductBuyNum,c.OrderTime,d.ConsigneeName,d.ConsigneePhoneNumber,d.ConsigneeAddress,d.ConsigneePostcode,c.CurrentState from shopproduct as a,productinfo as b,userorder as c,consigneeinfo as d WHERE a.ShopInfoID=" + shopid + " and c.OrderID=" + id + " and c.ShopProductID=a.ShopProductID and a.ProductID=b.ProductID and c.CurrentState=1 and c.ConsigneeInfoID=d.ConsigneeInfoID";
/*     */       }
/* 140 */       if (status == 3)
/*     */       {
/* 142 */         sql = 
/*     */         
/*     */ 
/* 145 */           "select c.OrderID,c.TrackingNum,b.ProductName,c.ProductBuyNum,c.OrderTime,d.ConsigneeName,d.ConsigneePhoneNumber,d.ConsigneeAddress,d.ConsigneePostcode,c.CurrentState from shopproduct as a,productinfo as b,userorder as c,consigneeinfo as d WHERE a.ShopInfoID=" + shopid + " and c.OrderID=" + id + " and c.ShopProductID=a.ShopProductID and a.ProductID=b.ProductID and c.CurrentState=3 and c.ConsigneeInfoID=d.ConsigneeInfoID";
/*     */       }
/* 147 */       if (status == 4)
/*     */       {
/* 149 */         sql = 
/*     */         
/*     */ 
/* 152 */           "select c.OrderID,c.TrackingNum,b.ProductName,c.ProductBuyNum,c.OrderTime,d.ConsigneeName,d.ConsigneePhoneNumber,d.ConsigneeAddress,d.ConsigneePostcode,c.CurrentState from shopproduct as a,productinfo as b,userorder as c,consigneeinfo as d WHERE a.ShopInfoID=" + shopid + " and c.ShopProductID=a.ShopProductID and a.ProductID=b.ProductID and c.CurrentState=4 and c.ConsigneeInfoID=d.ConsigneeInfoID";
/*     */       }
/*     */       else
/*     */       {
/* 156 */         sql = 
/*     */         
/*     */ 
/* 159 */           "select c.OrderID,c.TrackingNum,b.ProductName,c.ProductBuyNum,c.OrderTime,d.ConsigneeName,d.ConsigneePhoneNumber,d.ConsigneeAddress,d.ConsigneePostcode,c.CurrentState from shopproduct as a,productinfo as b,userorder as c,consigneeinfo as d WHERE a.ShopInfoID=" + shopid + " and c.OrderID=" + id + " and c.ShopProductID=a.ShopProductID and a.ProductID=b.ProductID and c.ConsigneeInfoID=d.ConsigneeInfoID";
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 164 */     OrderService os = new OrderService();
/* 165 */     List<Sendorderinfo> ss = new ArrayList();
/* 166 */     ss = os.search(sql);
/*     */     
/* 168 */     request.setAttribute("soi", ss);
/* 169 */     request.getRequestDispatcher("../seller/sellout.jsp").forward(request, response);
/*     */   }
/*     */   
/*     */   public void init()
/*     */     throws ServletException
/*     */   {}
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\com\seller\servlet\SearchorderServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */