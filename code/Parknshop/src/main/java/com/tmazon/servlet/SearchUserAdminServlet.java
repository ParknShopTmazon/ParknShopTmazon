package com.tmazon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.User;
import com.tmazon.service.UserManageService;
import com.tmazon.service.UserService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.CheckAdmin;
import com.tmazon.util.Page;

public class SearchUserAdminServlet extends HttpServlet{
	
	private UserManageService userManageService = BasicFactory.getImpl(UserManageService.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//if the user is online or offline?
		if(!CheckAdmin.isAdminOnline(req))
		{
			resp.sendRedirect("login");
			return;
		}
		
		//get the parameter from the input
		String option = (String)req.getAttribute("option");
		String userName,role;
		String curPageStr,nextStr;
		int next,curPage;
		List<User> userList;
		
		if(option != null)
		{
			userName = (String) req.getAttribute("UserName");
			role = (String) req.getAttribute("select_role");
			nextStr = "0";
		    curPageStr = (String) req.getAttribute("CurPage");
		}
		else
		{
			userName = req.getParameter("UserName");
			role = req.getParameter("select_role");
			nextStr = req.getParameter("next");
		    curPageStr = req.getParameter("curPage");
		}
		
	    
		req.getSession().setAttribute("searchInfo",new User(null,userName,null,role,null));
		
		if(userName == null || userName.equals(""))
		{
			userName = null;
		}
		if(role == null || role.equals(""))
		{
			role = null;
		}
		if(nextStr == null || curPageStr==null || nextStr.equals("") || curPageStr.equals(""))
		{
			curPage = 1;
			next = 0;
		}
		else
		{
			next = Integer.valueOf(nextStr).intValue();
			curPage = Integer.valueOf(curPageStr).intValue();
		}
		//Get the user list from database
		User user = new User(null,userName,null,role,null);
		Page<User> pageUserList = userManageService.page(user,curPage,next);
		userList = pageUserList.getSubitems();
		req.setAttribute("userList",userList);
		req.setAttribute("curPage",pageUserList.getCurPage());
		req.getRequestDispatcher("WEB-INF/admin/userManagement.jsp").forward(req, resp);
	}

	
	
	
}
