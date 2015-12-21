package com.tmazon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.service.AdvertisementService;
import com.tmazon.service.impl.AdvertisementServiceImpl;

public class DeleteAdvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteAdvServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("sid"));
		
		if((!request.getParameter("sid").equals(null))&&(!request.getParameter("sid").equals(""))){
		
		int id=Integer.parseInt(request.getParameter("sid"));
		AdvertisementService ad=new AdvertisementServiceImpl();
		ad.delete(id);
	}
	}
}
