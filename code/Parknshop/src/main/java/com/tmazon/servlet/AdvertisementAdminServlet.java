package com.tmazon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.User;
import com.tmazon.service.AdvertisementService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.CheckAdmin;

public class AdvertisementAdminServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdvertisementService advertisementService = BasicFactory.getImpl(AdvertisementService.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		if(CheckAdmin.isAdminOnline(req))
		{
			
			
			req.getRequestDispatcher("WEB-INF/admin/advertisement.jsp").forward(req,resp);
		}
		else
		{
			resp.sendRedirect("login");
		}
	}

	

}
