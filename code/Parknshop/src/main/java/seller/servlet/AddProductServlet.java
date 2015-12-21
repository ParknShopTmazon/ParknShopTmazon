package seller.servlet;

import seller.vo.*;
import seller.domain.*;

import java.io.IOException;

import javax.servlet.*;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import seller.dao.*;
import seller.service.ProductService;
import seller.servlet.*;
/**
 * Servlet implementation class RegisterNewShopServlet
 */
//@WebServlet("/RegisterNewShopServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		
		String ShopName=(String)request.getParameter("Shop Name");
		String ProductName=(String)request.getParameter("Product Name");
		String ProductPrice=(String)request.getParameter("Product Price");
		String Remark=(String)request.getParameter("Remark");
		String productid=(String)request.getParameter("Product Id");

	//	System.out.println(ShopName);
		ProductService ps=new ProductService();
		ps.addpd_part(productid,ShopName,Remark,ProductPrice);

		Product product=new Product();
		product.setName(ShopName);
		product.setPrice(ProductPrice);
		product.setProductId(productid);
        product.setremark(Remark);
        
        request.setAttribute("add",product);
		
		
		
		
		HttpSession session=request.getSession();
	/*
	 	Shopinfo sf=new Shopinfo();
		sf.setCustomername(ShopName);
		sf.setShopinfoname(ProductName);
		sf.setShopinfodescription(ProductPrice);
		session.setAttribute("addShopInfo",sf);
		*/
		request.getRequestDispatcher("product list.jsp").forward(request, response);
	}
}
