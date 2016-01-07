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

import com.tmazon.domain.Product;
import com.tmazon.domain.User;
import com.tmazon.service.ProductService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.IOUtil;

public class ModifyProductServlet extends HttpServlet{

	private ProductService productService = BasicFactory.getImpl(ProductService.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User userId =  (User) session.getAttribute(AttrName.SessionScope.USER);
		String shopId = (String) session.getAttribute(AttrName.SessionScope.SHOPID);
		if(userId==null){
			resp.sendRedirect("login");
			return;
		}
		System.out.println("#############");
		String productId = req.getParameter("product_id");
		int id =-1;
		try {
			id=Integer.parseInt(productId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("#############1");
		if(id==-1){
			resp.sendRedirect("selectedshop");
			return;
		}
		System.out.println("#############2");
		Product product = productService.findOnSellById(id);
		if(product==null||product.getProductId()==null||product.getProductId()!=id){
			resp.sendRedirect("selectedshop");
			return;
		}
		int shop = -1;
		System.out.println("#############3");
		try {
			shop=Integer.parseInt(shopId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(shop!=product.getShopId()){
			resp.sendRedirect("myshop");
			return;
		}
		System.out.println("#############4");
		req.setAttribute("product_id", product.getProductId());
		req.setAttribute("image", product.getPicture());
		req.setAttribute("productName", product.getName());
		req.setAttribute("price", product.getPrice());
		req.setAttribute("discount_price", product.getDiscountPrice());
		req.setAttribute("stockNum", product.getStockNum());
		req.setAttribute("description", product.getDescription());
		req.getRequestDispatcher("/WEB-INF/shopowner/modify_products.jsp").forward(req, resp);
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

		Map<String, String> productMap = new HashMap<String, String>();
		for (FileItem item : items)
		{
			if (item.isFormField())
			{
				productMap.put(item.getFieldName(), item.getString("utf-8"));
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
		String shopId = (String) session.getAttribute(AttrName.SessionScope.SHOPID);
		String productId = productMap.get("product_id");
		String productName = productMap.get("product_name");
		String category = productMap.get("category");
		String price = productMap.get("price");
		String discountPrice = productMap.get("discount_price");
		String stockNum = productMap.get("stock_num");
		String description = productMap.get("description");
		String file = productMap.get("file");
	
		System.out.println("file: "+file+"  product_name: "+productName+"  product_names: ");
		System.out.println(shopId);
		if(shopId==null||"".trim().equals(shopId)){
			resp.sendRedirect("myshop");;
			return;
		}
		
		if(productName==null||"".trim().equals(productName)||category==null||"".trim().equals(category)||
				price==null||"".equals(price)||stockNum==null||"".trim().equals(stockNum)||description==null||
				"".trim().equals(description)){
			System.out.println("1asas");
			req.getRequestDispatcher("/WEB-INF/shopowner/add_products.jsp").forward(req, resp);
			return;
		}
		
		Product product =new Product();
		product.setProductId(Integer.parseInt(productId));
		product.setName(productName);
		product.setCategory(category);
		product.setPrice(Double.valueOf(price));
		product.setDiscountPrice(Double.valueOf(discountPrice));
		product.setShopId(Integer.parseInt(shopId));
		product.setStockNum(Integer.parseInt(stockNum));
		product.setDescription(description);
		
		if(!(path==null||"".trim().equals(path))){
			product.setPicture(path);
		}
		boolean modify = productService.modify(product);
		if(modify==true){
			System.out.println("ÐÞ¸Ä³É¹¦");
		}
		resp.sendRedirect("selectedshop");
	}
}
