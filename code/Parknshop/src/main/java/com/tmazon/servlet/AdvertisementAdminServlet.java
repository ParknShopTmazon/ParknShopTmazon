package com.tmazon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.User;
import com.tmazon.util.AttrName;

public class AdvertisementAdminServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try
		{
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
				req.getRequestDispatcher("WEB-INF/admin/advertisement.jsp").forward(req,resp);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			resp.sendRedirect("login");
		}
	}

	

}
