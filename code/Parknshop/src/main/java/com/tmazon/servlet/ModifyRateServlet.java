package com.tmazon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.dao.impl.RateDaoImpl;
import com.tmazon.service.OverviewAdminService;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.CheckAdmin;
import com.tmazon.util.RateUtil;


public class ModifyRateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OverviewAdminService overviewAdminService = BasicFactory.getImpl(OverviewAdminService.class); 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	System.out.println(123);
		
		if(!CheckAdmin.isAdminOnline(request))
		{
			response.sendRedirect("login");
			return;
		}
		String rate = request.getParameter("rate");
		if(rate != null && !rate.equals("")){
			double rateNum = Double.valueOf(rate)/100.0;
			RateUtil.setRate(rateNum);
			boolean result = overviewAdminService.modifyRate(rateNum);
			request.getRequestDispatcher("overview").forward(request,response);
		}
		
	}

}
