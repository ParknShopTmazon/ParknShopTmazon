package com.tmazon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.domain.User;
import com.tmazon.service.UserService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;

public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService userService = BasicFactory.getImpl(UserService.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/customer/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// check parameters
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		String status = null;
		if (User.ROLE_CUSTOMER.equals(role)) {
			status = User.STATUS_NORMAL;
		} else if (User.ROLE_SHOP_OWNER.equals(role)) {
			status = User.STATUS_CHECKING;
		} else {
			req.setAttribute(AttrName.RequestScope.ERROR_PARAM_ROLE, true);
			req.getRequestDispatcher("WEB-INF/customer/register.jsp").forward(req, resp);
			return;
		}
		User user = new User(null, name, password, role, status);
		if (!user.isNamePasswordValid()) {
			req.setAttribute(AttrName.RequestScope.ERROR_PARAMETERS, true);
			req.getRequestDispatcher("WEB-INF/customer/register.jsp").forward(req, resp);
			return;
		}
		
		// check if user exists
		if (userService.isUserExist(new User(null, name, null, null, null))) {
			req.setAttribute(AttrName.RequestScope.ERROR_USER_EXISTS, true);
			req.getRequestDispatcher("WEB-INF/customer/register.jsp").forward(req, resp);
			return;
		}
		
		// register
		boolean success = userService.register(user);
		req.setAttribute(AttrName.RequestScope.IS_REGISTER_SUCCESS, success);
		req.getRequestDispatcher("WEB-INF/customer/register.jsp").forward(req, resp);
	}
	
}
