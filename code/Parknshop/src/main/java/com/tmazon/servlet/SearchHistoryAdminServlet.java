package com.tmazon.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.domain.History;
import com.tmazon.service.HistoryAdminService;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.CheckAdmin;
import com.tmazon.util.Page;

/**
 * Servlet implementation class SearchHistoryAdminServlet
 */
public class SearchHistoryAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HistoryAdminService  historyAdminService = BasicFactory.getImpl(HistoryAdminService.class);
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(!CheckAdmin.isAdminOnline(req))
		{
			resp.sendRedirect("login");
			return;
		}
		String curPageStr,nextStr;
		int next,curPage;
		String startDateStr = (String)req.getParameter("start");
		String endDateStr = (String)req.getParameter("end");
		curPageStr = (String)req.getParameter("curPage");
		nextStr = (String)req.getParameter("next");
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
		try {
			SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			Date startDate = startDateStr == null || startDateStr.equals("")? null: formatter.parse(startDateStr+" 00:00:00");
			Date endDate = endDateStr == null || endDateStr.equals("")? null : formatter.parse(endDateStr+" 23:59:59");
			if(startDate != null && endDate != null)
						System.out.println(startDate.toString()+"::"+endDate.toString());
			List<History> historyList = historyAdminService.search(startDate,endDate);
			Page<History> historyPage = historyAdminService.page(historyList,curPage,next);
			double income = historyAdminService.getIncome(historyList);
			req.setAttribute("historyList",historyPage.getSubitems());
			req.setAttribute("CurPage",historyPage.getCurPage()==0?1:historyPage.getCurPage());
			req.setAttribute("Income",income);
			req.setAttribute("start",startDateStr);
			req.setAttribute("end",endDateStr);
			req.getRequestDispatcher("WEB-INF/admin/other.jsp").forward(req,resp);
			return;
		} catch (ParseException e) {
			e.printStackTrace();
			req.setAttribute("CurPage",1);
			req.getRequestDispatcher("WEB-INF/admin/other.jsp").forward(req,resp);
		}
		
		
	}

}
