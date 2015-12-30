package com.tmazon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.domain.User;
import com.tmazon.service.UserService;
import com.tmazon.util.BasicFactory;

public class SearchUserAdminServlet extends HttpServlet{
	
	private UserService userService = BasicFactory.getImpl(UserService.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String role = req.getParameter("select");
		
		User user = new User(null,userName,null,role,null);
		
	}

	
	
	
}
