package com.tmazon.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.tmazon.domain.Shop;
import com.tmazon.domain.User;
import com.tmazon.service.ProductService;
import com.tmazon.service.ShopService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.IOUtil;

public class ModifyShopServlet extends HttpServlet {

private ShopService shopService = BasicFactory.getImpl(ShopService.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
		
		User userId =  (User) session.getAttribute(AttrName.SessionScope.USER);
		if(userId==null){
			resp.sendRedirect("login");
			return;
		}
		
		String shopId=req.getParameter("shopId");
		System.out.println("*******************"+shopId);
		if(!(shopId==null||"".trim().equals(shopId))){
			System.out.println("sdsdsdsddssdsddssd"+shopId);
			req.getSession(true).setAttribute(AttrName.SessionScope.SHOPID,shopId);
		}
		
		int shopOneId = -1;
		try {
			shopOneId=Integer.parseInt(shopId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Shop shop = shopService.findById(shopOneId);
		if(shopOneId!=shop.getShopId()){
			resp.sendRedirect("myshop");
			return;
		}
		req.setAttribute("shopId", shop.getShopId());
		req.setAttribute("picture", shop.getPicture());
		req.setAttribute("name", shop.getName());
		req.setAttribute("type", shop.getType());
		req.setAttribute("status", shop.getStatus());
		req.getRequestDispatcher("/WEB-INF/shopowner/modify_shop.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8"); 
		
		String contextPath = getServletContext().getRealPath(File.separator+"images_shop"+File.separator);
		String uploadPath =File.separator+ "upload"+File.separator;
		String tmpPath = "tmp"+File.separator;
		String path=null;
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();

		fileItemFactory.setSizeThreshold(1024 * 1024*10);
		fileItemFactory.setRepository(new File(contextPath + tmpPath));
		ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
		List<FileItem> items=null;
		try {
			items = servletFileUpload.parseRequest(req);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map<String, String> shopMap = new HashMap<String, String>();
		for (FileItem item : items)
		{
			if (item.isFormField())
			{
				shopMap.put(item.getFieldName(), item.getString("utf-8"));
			}
		}
		
		
		for (FileItem item : items)
		{
			if (!item.isFormField() && !item.getName().isEmpty())
			{
				int hashCode = item.hashCode();
				int d1 = hashCode & 0xff;
				int d2 = hashCode >> 8 & 0xff;
				String filePath = contextPath + uploadPath + d1 + File.separator+ d2;
				System.out.println(filePath);
				File file = new File(filePath);
				if (!file.isDirectory())
				{
					file.mkdirs();
				}
				String fileName = UUID.randomUUID().toString()
						+ item.getName().substring(item.getName().lastIndexOf("."));
				File saveFile = new File(file, fileName);

				InputStream is = item.getInputStream();
				FileOutputStream os = new FileOutputStream(saveFile);
				IOUtil.in2out(is, os);
				IOUtil.close(is, os);
				item.delete();
				
				path ="images_shop/upload/"+ d1 + "/" + d2 + "/" + fileName;
			}
		}

		
		
		HttpSession session = req.getSession();
		String shopId = (String) session.getAttribute(AttrName.SessionScope.SHOPID);
		Integer shopIdInt = Integer.parseInt(shopId);
		Shop myShop = shopService.findById(shopIdInt);
		String status = myShop.getStatus();
		
		String shopName = shopMap.get("name");
		String shopType = shopMap.get("type");
		
		System.out.println(shopId);
		if(shopId==null||"".trim().equals(shopId)){
			resp.sendRedirect("myshop");;
			return;
		}
		
		if(shopName==null||"".trim().equals(shopName)||shopType==null||"".trim().equals(shopType)){
			System.out.println("1asas");
			req.getRequestDispatcher("/WEB-INF/shopowner/add_products.jsp").forward(req, resp);
			return;
		}
		
		Shop shop =new Shop();
		
		shop.setShopId(shopIdInt);
		shop.setName(shopName);
		shop.setType(shopType);
		shop.setStatus(status);
		
		if(!(path==null||"".trim().equals(path))){
			shop.setPicture(path);
		}
		boolean isUpdateSuccess = shopService.update(shop);
		if(isUpdateSuccess==true){
			System.out.println("ÐÞ¸Ä³É¹¦");
		}
		resp.sendRedirect("myshop");
	}
}
