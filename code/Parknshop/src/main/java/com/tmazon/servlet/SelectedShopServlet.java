package com.tmazon.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.domain.Product;
import com.tmazon.domain.User;
import com.tmazon.service.ProductService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;

public class SelectedShopServlet extends HttpServlet {
	
	private ProductService productService = BasicFactory.getImpl(ProductService.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String shopId=req.getParameter("shopId");
		User user = (User) req.getSession().getAttribute(AttrName.SessionScope.USER);
		if(user == null){
			resp.sendRedirect("login");
			return;
		}
		req.getSession(true).setAttribute(AttrName.SessionScope.SHOPID,shopId);
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String shopId=(String) req.getSession().getAttribute(AttrName.SessionScope.SHOPID);
//		shopId = "1";
		try {
			Product product = new Product(null,Integer.parseInt(shopId),null,null,null,null,null,null,null,null,null);
			ArrayList<Product> productList = (ArrayList<Product>) productService.select(product);
			req.setAttribute("product_list",productList );
			req.setAttribute("num",productList.size());
//			for(Product temp : productList){
//				System.out.println(temp.getName());
//			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
//			Product product = new Product(null,1,null,null,null,null,null,null,null,null,null);
//			ArrayList<Product> productList = (ArrayList<Product>) productService.select(product);
//			for(Product temp : productList){
//				System.out.println(temp.getName());
//			}
			req.getRequestDispatcher("/WEB-INF/shopowner/myshop.jsp").forward(req, resp);
			return;
			
			
		}
		req.getRequestDispatcher("/WEB-INF/shopowner/shop_homepage.jsp").forward(req, resp);
		return;
	}
}
