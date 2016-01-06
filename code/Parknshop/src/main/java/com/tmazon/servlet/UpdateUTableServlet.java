package com.tmazon.servlet;

import java.io.IOException;
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

/**
 * Servlet implementation class UpdateUStatusServlet
 */
public class UpdateUTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	private UserManageService userManageService = BasicFactory.getImpl(UserManageService.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//get user name and status
		String user_name = request.getParameter("user_name");
		String status = request.getParameter("status");
//		System.out.println(user_name);
//		System.out.println(status);
		if(status.equals(User.STATUS_NORMAL))
		{
			userManageService.update(user_name,User.STATUS_NORMAL);
		}
		else if(status.equals(User.STATUS_BLACK))
		{
			userManageService.update(user_name,User.STATUS_BLACK);
		}
		else
		{
			userManageService.delete(user_name);
		}
		User search = (User)request.getSession().getAttribute("searchInfo");
		request.setAttribute("UserName",search.getName());
		request.setAttribute("select_role",search.getRole());
		request.setAttribute("option","y");
		request.getRequestDispatcher("/searchUserAdmin").forward(request, response);

		//String 
		//change status
	}

}
