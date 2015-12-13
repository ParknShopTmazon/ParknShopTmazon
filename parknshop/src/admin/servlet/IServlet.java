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

public class IServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("msgM", "fuckyou");
		request.getRequestDispatcher("admin/income.jsp").forward(request, response);
	}

}
