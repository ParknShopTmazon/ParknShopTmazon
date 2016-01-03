package com.tmazon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.domain.Product;
import com.tmazon.service.ProductService;
import com.tmazon.util.BasicFactory;


public class SearchProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProductService productService = BasicFactory.getImpl(ProductService.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String category = req.getParameter("type");
		if ("".equals(category)) {
			category = null;
		}
		
		Product product  =new Product(null, null, name, null, null, category, null, null, null, null);
		
		List<Product> productList = productService.selectInLike(product);
		if(productList==null||productList.isEmpty()){
			req.setAttribute("num", 0);
		}else{
			req.setAttribute("num", productList.size());
			req.setAttribute("productList", productList);
			req.setAttribute("test", 0);
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/customer/search_products.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	
}
