package com.tmazon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.Product;
import com.tmazon.service.ProductService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;

public class AddProductServlet extends HttpServlet{

	private ProductService productService = BasicFactory.getImpl(ProductService.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
//		HttpSession session = req.getSession(true);
//		String user = (String) session.getAttribute(AttrName.SessionScope.USER);
//		if(user==null){
//			resp.sendRedirect("login");
//			return;
//		}
		req.getRequestDispatcher("/WEB-INF/shopowner/add_products.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String shopId = (String) session.getAttribute(AttrName.SessionScope.SHOPID);
		String productName = req.getParameter("product_name");
		String category = req.getParameter("category");
		String price = req.getParameter("price");
		String stockNum = req.getParameter("stock_num");
		String description = req.getParameter("description");
		System.out.println(shopId);
		if(shopId==null||"".trim().equals(shopId)){
			req.getRequestDispatcher("/WEB-INF/shopowner/myshop.jsp").forward(req, resp);
			return;
		}
		
		if(productName==null||"".trim().equals(productName)||category==null||"".trim().equals(category)||
				price==null||"".equals(price)||stockNum==null||"".trim().equals(stockNum)||description==null||
				"".trim().equals(description)){
			System.out.println("1asas");
			req.getRequestDispatcher("/WEB-INF/shopowner/add_products.jsp").forward(req, resp);
		}
		System.out.println("2asas");
		Product product =new Product();
		product.setName(productName);
		product.setCategory(category);
		product.setPrice(Double.valueOf(price));
		product.setDiscountPrice(Double.valueOf(price));
		product.setShopId(Integer.parseInt(shopId));
		product.setStockNum(Integer.parseInt(stockNum));
		product.setDescription(description);
		product.setPicture("/images_shop/index.jpg");
		boolean insert = productService.insert(product);
		req.setAttribute("img", product.getPicture());
		if(insert==true){
			req.setAttribute("picture", product.getPicture());
			req.getRequestDispatcher("addpicture").forward(req, resp);
		}
		
		
	}
}
