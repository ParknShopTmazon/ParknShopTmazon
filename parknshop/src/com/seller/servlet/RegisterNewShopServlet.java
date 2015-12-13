package com.seller.servlet;
import com.seller.vo.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.*;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seller.dao.*;
/**
 * Servlet implementation class RegisterNewShopServlet
 */
//@WebServlet("/RegisterNewShopServlet")
public class RegisterNewShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterNewShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String SellerName=(String) request.getParameter("SellerName");
		String ShopInfoName=(String)request.getParameter("ShopInfoName");
		String ShopInfoDescription=(String)request.getParameter("ShopInfoDescription");
		HttpSession session=request.getSession();
		Shopinfo sf=new Shopinfo();
		sf.setCustomername(SellerName);
		sf.setShopinfoname(ShopInfoName);
		sf.setShopinfodescription(ShopInfoDescription);
		session.setAttribute("addShopInfo",sf);
		AddShopinfoDao asd=new AddShopinfoDao();
		asd.addShopinfo(sf);
		request.getRequestDispatcher("../seller/message.jsp").forward(request, response);	
	}
}
