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
import com.tmazon.service.UserManageService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.CheckAdmin;
import com.tmazon.util.Page;

public class ShopApplyAdminServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ShopApplyService shopApplyService = BasicFactory.getImpl(ShopApplyService.class); 
	private UserManageService userManageService = BasicFactory.getImpl(UserManageService.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(CheckAdmin.isAdminOnline(req))
		{
			List<Shop> shopList = shopApplyService.getApply();
			List<User> userList = shopApplyService.searchForOwner(shopList);
			String curPageStr = req.getParameter("curPage");
			String nextStr = req.getParameter("next");
			int curPage,next;
			if(curPageStr == null || curPageStr.equals("0"))
			{
				curPage = 1;
			}
			else
			{
				curPage = Integer.parseInt(curPageStr);
			}
			if(nextStr == null || nextStr.equals("0"))
			{
				next = 0;
			}
			else
			{
				next = Integer.parseInt(nextStr);
			}
			Page<Shop> shopPage = shopApplyService.page(shopList,curPage,next);
			Page<User> userPage = userManageService.pageList(userList,curPage,next);
 			req.setAttribute("shopList",shopPage.getSubitems());
			req.setAttribute("userList",userPage.getSubitems());
			req.setAttribute("CurPage",shopPage.getCurPage());
			req.getRequestDispatcher("WEB-INF/admin/shopApply.jsp").forward(req,resp);
		}
		else
		{
			resp.sendRedirect("login");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	



	
}
