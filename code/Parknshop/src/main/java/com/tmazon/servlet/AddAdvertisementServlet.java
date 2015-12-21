package com.tmazon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.dao.AdvertisementDao;
import com.tmazon.dao.impl.AdvertisementDaoImpl;
import com.tmazon.domain.Advertisement;
import com.tmazon.service.AdvertisementService;
import com.tmazon.service.impl.AdvertisementServiceImpl;

public class AddAdvertisementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddAdvertisementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("cost"));
		System.out.println(request.getParameter("productID"));
		if((!request.getParameter("cost").equals(null))&&(!request.getParameter("cost").equals(""))){
			if((!request.getParameter("productID").equals(null))&&(!request.getParameter("productID").equals(""))){
				int cost=Integer.parseInt(request.getParameter("cost"));
				int productID=Integer.parseInt(request.getParameter("productID"));
				AdvertisementService ad=new AdvertisementServiceImpl();
				if(cost>0&&productID>0){
						ad.addAd(cost, productID);
						AdvertisementDao ado=new AdvertisementDaoImpl();
						List<Advertisement> lad=ado.select();
						request.getSession().setAttribute("showAd", lad);
				}
			}
		}
		String url = request.getHeader("Referer");
		response.sendRedirect(url);
	}
}
