package admin.servlet;

import javax.servlet.http.HttpServlet;
import admin.dao.OrderDAO;
import admin.entity.Userorder;
import java.util.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IncomeServlet extends HttpServlet {
	
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	doPost(request,response);
}

public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	  request.setCharacterEncoding("UTF-8");
	  System.out.print("into post");
	  String start= request.getParameter("start");
	  String end= request.getParameter("end");
	  System.out.println(start);
	  System.out.println(end);
	  if ((start == "") || (end == ""))
	  {
	  request.setAttribute("msgM", "You must fill all the blanks.");
	  }
	  else{
	  String syear=start.substring(0, 4);
	  System.out.println(syear);
	  String smonth=start.substring(5, 7);System.out.println(smonth);
	  String sday=start.substring(8, 10);System.out.println(sday);
	  String eyear=end.substring(0, 4);System.out.println(eyear);
	  String emonth=end.substring(5, 7);System.out.println(emonth);
	  String eday=end.substring(8, 10);System.out.println(eday);
	  int s1=Integer.parseInt(syear);System.out.println(s1);
	  int s2=Integer.parseInt(smonth);System.out.println(s2);
	  int s3=Integer.parseInt(sday);System.out.println(s3);
	  int e1=Integer.parseInt(eyear);
	  int e2=Integer.parseInt(emonth);
	  int e3=Integer.parseInt(eday);
	  Calendar sca=Calendar.getInstance();
	  Calendar eca=Calendar.getInstance();
	  sca.set(s1, s2-1, s3);
	  eca.set(e1, e2-1, e3);
	  System.out.println(sca.getTime()+"cal");
	  System.out.println(eca.getTime()+"cal");
	  Date sdate=sca.getTime();
	  Date edate=eca.getTime();
	  OrderDAO odao=new OrderDAO();
	  List<Userorder> uo=odao.getAllOrders();
	  System.out.println("获取了数据");
	  if(uo.size()==0)
	  {
		  request.setAttribute("msgM", "goodbye");
		  request.getRequestDispatcher("admin/income.jsp").forward(request, response);
	  }
	  else
	  {
		  List<Userorder> nuo=new ArrayList<Userorder>();
		  int k=uo.size();
		  for(int i=0;i<k;i++)
		  {	
			  if((uo.get(i).getOrderTime().after(sdate))&&(uo.get(i).getOrderTime().before(edate)))
			  {nuo.add(uo.get(i));}
		  }
		  int sum=0;
		  for(int i=0;i<nuo.size();i++)
		  {
			  int price=odao.getPriceById(nuo.get(i).getShopProductId());
			  int orderprice=price*nuo.get(i).getProductBuyNum();
			  sum+=orderprice;
		  } 
		  System.out.println();
		  System.out.print(sum);
		
		  request.setAttribute("msgM", String.valueOf(sum));
		 
	  }//else2
	  }//else1 
	  request.getRequestDispatcher("admin/income.jsp").forward(request, response);
}//dopost
	
}//class


