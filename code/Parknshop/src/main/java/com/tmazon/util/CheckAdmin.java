package com.tmazon.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.User;

public class CheckAdmin {

	public static boolean isAdminOnline(HttpServletRequest req)
	{
		
		HttpSession session = req.getSession(false);
		if(session == null)
		{
			return false;
		}
		User onlineUser = (User) session.getAttribute(AttrName.SessionScope.USER);
		if(onlineUser == null || !onlineUser.getRole().equals(User.ROLE_ADMIN))
		{
			if (session != null) {
				session.invalidate();
			}
			return false;
		}
		else
		{
			return true;
		}
	}
	
	
}
