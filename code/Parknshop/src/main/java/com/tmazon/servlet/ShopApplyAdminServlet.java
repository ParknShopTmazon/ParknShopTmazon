package com.tmazon.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.Shop;
import com.tmazon.domain.User;
import com.tmazon.service.ShopApplyService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.CheckAdmin;

public class ShopApplyAdminServlet extends HttpServlet {

	private ShopApplyService shopApplyService = BasicFactory.getImpl(ShopApplyService.class); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(CheckAdmin.isAdminOnline(req))
		{
			List<Shop> shopList = shopApplyService.getApply();
			List<User> userList = shopApplyService.searchForOwner(shopList);
			
			req.setAttribute("shopList",shopList);
			req.setAttribute("userList",userList);
			req.getRequestDispatcher("WEB-INF/admin/shopApply.jsp").forward(req,resp);
		}
		else
		{
			resp.sendRedirect("login");
		}
		
	}



	
}
