package com.tmazon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.domain.Advertisement;
import com.tmazon.domain.Product;
import com.tmazon.domain.Shop;
import com.tmazon.service.AdvertisementService;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.CheckAdmin;
import com.tmazon.util.Page;

public class SearchProductAdminServlet extends HttpServlet {

	
	private AdvertisementService advertisementService = BasicFactory.getImpl(AdvertisementService.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(!CheckAdmin.isAdminOnline(req))
		{
			resp.sendRedirect("login");
			return;
		}
		String type = req.getParameter("select_type");
		String productName = req.getParameter("searchProductName");
		String curPageStr,nextStr;
		int curPage,next;
		curPageStr = req.getParameter("curPage");
		nextStr = req.getParameter("next");
		if(type == null || type.equals(""))
		{
			type = null;
		}
		if(productName == null || productName.equals(""))
		{
			productName = null;
		}
		if(curPageStr == null || curPageStr.equals(""))
		{
			curPage = 1;
		}
		else
		{
			curPage = Integer.parseInt(curPageStr);
		}
		if(nextStr == null || nextStr.equals(""))
		{
			next = 0;
		}
		else
		{
			next = Integer.parseInt(nextStr);
		}
		
		Page<Product> productPage = advertisementService.searchByPage(productName,type,curPage,next);
		List<Shop> shopList = advertisementService.getShopList(productPage.getSubitems());
		req.setAttribute("shopList",shopList);
		req.setAttribute("productList",productPage.getSubitems());
		req.setAttribute("curPage",productPage.getCurPage()==0?1:productPage.getCurPage());
		req.setAttribute("searchProductName",productName);
		req.setAttribute("select_type",type);
		req.getRequestDispatcher("WEB-INF/admin/advertisement.jsp").forward(req,resp);
	}

	
	
	
	
	
	
}
