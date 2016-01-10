package com.tmazon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.dao.impl.RateDaoImpl;
import com.tmazon.util.RateUtil;


public class ModifyRateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ModifyRateServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	System.out.println(123);
		if(!request.getParameter("rate").equals(null)&&!request.getParameter("rate").equals("")){
			RateUtil.setRate(Double.valueOf(""+request.getParameter("rate")));
			new RateDaoImpl().modifyRate(Double.valueOf(request.getParameter("rate")));
			request.getSession().setAttribute("rate", Double.valueOf(request.getParameter("rate")));
		}
		
		
		String url = request.getHeader("Referer");
		response.sendRedirect(url);
	}

}
