package com.tmazon.servlet;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.domain.Product;
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
		
		List<Product> products = productService.select(new Product(null, null, null, null, null, req.getParameter("category"), null, null, null, null, null));
		products.sort(new Comparator<Product>() {

			public int compare(Product o1, Product o2) {
				return o2.getSoldNum() - o1.getSoldNum();
			}
			
		});
		req.setAttribute(AttrName.RequestScope.PRODUCTS, products);
		
		req.getRequestDispatcher("WEB-INF/customer/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
