package com.tmazon.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.dao.AdvertisementDao;
import com.tmazon.dao.ShopApplyDao;
import com.tmazon.dao.impl.AdvertisementDaoImpl;
import com.tmazon.dao.impl.ShopApplyDaoImpl;
import com.tmazon.domain.Advertisement;
import com.tmazon.domain.Shop;
import com.tmazon.domain.User;
import com.tmazon.service.UserService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService userService = BasicFactory.getImpl(UserService.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		req.getRequestDispatcher("WEB-INF/customer/login.jsp").forward(req,
				resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
	
	
		// check parameters
		@SuppressWarnings("unchecked")
		Map<String, String[]> params = req.getParameterMap();
		if (!params.containsKey("name") || !params.containsKey("password")) {
			req.setAttribute(AttrName.RequestScope.ERROR_PARAMETERS, true);
			req.getRequestDispatcher("WEB-INF/customer/login.jsp").forward(req,
					resp);
			return;
		}

		// check user name and password
		String name = params.get("name")[0];
		String password = params.get("password")[0];
	
			
		if (!userService
				.isUserExist(new User(null, name, password, null, null))) {
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

		// log in
		User user = userService.findByName(name);
		req.getSession().setAttribute(AttrName.SessionScope.USER, user);
		users.put(name, req.getSession());
		System.out.println("online user: " + users.size());
		
		if (user.getRole().equals(User.ROLE_ADMIN)) {
			ShopApplyDao s=new ShopApplyDaoImpl();
			List <Shop> list=s.getApply();
			req.getSession().setAttribute("apply", list);
			req.getSession().setAttribute("rate", 5);
			req.getSession().setAttribute("profit", 0);
			AdvertisementDao ado=new AdvertisementDaoImpl();
			List<Advertisement> lad=ado.select();
			req.getSession().setAttribute("showAd", lad);
			req.getRequestDispatcher("WEB-INF/admin/overview.jsp").forward(req, resp);;
			return ;
		}
		resp.sendRedirect("index");
	}
}
