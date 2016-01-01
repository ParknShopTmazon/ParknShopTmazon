package com.tmazon.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.tmazon.domain.Product;
import com.tmazon.domain.Shop;
import com.tmazon.domain.User;
import com.tmazon.service.ShopService;
import com.tmazon.service.UserService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.DaoUtil;
import com.tmazon.util.IOUtil;

public class RegisterNewShopServlet extends HttpServlet{

	private ShopService shopService = BasicFactory.getImpl(ShopService.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		User user = (User) session.getAttribute(AttrName.SessionScope.USER);
		if(user==null){
			resp.sendRedirect("login");
			return;
		}
		req.getSession().setAttribute(AttrName.SessionScope.SHOPID, "7880");
		req.getRequestDispatcher("/WEB-INF/shopowner/add_products.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

        req.setCharacterEncoding("utf-8"); 
		
		String contextPath = getServletContext().getRealPath(File.separator+"images_shop"+File.separator);
		String uploadPath =File.separator+ "upload"+File.separator;
		String tmpPath = "tmp"+File.separator;
		String path=null;
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		fileItemFactory.setSizeThreshold(1024 * 1024);
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
				
				path ="images_shop"+File.separator+"upload"+File.separator+ d1 + File.separator + d2 + File.separator + fileName;
			}
		}

		
		
		HttpSession session = req.getSession();
		User onlineUser = (User) session.getAttribute(AttrName.SessionScope.USER);
		if(onlineUser == null){
			resp.sendRedirect("login");
			return;
		}
		Integer owner = onlineUser.getUserId();
		System.out.println("owner ="+owner);
		
		String shopName = shopMap.get("name");
		String shopType = shopMap.get("type");
		
		String file = shopMap.get("file");
	
		System.out.println("file: "+file+"  shop_name: "+shopName+"  shop_names: ");
		System.out.println(owner);
		if(owner==null||"".trim().equals(owner)){
			resp.sendRedirect("myshop");;
			return;
		}
		
		if(shopName==null||"".trim().equals(shopName)||shopType==null||"".trim().equals(shopType))
		{
			System.out.println("1asas");
			req.getRequestDispatcher("/WEB-INF/shopowner/register_new_shop.jsp").forward(req, resp);
			return;
		}
		
		Shop shop =new Shop();
		shop.setName(shopName);
		shop.setType(shopType);
		shop.setStatus(Shop.STATUS_CHECKING);
		shop.setOwner(owner);
		
		
		if(path==null||"".trim().equals(path)){
			shop.setPicture("images_shop/index.jpg");
		}else{
			shop.setPicture(path);
		}
		boolean insert = shopService.insert(shop);
		req.setAttribute("img", shop.getPicture());
		if(insert==true){
			req.getRequestDispatcher("/WEB-INF/shopowner/shop_homepage.jsp").forward(req, resp);
			return;
		}else{
			resp.sendRedirect("registernewshop");
			
		}
		
	}
}
