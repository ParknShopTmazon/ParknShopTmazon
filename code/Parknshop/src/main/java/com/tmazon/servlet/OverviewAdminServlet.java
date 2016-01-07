package com.tmazon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.User;
import com.tmazon.util.AttrName;


public class OverviewAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			HttpSession session = request.getSession(false);
			User onlineUser = (User) session.getAttribute(AttrName.SessionScope.USER);
			if(onlineUser == null || !onlineUser.getRole().equals(User.ROLE_ADMIN))
			{
				if (session != null) {
					session.invalidate();
				}
				response.sendRedirect("login");
			}
			else
			{
				request.getRequestDispatcher("WEB-INF/admin/overview.jsp").forward(request,response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("login");
		}
		
	}

}
