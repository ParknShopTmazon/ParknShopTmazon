package com.tmazon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mchange.v2.sql.filter.SynchronizedFilterCallableStatement;
import com.tmazon.domain.Advertisement;
import com.tmazon.domain.Shop;
import com.tmazon.domain.User;
import com.tmazon.service.AdvertisementService;
import com.tmazon.service.OverviewAdminService;
import com.tmazon.service.OverviewNumberService;
import com.tmazon.service.ShopApplyService;
import com.tmazon.service.impl.OverviewNumberServiceImpl;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.CheckAdmin;
import com.tmazon.util.RateUtil;


public class OverviewAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ShopApplyService shopApplyService = BasicFactory.getImpl(ShopApplyService.class); 
	private OverviewNumberService overviewNumberService = BasicFactory.getImpl(OverviewNumberService.class); 
	private AdvertisementService advertisementService = BasicFactory.getImpl(AdvertisementService.class); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(CheckAdmin.isAdminOnline(req))
		{
			List<Shop> shopList = shopApplyService.getApply();
			List<Advertisement> adList = advertisementService.getAdList();
			req.setAttribute("shopApplyNum",shopList.size());
			req.setAttribute("adNum",adList.size());
			req.setAttribute("shopOwnerNumber",overviewNumberService.getShopOwnerNumber());
			req.setAttribute("customerNumber", overviewNumberService.getCustomerNumber());
			req.setAttribute("rate", RateUtil.getRate()*100);
			req.getRequestDispatcher("WEB-INF/admin/overview.jsp").forward(req,resp);
		}
		else
		{
			resp.sendRedirect("login");
		}
		
		
	}

}
