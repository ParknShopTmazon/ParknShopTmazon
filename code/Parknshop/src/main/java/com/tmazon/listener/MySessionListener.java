package com.tmazon.listener;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.tmazon.domain.User;
import com.tmazon.util.AttrName;

public class MySessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent arg0) {
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		
		// check if logged on
		User user = (User) event.getSession().getAttribute(
				AttrName.SessionScope.USER);
		if (user != null) {

			String name = user.getName();

			// log out
			@SuppressWarnings("unchecked")
			Map<String, HttpSession> users = (Map<String, HttpSession>) event
					.getSession().getServletContext()
					.getAttribute(AttrName.ApplicationScope.ONLINE_USERS);
			if (users.containsKey(name)) {
				users.remove(name);
				System.out.println("online user: " + users.size());
			}
		}
	}

}
