package com.tmazon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.service.ProductService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;

public class IndexServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProductService productService = BasicFactory.getImpl(ProductService.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String[] categories = productService.findAllCategory();
		
		req.setAttribute(AttrName.RequestScope.CATEGORIES, categories);
		req.getRequestDispatcher("WEB-INF/customer/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
