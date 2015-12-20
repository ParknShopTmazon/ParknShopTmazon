package com.tmazon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.util.Rate;


public class ModifyRateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ModifyRateServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Rate.setRate(Integer.parseInt(request.getParameter("rate")));
		request.getSession().setAttribute("rate", 100*Integer.parseInt(request.getParameter("rate")));
		
	}

}
