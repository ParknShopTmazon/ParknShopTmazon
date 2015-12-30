package com.tmazon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.domain.Message;
import com.tmazon.domain.User;
import com.tmazon.service.MessageService;
import com.tmazon.service.UserService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;

public class LeaveMessageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MessageService messageService = BasicFactory.getImpl(MessageService.class); 
	private UserService userService = BasicFactory.getImpl(UserService.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		User user = (User) req.getSession().getAttribute(AttrName.SessionScope.USER);
		if (user == null) {
			resp.sendRedirect("login");
			return;
		}
		
		// get parameter
		String friendName = req.getParameter("friendName");
		if (friendName == null) {
			return;
		}
		User friend = userService.findByName(friendName);
		if (friend == null) {
			return;
		}
		String content = req.getParameter("content");
		
		// leave message
		boolean result = messageService.createMessage(new Message(null, user.getUserId(), friend.getUserId(), content, null, true));
		resp.getWriter().write(result ? "success" : "failed");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
