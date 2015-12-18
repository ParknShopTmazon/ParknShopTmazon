package com.tmazon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.Product;
import com.tmazon.service.ProductService;
import com.tmazon.service.UserService;
import com.tmazon.util.BasicFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SearchProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProductService productService = BasicFactory.getImpl(ProductService.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String category = req.getParameter("category");
		Product product  =new Product();
		product.setName(name);
		product.setCategory(category);
		List<Product> productList = productService.select(product);
		if(productList==null||productList.isEmpty()){
			req.setAttribute("num", 0);
		}else{
			req.setAttribute("productList", productList);
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/customer/search_products.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	
}
