package com.tmazon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.service.CartService;
import com.tmazon.service.ProductService;
import com.tmazon.util.BasicFactory;

import net.sf.json.JSONObject;

public class ShowCartInfoServlet extends HttpServlet {

	
	private ProductService productService = BasicFactory.getImpl(ProductService.class);
	private CartService cartService = BasicFactory.getImpl(CartService.class);
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.getAttribute("");
		
		JSONObject jsonObject = new JSONObject();
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		
		
	};
	
}
