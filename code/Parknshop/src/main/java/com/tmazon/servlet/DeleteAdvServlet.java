package com.tmazon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.service.AdvertisementService;
import com.tmazon.service.impl.AdvertisementServiceImpl;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.CheckAdmin;

public class DeleteAdvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdvertisementService advertisementService = BasicFactory.getImpl(AdvertisementService.class);
	public DeleteAdvServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!CheckAdmin.isAdminOnline(request))
		{
			response.sendRedirect("login");
			return;
		}
		
		System.out.println("Sid::"+request.getParameter("sid"));
		String productIdStr = request.getParameter("sid");
		String url = request.getHeader("Referer");
		if(productIdStr != null && !productIdStr.equals("")){
		
			int id=Integer.parseInt(productIdStr);
			if(advertisementService.delete(id))
			{
				System.out.println("Advertisement delete Succeed!");
			}
			else
			{
				System.out.println("Advertisement delete failed!");
			}
			response.sendRedirect(url);
		}
	}
}
