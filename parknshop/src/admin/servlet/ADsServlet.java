/*     */ package admin.servlet;
/*     */ 
/*     */ import admin.dao.ADDAO;
/*     */ import admin.dao.ProductDAO;
/*     */ import admin.entity.ADs;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.servlet.RequestDispatcher;
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
/*     */ public class ADsServlet
/*     */   extends HttpServlet
/*     */ {
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/*  31 */     request.setCharacterEncoding("UTF-8");
/*     */     
/*  33 */     ADDAO a = new ADDAO();
/*  34 */     List<ADs> c = new ArrayList();
/*  35 */     c = a.getAllADs();
/*  36 */     if (c.size() == 0) {
/*  37 */       request.setAttribute("msg", "Nothing here.");
/*     */     } else {
/*  39 */       request.setAttribute("ads", c);
/*     */     }
/*  41 */     request.getRequestDispatcher("admin/ADs.jsp").forward(request, response);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/*  50 */     request.setCharacterEncoding("UTF-8");
/*     */     
/*  52 */     String Type = request.getParameter("Type");
/*  53 */     String ProductID = request.getParameter("ProductID");
/*  54 */     String URL = request.getParameter("URL");
/*     */     
/*     */ 
/*     */ 
/*  58 */     ADDAO a = new ADDAO();
/*     */     
/*  60 */     if (Integer.valueOf(Type).intValue() == 1)
/*     */     {
/*  62 */       if (ProductID == "")
/*     */       {
/*  64 */         request.setAttribute("msg1", "You must input both of productID and picture.");
/*  65 */         request.getRequestDispatcher("admin/AddADs.jsp").forward(request, response);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  70 */         DiskFileItemFactory factory = new DiskFileItemFactory();
/*  71 */         String path = getServletContext().getRealPath("/ads");
/*  72 */         String newpath = path;
/*  73 */         factory.setRepository(new File(path));
/*  74 */         factory.setSizeThreshold(1048576);
/*  75 */         ServletFileUpload upload = new ServletFileUpload(factory);
/*     */         try
/*     */         {
/*  78 */           List<FileItem> list = upload.parseRequest(request);
/*     */           
/*     */ 
/*  81 */           for (FileItem item : list)
/*     */           {
/*  83 */             String name = item.getFieldName();
/*  84 */             if (item.isFormField())
/*     */             {
/*  86 */               String value = item.getString();
/*  87 */               if (value == "")
/*     */               {
/*  89 */                 request.setAttribute("msg1", "You must upload the picture.");
/*  90 */                 request.getRequestDispatcher("admin/AddADs.jsp").forward(request, response);
/*     */               }
/*  92 */               request.setAttribute(name, value);
/*     */             }
/*     */             else
/*     */             {
/*  96 */               String value = item.getName();
/*  97 */               if (value == "")
/*     */               {
/*  99 */                 request.setAttribute("msg1", "You must upload the picture.");
/* 100 */                 request.getRequestDispatcher("admin/AddADs.jsp").forward(request, response);
/*     */               }
/*     */               
/* 103 */               int start = value.lastIndexOf("\\");
/* 104 */               String filename = value.substring(start + 1);
/*     */               
/* 106 */               request.setAttribute(name, filename);
/*     */               
/* 108 */               OutputStream out = new FileOutputStream(new File(newpath, filename));
/* 109 */               String lujing = "ads/" + filename;
/*     */               
/*     */ 
/* 112 */               if (ProductID.matches("[0-9]*"))
/*     */               {
/* 114 */                 ProductDAO p = new ProductDAO();
/* 115 */                 if (ProductID.length() > 10)
/*     */                 {
/* 117 */                   request.setAttribute("msg1", "No such Products.");
/* 118 */                   request.getRequestDispatcher("admin/AddADs.jsp").forward(request, response);
/*     */                 }
/* 120 */                 else if (p.getAnyProducts(ProductID).size() == 0)
/*     */                 {
/* 122 */                   request.setAttribute("msg1", "No such Products.");
/* 123 */                   request.getRequestDispatcher("admin/AddADs.jsp").forward(request, response);
/*     */                 }
/*     */                 else
/*     */                 {
/* 127 */                   a.AddProductAD(ProductID, lujing);
/*     */                   
/* 129 */                   List<ADs> c = new ArrayList();
/* 130 */                   c = a.getAllADs();
/* 131 */                   if (c.size() == 0) {
/* 132 */                     request.setAttribute("msg", "Nothing here.");
/*     */                   } else
/* 134 */                     request.setAttribute("ads", c);
/* 135 */                   request.getRequestDispatcher("admin/ADs.jsp").forward(request, response);
/*     */                 }
/*     */                 
/*     */               }
/*     */               else
/*     */               {
/* 141 */                 request.setAttribute("msg1", "Your productID must be numbers.");
/* 142 */                 request.getRequestDispatcher("admin/AddADs.jsp").forward(request, response);
/*     */               }
/*     */               
/*     */ 
/*     */ 
/* 147 */               InputStream in = item.getInputStream();
/* 148 */               int length = 0;
/* 149 */               byte[] buf = new byte['Ѐ'];
/* 150 */               while ((length = in.read(buf)) != -1)
/* 151 */                 out.write(buf, 0, length);
/* 152 */               in.close();
/* 153 */               out.close();
/*     */             }
/*     */           }
/*     */           
/* 157 */           List<ADs> c = new ArrayList();
/* 158 */           c = a.getAllADs();
/* 159 */           if (c.size() == 0) {
/* 160 */             request.setAttribute("msg", "Nothing here.");
/*     */           } else {
/* 162 */             request.setAttribute("ads", c);
/*     */           }
/* 164 */           request.getRequestDispatcher("admin/ADs.jsp").forward(request, response);
/*     */ 
/*     */         }
/*     */         catch (FileUploadException e)
/*     */         {
/* 169 */           e.printStackTrace();
/*     */ 
/*     */ 
/*     */         }
/*     */         catch (Exception localException) {}
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 179 */     else if (Integer.valueOf(Type).intValue() == 2)
/*     */     {
/*     */ 
/* 182 */       DiskFileItemFactory factory = new DiskFileItemFactory();
/* 183 */       String path = getServletContext().getRealPath("/ads");
/* 184 */       String newpath = path;
/*     */       
/* 186 */       factory.setRepository(new File(path));
/* 187 */       factory.setSizeThreshold(1048576);
/* 188 */       ServletFileUpload upload = new ServletFileUpload(factory);
/*     */       try
/*     */       {
/* 191 */         List<FileItem> list = upload.parseRequest(request);
/*     */         
/*     */ 
/* 194 */         for (FileItem item : list)
/*     */         {
/* 196 */           String name = item.getFieldName();
/* 197 */           if (item.isFormField())
/*     */           {
/* 199 */             String value = item.getString();
/* 200 */             if (value == "")
/*     */             {
/* 202 */               request.setAttribute("msg2", "You must upload the picture.");
/* 203 */               request.getRequestDispatcher("admin/AddADs.jsp").forward(request, response);
/*     */             }
/* 205 */             request.setAttribute(name, value);
/*     */           }
/*     */           else
/*     */           {
/* 209 */             String value = item.getName();
/*     */             
/* 211 */             if (value == "")
/*     */             {
/* 213 */               request.setAttribute("msg2", "You must upload the picture.");
/* 214 */               request.getRequestDispatcher("admin/AddADs.jsp").forward(request, response);
/*     */             }
/*     */             
/* 217 */             int start = value.lastIndexOf("\\");
/* 218 */             String filename = value.substring(start + 1);
/*     */             
/* 220 */             request.setAttribute(name, filename);
/*     */             
/* 222 */             OutputStream out = new FileOutputStream(new File(newpath, filename));
/* 223 */             String lujing = "ads/" + filename;
/*     */             
/* 225 */             a.AddImageAD(lujing);
/*     */             
/* 227 */             InputStream in = item.getInputStream();
/* 228 */             int length = 0;
/* 229 */             byte[] buf = new byte['Ѐ'];
/*     */             
/* 231 */             while ((length = in.read(buf)) != -1)
/* 232 */               out.write(buf, 0, length);
/* 233 */             in.close();
/* 234 */             out.close();
/*     */           }
/*     */         }
/*     */         
/* 238 */         List<ADs> c = new ArrayList();
/* 239 */         c = a.getAllADs();
/* 240 */         if (c.size() == 0) {
/* 241 */           request.setAttribute("msg", "Nothing here.");
/*     */         } else {
/* 243 */           request.setAttribute("ads", c);
/*     */         }
/* 245 */         request.getRequestDispatcher("admin/ADs.jsp").forward(request, response);
/*     */ 
/*     */       }
/*     */       catch (FileUploadException e)
/*     */       {
/* 250 */         e.printStackTrace();
/*     */ 
/*     */ 
/*     */       }
/*     */       catch (Exception localException1) {}
/*     */ 
/*     */     }
/* 257 */     else if (Integer.valueOf(Type).intValue() == 3)
/*     */     {
/* 259 */       if (URL == "")
/*     */       {
/* 261 */         request.setAttribute("msg3", "You must input both of picture and url.");
/* 262 */         request.getRequestDispatcher("admin/AddADs.jsp").forward(request, response);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 267 */         DiskFileItemFactory factory = new DiskFileItemFactory();
/* 268 */         String path = getServletContext().getRealPath("/ads");
/* 269 */         String newpath = path;
/* 270 */         factory.setRepository(new File(path));
/* 271 */         factory.setSizeThreshold(1048576);
/* 272 */         ServletFileUpload upload = new ServletFileUpload(factory);
/*     */         try
/*     */         {
/* 275 */           List<FileItem> list = upload.parseRequest(request);
/*     */           
/*     */ 
/* 278 */           for (FileItem item : list)
/*     */           {
/* 280 */             String name = item.getFieldName();
/* 281 */             if (item.isFormField())
/*     */             {
/* 283 */               String value = item.getString();
/* 284 */               if (value == "")
/*     */               {
/* 286 */                 request.setAttribute("msg3", "You must upload the picture.");
/* 287 */                 request.getRequestDispatcher("admin/AddADs.jsp").forward(request, response);
/*     */               }
/* 289 */               request.setAttribute(name, value);
/*     */             }
/*     */             else
/*     */             {
/* 293 */               String value = item.getName();
/*     */               
/* 295 */               if (value == "")
/*     */               {
/* 297 */                 request.setAttribute("msg3", "You must upload the picture.");
/* 298 */                 request.getRequestDispatcher("admin/AddADs.jsp").forward(request, response);
/*     */               }
/* 300 */               int start = value.lastIndexOf("\\");
/* 301 */               String filename = value.substring(start + 1);
/*     */               
/* 303 */               request.setAttribute(name, filename);
/*     */               
/* 305 */               OutputStream out = new FileOutputStream(new File(newpath, filename));
/* 306 */               String lujing = "ads/" + filename;
/*     */               
/* 308 */               a.AddLinkAD(lujing, URL);
/*     */               
/* 310 */               InputStream in = item.getInputStream();
/* 311 */               int length = 0;
/* 312 */               byte[] buf = new byte['Ѐ'];
/*     */               
/* 314 */               while ((length = in.read(buf)) != -1)
/* 315 */                 out.write(buf, 0, length);
/* 316 */               in.close();
/* 317 */               out.close();
/*     */             }
/*     */           }
/*     */           
/* 321 */           List<ADs> c = new ArrayList();
/* 322 */           c = a.getAllADs();
/* 323 */           if (c.size() == 0) {
/* 324 */             request.setAttribute("msg", "Nothing here.");
/*     */           } else {
/* 326 */             request.setAttribute("ads", c);
/*     */           }
/* 328 */           request.getRequestDispatcher("admin/ADs.jsp").forward(request, response);
/*     */ 
/*     */         }
/*     */         catch (FileUploadException e)
/*     */         {
/* 333 */           e.printStackTrace();
/*     */         }
/*     */         catch (Exception localException2) {}
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\servlet\ADsServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */