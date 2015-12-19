package com.tmazon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.domain.Cart;
import com.tmazon.domain.Delivery;
import com.tmazon.domain.User;
import com.tmazon.service.CartService;
import com.tmazon.service.DeliveryService;
import com.tmazon.util.BasicFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ShowCartServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("WEB-INF/customer/cart.jsp").forward(req, resp);
	}
	
	
	
}
