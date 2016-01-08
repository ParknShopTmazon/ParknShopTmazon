package com.tmazon.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.User;
import com.tmazon.service.OverviewAdminService;
import com.tmazon.service.UserService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.RateUtil;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService userService = BasicFactory.getImpl(UserService.class);
	private OverviewAdminService overviewAdminService = BasicFactory.getImpl(OverviewAdminService.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		req.getSession().setAttribute(AttrName.SessionScope.LOGIN_REFERER, req.getHeader("Referer"));
		
		req.getRequestDispatcher("WEB-INF/customer/login.jsp").forward(req,
				resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
	
		// check parameters
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		User user = new User(null, name, password, null, null);
		
		if (!user.isNamePasswordValid()) {
			req.setAttribute(AttrName.RequestScope.ERROR_PARAMETERS, true);
			req.getRequestDispatcher("WEB-INF/customer/login.jsp").forward(req,
					resp);
			return;
		}
		
		// check user name and password
		if (!userService
				.isUserExist(user)) {
			req.setAttribute(AttrName.RequestScope.ERROR_NAME_PASSWORD, true);
			req.getRequestDispatcher("WEB-INF/customer/login.jsp").forward(req,
					resp);
			return;
		}

		// check if logged-on
		if (req.getSession().getAttribute(AttrName.SessionScope.USER) != null) {
			resp.sendRedirect("index");
			return;
		}

		// check if logged-on elsewhere
		@SuppressWarnings("unchecked")
		Map<String, HttpSession> users = (Map<String, HttpSession>) req
				.getSession().getServletContext()
				.getAttribute(AttrName.ApplicationScope.ONLINE_USERS);
		if (users.containsKey(name)) {
			users.get(name).invalidate();
		}

		// check user status
		user = userService.findByName(name);
		if (user.getStatus().equals(User.STATUS_BLACK)) {
			req.setAttribute(AttrName.RequestScope.ERROR_USER_BLACK, true);
			req.getRequestDispatcher("WEB-INF/customer/login.jsp").forward(req,
					resp);
			return;
		} 
		
		// log in
		req.getSession().setAttribute(AttrName.SessionScope.USER, user);
		users.put(name, req.getSession());
		System.out.println("online user: " + users.size());
		
		//When user log in, set tht Rate,
		//Attention! the Rate is double.
		RateUtil.setRate(overviewAdminService.getRate());
		if (user.getRole().equals(User.ROLE_ADMIN)) {
			req.getRequestDispatcher("overview").forward(req, resp);;
			return ;
		}
		
		String url = (String) req.getSession().getAttribute(AttrName.SessionScope.LOGIN_REFERER);
		if (url == null || url.endsWith("login") || url.endsWith("register")) {
			url = "index";
		}
		resp.sendRedirect(url);
	}
}
