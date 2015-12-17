package com.tmazon.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.User;
import com.tmazon.util.AttrName;

public class LogoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// check if logged on
		User user = (User) req.getSession().getAttribute(
				AttrName.SessionScope.USER);
		if (user != null) {

			String name = user.getName();

			// log out
			@SuppressWarnings("unchecked")
			Map<String, HttpSession> users = (Map<String, HttpSession>) req
					.getSession().getServletContext()
					.getAttribute(AttrName.ApplicationScope.ONLINE_USERS);
			if (users.containsKey(name)) {
				users.get(name).invalidate();
				users.remove(name);
				System.out.println("online user: " + users.size());
			}			
		}
		
		String url = req.getHeader("Referer");
		resp.sendRedirect(url);
	}

}
