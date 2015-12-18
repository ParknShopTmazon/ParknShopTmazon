package com.tmazon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.service.CartService;
import com.tmazon.service.ProductService;
import com.tmazon.util.BasicFactory;

public class ShowCartInfoServlet extends HttpServlet {

	
	private ProductService productService = BasicFactory.getImpl(ProductService.class);
	private CartService cartService = BasicFactory.getImpl(CartService.class);
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		
		
	};
	
}
