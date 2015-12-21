package com.tmazon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.service.ProfitService;
import com.tmazon.service.impl.ProfitServiceImpl;


 
public class ProfitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ProfitServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProfitService p=new ProfitServiceImpl();
		if(p.getProfit()==0){
			request.getSession().setAttribute("profit","" );
		}else{
			request.getSession().setAttribute("profit",p.getProfit() );
		}
		
		//System.out.println(p.getProfit());
		String url = request.getHeader("Referer");
		response.sendRedirect(url);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
