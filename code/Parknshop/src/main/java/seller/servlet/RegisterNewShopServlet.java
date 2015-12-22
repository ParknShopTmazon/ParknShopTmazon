package seller.servlet;
import seller.vo.*;

import java.io.IOException;

import javax.servlet.*;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import seller.dao.*;
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
		
		String True_Name=(String)request.getParameter("true_name");
		String ID_Number=(String)request.getParameter("ID Number");
		String Shop_Name=(String)request.getParameter("Shop Name");
		String username=(String)request.getParameter("username");
		
	//	System.out.println(True_Name);
		
		HttpSession session=request.getSession();
		Shopinfo sf=new Shopinfo();
		sf.setCustomername(True_Name);
		sf.setShopinfoname(Shop_Name);
		sf.setShopinfodescription(ID_Number);
		session.setAttribute("addShopInfo",sf);
		request.getRequestDispatcher("homepage.jsp").forward(request, response);
	}
}
