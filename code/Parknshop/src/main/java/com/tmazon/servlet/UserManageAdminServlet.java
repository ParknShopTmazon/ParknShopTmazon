package com.tmazon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.User;
import com.tmazon.util.AttrName;

public class UserManageAdminServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(false);
		User onlineUser = (User) session.getAttribute(AttrName.SessionScope.USER);
		if(onlineUser == null || !onlineUser.getRole().equals(User.ROLE_ADMIN))
		{
			if (session != null) {
				session.invalidate();
			}
			resp.sendRedirect("login");
		}
		else
		{
			req.getRequestDispatcher("WEB-INF/admin/userManagement.jsp").forward(req,resp);
		}
	}

	

}
