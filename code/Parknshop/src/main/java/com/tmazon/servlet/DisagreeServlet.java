package com.tmazon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.dao.ShopApplyDao;
import com.tmazon.dao.impl.ShopApplyDaoImpl;


public class DisagreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DisagreeServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			if((!request.getParameter("sid").equals(null))&&(!request.getParameter("sid").equals(""))){
				int shopId=Integer.parseInt(request.getParameter("sid"));
				ShopApplyDao sad=new ShopApplyDaoImpl();
				sad.setStatus(shopId, false);
			}
			String url = request.getHeader("Referer");
			response.sendRedirect(url);
	}

}
