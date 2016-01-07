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

public class UserManageAdminServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(CheckAdmin.isAdminOnline(req))
		{
			req.getRequestDispatcher("WEB-INF/admin/userManagement.jsp").forward(req,resp);
		}
		else
		{
			resp.sendRedirect("login");
		}
	}

	

}
