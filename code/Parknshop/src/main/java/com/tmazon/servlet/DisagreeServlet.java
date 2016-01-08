package com.tmazon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.dao.ShopApplyDao;
import com.tmazon.dao.impl.ShopApplyDaoImpl;
import com.tmazon.service.ShopApplyService;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.CheckAdmin;


public class DisagreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopApplyService shopApplyService = BasicFactory.getImpl(ShopApplyService.class); 
    public DisagreeServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			if(!CheckAdmin.isAdminOnline(request))
			{
				response.sendRedirect("login");
				return;
			}
			String shopIdStr = request.getParameter("sid");
			if(shopIdStr != null &&!shopIdStr.equals("")){
				int shopId=Integer.parseInt(shopIdStr);
				shopApplyService.setStatus(shopId, false);
			}
			String url = request.getHeader("Referer");
			response.sendRedirect(url);
	}

}
