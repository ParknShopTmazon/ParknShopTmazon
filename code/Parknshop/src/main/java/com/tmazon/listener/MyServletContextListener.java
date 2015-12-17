package com.tmazon.listener;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import com.tmazon.util.AttrName;

public class MyServletContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent event) {
		event.getServletContext().removeAttribute(
				AttrName.ApplicationScope.ONLINE_USERS);
	}

	public void contextInitialized(ServletContextEvent event) {
		event.getServletContext().setAttribute(
				AttrName.ApplicationScope.ONLINE_USERS,
				new ConcurrentHashMap<String, HttpSession>());
	}
}
