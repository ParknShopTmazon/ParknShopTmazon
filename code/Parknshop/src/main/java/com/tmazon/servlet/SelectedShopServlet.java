package com.tmazon.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.domain.Product;
import com.tmazon.domain.Shop;
import com.tmazon.domain.User;
import com.tmazon.service.ProductService;
import com.tmazon.service.ShopService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.ParseUtil;

public class SelectedShopServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductService productService = BasicFactory.getImpl(ProductService.class);
	private ShopService shopService = BasicFactory.getImpl(ShopService.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute(AttrName.SessionScope.USER);
		if(user == null){
			resp.sendRedirect("login");
			return;
		}
		String shopId=req.getParameter("shopId");
		Integer id = ParseUtil.String2Integer(shopId, null);
		if(id!=null){
			req.getSession(true).setAttribute(AttrName.SessionScope.SHOPID,id);
		}
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute(AttrName.SessionScope.USER);
		Integer shopId=(Integer) req.getSession().getAttribute(AttrName.SessionScope.SHOPID);
		Shop shop = shopService.findById(shopId);
		if(shop==null||user==null||!shop.getOwner().equals(user.getUserId())){
			resp.sendRedirect("myshop");
			return;
		}
		Product product = new Product();
		product.setShopId(shopId);
		ArrayList<Product> productList = (ArrayList<Product>) productService.selectOnSell(product);
		req.setAttribute("product_list",productList );
		req.getRequestDispatcher("/WEB-INF/shopowner/shop_homepage.jsp").forward(req, resp);
		return;
	}
}
