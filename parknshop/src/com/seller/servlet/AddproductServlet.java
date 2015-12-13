/*     */ package com.seller.servlet;
/*     */ 
/*     */ import com.seller.fileoperate.FileOperate;
/*     */ import com.seller.service.ProductService;
/*     */ import com.seller.service.ShopproductService;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.List;
/*     */ import javax.servlet.ServletContext;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.fileupload.FileItem;
/*     */ import org.apache.commons.fileupload.FileUploadException;
/*     */ import org.apache.commons.fileupload.disk.DiskFileItemFactory;
/*     */ import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
/*     */ public class AddproductServlet
/*     */   extends HttpServlet
/*     */ {
/*     */   public void destroy()
/*     */   {
/*  38 */     super.destroy();
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
/*  55 */     response.setContentType("text/html");
/*  56 */     PrintWriter out = response.getWriter();
/*  57 */     out
/*  58 */       .println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
/*  59 */     out.println("<HTML>");
/*  60 */     out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
/*  61 */     out.println("  <BODY>");
/*  62 */     out.print("    This is ");
/*  63 */     out.print(getClass());
/*  64 */     out.println(", using the GET method");
/*  65 */     out.println("  </BODY>");
/*  66 */     out.println("</HTML>");
/*  67 */     out.flush();
/*  68 */     out.close();
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
/*  84 */     int shopid = Integer.parseInt(request.getParameter("sid").trim());
/*  85 */     int typeId = Integer.parseInt(request.getParameter("typeId").trim());
/*  86 */     String productName = request.getParameter("productName");
/*  87 */     int stock = Integer.parseInt(request.getParameter("stock"));
/*  88 */     String description = request.getParameter("description");
/*  89 */     double price = Double.parseDouble(request.getParameter("price").trim());
/*     */     
/*  91 */     ProductService ps = new ProductService();
/*  92 */     ps.addpd_part(typeId, productName, description, price);
/*     */     
/*     */ 
/*  95 */     int Pid = ps.selectByName(productName);
/*     */     
/*     */ 
/*  98 */     ShopproductService sp = new ShopproductService();
/*  99 */     sp.addinfo(shopid, Pid, stock, price);
/*     */     
/*     */ 
/* 102 */     DiskFileItemFactory factory = new DiskFileItemFactory();
/*     */     
/* 104 */     String path = getServletContext().getRealPath("/upload");
/*     */     
/*     */ 
/* 107 */     String newpath = path + "\\" + shopid + "\\" + String.valueOf(Pid);
/* 108 */     FileOperate.newFolder(newpath);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 117 */     factory.setRepository(new File(path));
/*     */     
/*     */ 
/* 120 */     factory.setSizeThreshold(1048576);
/*     */     
/*     */ 
/* 123 */     ServletFileUpload upload = new ServletFileUpload(factory);
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 128 */       List<FileItem> list = upload.parseRequest(request);
/*     */       
/* 130 */       for (FileItem item : list)
/*     */       {
/*     */ 
/* 133 */         String name = item.getFieldName();
/*     */         
/*     */ 
/* 136 */         if (item.isFormField())
/*     */         {
/*     */ 
/* 139 */           String value = item.getString();
/*     */           
/* 141 */           request.setAttribute(name, value);
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*     */ 
/* 150 */           String value = item.getName();
/*     */           
/* 152 */           int start = value.lastIndexOf("\\");
/*     */           
/* 154 */           String filename = value.substring(start + 1);
/*     */           
/* 156 */           request.setAttribute(name, filename);
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 164 */           OutputStream out = new FileOutputStream(new File(newpath, filename));
/* 165 */           String lujin = "upload/" + shopid + "/" + Pid + "/" + filename;
/*     */           
/* 167 */           ps.addpd_rest(Pid, lujin);
/*     */           
/* 169 */           InputStream in = item.getInputStream();
/*     */           
/* 171 */           int length = 0;
/* 172 */           byte[] buf = new byte['Ѐ'];
/*     */           
/* 174 */           System.out.println("获取上传文件的总共的容量：" + item.getSize());
/*     */           
/*     */ 
/* 177 */           while ((length = in.read(buf)) != -1)
/*     */           {
/*     */ 
/* 180 */             out.write(buf, 0, length);
/*     */           }
/*     */           
/* 183 */           in.close();
/* 184 */           out.close();
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (FileUploadException e) {
/* 189 */       e.printStackTrace();
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 196 */     response.sendRedirect("../seller/add_ku_from.jsp");
/*     */   }
/*     */   
/*     */   public void init()
/*     */     throws ServletException
/*     */   {}
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\com\seller\servlet\AddproductServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */