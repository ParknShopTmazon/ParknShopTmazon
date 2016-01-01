package com.tmazon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.Product;
import com.tmazon.domain.User;
import com.tmazon.service.ProductService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;

public class ModifyProductServlet extends HttpServlet{

	private ProductService productService = BasicFactory.getImpl(ProductService.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User userId =  (User) session.getAttribute(AttrName.SessionScope.USER);
		String shopId = (String) session.getAttribute(AttrName.SessionScope.SHOPID);
		if(userId==null){
			resp.sendRedirect("login");
			return;
		}
		String productId = req.getParameter("product_id");
		int id =0;
		try {
			id=Integer.parseInt(productId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.sendRedirect("productlist");
			return;
		}
		if(id==0){
			resp.sendRedirect("productlist");
			return;
		}
		Product product = productService.getProductById(id);
		if(product.getProductId()!=id){
			resp.sendRedirect("productlist");
			return;
		}
		int shop = -1;
		try {
			shop=Integer.parseInt(shopId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(shop!=product.getShopId()){
			resp.sendRedirect("myshop");
			return;
		}
		req.setAttribute("product_id", product.getProductId());
		req.setAttribute("image", product.getPicture());
		req.setAttribute("productName", product.getName());
		req.setAttribute("price", product.getPrice());
		req.setAttribute("discount_pirce", product.getDiscountPrice());
		req.setAttribute("stockNum", product.getStockNum());
		req.setAttribute("description", product.getDescription());
		req.getRequestDispatcher("/WEB-INF/shopowner/modify_products.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	}
}
