package com.tmazon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Attr;

import com.tmazon.domain.User;
import com.tmazon.util.AttrName;

public class MyShopServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	    User loginUser = (User) req.getSession().getAttribute(AttrName.SessionScope.USER);
	    if(loginUser == null){
	    	resp.sendRedirect("login");
	    }else{
	    	req.getRequestDispatcher("/WEB-INF/shopowner/myshop.jsp").forward(req, resp);
	    }
	    
	}
	
}
