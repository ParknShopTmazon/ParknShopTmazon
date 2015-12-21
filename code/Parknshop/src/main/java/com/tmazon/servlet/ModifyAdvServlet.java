package com.tmazon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.service.AdvertisementService;
import com.tmazon.service.impl.AdvertisementServiceImpl;


public class ModifyAdvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   public  ModifyAdvServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("advId"));
		System.out.println(request.getParameter("cost"));
		if((!request.getParameter("cost").equals(null))&&(!request.getParameter("cost").equals(""))){
			if((!request.getParameter("advId").equals(null))&&(!request.getParameter("advId").equals(""))){
				AdvertisementService ad=new AdvertisementServiceImpl();
				int advId=Integer.parseInt(request.getParameter("advId"));
				int cost=Integer.parseInt(request.getParameter("cost"));
				if(advId>0&&cost>0)
					ad.modify(advId, cost);
			}
		}
		String url = request.getHeader("Referer");
		response.sendRedirect(url);
	}
}
