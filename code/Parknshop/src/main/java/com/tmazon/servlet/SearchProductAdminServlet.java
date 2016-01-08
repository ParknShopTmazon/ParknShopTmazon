package com.tmazon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.domain.Advertisement;
import com.tmazon.domain.Product;
import com.tmazon.service.AdvertisementService;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.Page;

public class SearchProductAdminServlet extends HttpServlet {

	
	private AdvertisementService advertisementService = BasicFactory.getImpl(AdvertisementService.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("select_type");
		String productName = req.getParameter("searchProductName");
		String curPageStr,nextStr,curPageFisrtStr,nextFirstStr;
		int curPage,next,curPageFirst,nextFirst;
		curPageStr = req.getParameter("curPage");
		nextStr = req.getParameter("next");
//		curPageFisrtStr = req.getParameter("curPageFirst");
//		nextFirstStr = req.getParameter("nextFirst");
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
		if(nextStr == null || nextStr.equals("0"))
		{
			next = 0;
		}
		else
		{
			next = Integer.parseInt(nextStr);
		}
		
//		if(curPageFisrtStr == null || curPageFisrtStr.equals(""))
//		{
//			curPageFirst = 1;
//		}
//		else
//		{
//			curPageFirst = Integer.parseInt(curPageFisrtStr);
//		}
//		if(nextFirstStr == null || nextFirstStr.equals("0"))
//		{
//			nextFirst = 0;
//		}
//		else
//		{
//			nextFirst = Integer.parseInt(nextFirstStr);
//		}
		Page<Product> productPage = advertisementService.searchByPage(productName,type,curPage,next);
		List<Advertisement> adList = advertisementService.getAdList();
//		Page<Advertisement> adPage = advertisementService.getAdPage(adList,curPageFirst,nextFirst);
		req.setAttribute("adList",adList);
		req.setAttribute("productList",productPage.getSubitems());
		req.setAttribute("CurPage",productPage.getCurPage()==0?1:productPage.getCurPage());
		req.getRequestDispatcher("WEB-INF/admin/advertisement.jsp").forward(req,resp);
	}

	
	
	
	
	
	
}
