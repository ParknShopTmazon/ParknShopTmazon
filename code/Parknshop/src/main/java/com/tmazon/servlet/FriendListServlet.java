package com.tmazon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.tmazon.domain.Message;
import com.tmazon.domain.User;
import com.tmazon.service.MessageService;
import com.tmazon.service.UserService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;

public class FriendListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserService userService = BasicFactory.getImpl(UserService.class);
	private MessageService messageService = BasicFactory.getImpl(MessageService.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		User user = (User) req.getSession().getAttribute(AttrName.SessionScope.USER);
		if (user == null) {
			resp.sendRedirect("login");
			return;
		}
		
		userService.getFriends(user);
		
		JSONObject jsonObject = new JSONObject();
		if (user.getFriends() != null && !user.getFriends().isEmpty()) {
			JSONArray jsonArray = new JSONArray();
			for (User u : user.getFriends()) {
				JSONObject j = new JSONObject();
				j.put("name", u.getName());
				j.put("unread", messageService.getUnreadCount(new Message(null, u.getUserId(), user.getUserId(), null, null, null), false));
				jsonArray.add(j);
			}
			jsonObject.put("friends", jsonArray);
		} 
		
		resp.getWriter().write(jsonObject.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
