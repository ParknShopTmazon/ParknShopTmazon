package com.tmazon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.Shop;
import com.tmazon.domain.User;
import com.tmazon.service.ShopService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;

public class DeleteShopServlet extends HttpServlet {

private ShopService shopService = BasicFactory.getImpl(ShopService.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		User userId =  (User) session.getAttribute(AttrName.SessionScope.USER);
		if(userId==null){
			resp.sendRedirect("login");
			return;
		}
		
		String shopId=req.getParameter("shopId");
		System.out.println("*******************"+shopId);
		if(!(shopId==null||"".trim().equals(shopId))){
			System.out.println("sdsdsdsddssdsddssd"+shopId);
			req.getSession(true).setAttribute(AttrName.SessionScope.SHOPID,shopId);
		}
		
		int shopOneId = -1;
		try {
			shopOneId=Integer.parseInt(shopId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Shop shop = shopService.findById(shopOneId);
		if(shopOneId!=shop.getShopId()){
			resp.sendRedirect("myshop");
			return;
		}
		req.setAttribute("shopId", shop.getShopId());
		req.setAttribute("picture", shop.getPicture());
		req.setAttribute("name", shop.getName());
		req.setAttribute("type", shop.getType());
		req.getRequestDispatcher("/WEB-INF/shopowner/delete_shop.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		
		System.out.println("**************************");
		String shopId =(String) req.getSession(true).getAttribute(AttrName.SessionScope.SHOPID);
		System.out.println("shopId=="+shopId);
		int id=-1;
		try {
			id=Integer.parseInt(shopId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(id==-1){
			resp.sendRedirect("myshop");
			return;
		}
		Shop shop =new Shop();
		shop.setShopId(id);;
		boolean isDeleteSuccess = shopService.delete(shop);
		if(isDeleteSuccess==true){
			System.out.println("ÐÞ¸Ä³É¹¦");
		}
		resp.sendRedirect("myshop");
	}
}
