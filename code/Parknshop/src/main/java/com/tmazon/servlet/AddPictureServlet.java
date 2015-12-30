package com.tmazon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddPictureServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		HttpSession session = req.getSession(true);
//		String user = (String) session.getAttribute(AttrName.SessionScope.USER);
//		if(user==null){
//			resp.sendRedirect("login");
//			return;
//		}
		req.getRequestDispatcher("/WEB-INF/shopowner/add_picture.jsp").forward(req, resp);

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

	}
}
