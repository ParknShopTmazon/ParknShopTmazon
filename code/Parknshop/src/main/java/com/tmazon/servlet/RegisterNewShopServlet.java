package com.tmazon.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;

import com.tmazon.domain.Shop;
import com.tmazon.domain.User;
import com.tmazon.service.ShopService;
import com.tmazon.service.UserService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.DaoUtil;

public class RegisterNewShopServlet extends HttpServlet{

	private ShopService shopService = BasicFactory.getImpl(ShopService.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("###################");
		
		// check parameters
		String name = req.getParameter("name");
		String type = req.getParameter("type");
		Integer owner = null;
		
//		System.out.println(name + " ####### " + type);
		
		User onlineUser = (User) req.getSession().getAttribute(AttrName.SessionScope.USER);
		
		if(onlineUser == null){
			resp.sendRedirect("login");
			return;
		}
		owner = onlineUser.getUserId();
		System.out.println("owner ="+owner);
		
		if (name == null || type == null ) {
			req.getRequestDispatcher("/WEB-INF/shopowner/RegisterShopPage.jsp").forward(req, resp);
			return;
		}
		
		// check if shop exists
		if (shopService.isShopExist(new Shop(null, name, null, null,null))) {
			req.setAttribute(AttrName.RequestScope.ERROR_SHOP_EXISTS, true);
			req.getRequestDispatcher("/WEB-INF/shopowner/RegisterShopPage.jsp").forward(req, resp);
			return;
		}
		
		// register
		Shop shop = new Shop(null, name, type,Shop.STATUS_CHECKING,owner);
		boolean success = shopService.register(shop);
		req.setAttribute(AttrName.RequestScope.IS_SHOP_REGISTER_SUCCESS, success);
		req.getRequestDispatcher("/WEB-INF/shopowner/homepage.jsp").forward(req, resp);
		
	}
}
