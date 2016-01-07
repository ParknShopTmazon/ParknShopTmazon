package com.tmazon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.User;
import com.tmazon.util.AttrName;
import com.tmazon.util.CheckAdmin;


public class OverviewAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(CheckAdmin.isAdminOnline(req))
		{
			req.getRequestDispatcher("WEB-INF/admin/overview.jsp").forward(req,resp);
		}
		else
		{
			resp.sendRedirect("login");
		}
		
		
	}

}
