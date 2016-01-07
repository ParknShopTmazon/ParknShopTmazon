package com.tmazon.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.domain.Product;
import com.tmazon.domain.Shop;
import com.tmazon.service.ProductService;
import com.tmazon.service.ShopService;
import com.tmazon.util.BasicFactory;


public class SearchProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProductService productService = BasicFactory.getImpl(ProductService.class);
	private ShopService shopService = BasicFactory.getImpl(ShopService.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String category = req.getParameter("type");
		String searchMethod = req.getParameter("searchMethod");
		if ("".equals(category)) {
			category = null;
		}
		
		Product product  =new Product(null, null, name, null, null, category, null, null, null, null);
		
		List<Product> productList = productService.selectInLike(product);
		if(productList==null||productList.isEmpty()){
			req.setAttribute("num", 0);
		}else{
			req.setAttribute("num", productList.size());
			req.setAttribute("productList", productList);
			req.setAttribute("test", 0);
		}
		
		for(int i=0;i<productList.size();i++){
			Product product2 = productList.get(i);
			Shop shop = shopService.findById(product2.getShopId());
			product2.setShop(shop);
			productList.set(i, product2);
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/customer/search_products.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	
}
