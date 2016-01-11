package com.tmazon.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.dao.AdvertisementDao;
import com.tmazon.domain.Advertisement;
import com.tmazon.domain.Product;
import com.tmazon.domain.ShowAd;
import com.tmazon.service.AdvertisementService;
import com.tmazon.service.ProductService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;

public class IndexServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProductService productService = BasicFactory.getImpl(ProductService.class);
	private AdvertisementService advertisementService = BasicFactory.getImpl(AdvertisementService.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String[] categories = productService.findAllCategory();
		req.setAttribute(AttrName.RequestScope.CATEGORIES, categories);
		List<Advertisement> adList =  advertisementService.getAdList();
		List<ShowAd> showAdList = advertisementService.getShowAd(adList);
//		List<Product> productList = new ArrayList<Product>();
//		for(ShowAd showAd : showAdList)
//		{
//			productList.add(showAd.getProduct());
//		}
		List<String> category = new  ArrayList<String> ();
		category.add("Audio");
		category.add("Cameras & Camcorders");
		category.add("Car Electronics & GPS");
		category.add("Cell Phones");
		category.add("Computers & Tablets");
		category.add("Health, Fitness & Sports");
		category.add("Home & Office");
		category.add("TV& Home Theater");
		category.add("Video, Games, Movies & Music");
		String ca = req.getParameter("category");
		Integer caNum;
	
		if(ca == null || ca.equals(""))
		{
			ca = null;
		}
		else
		{
			ca = category.get(Integer.valueOf(ca));
		}
		List<Product> products = productService.select(new Product(null, null, null, null, null, ca , null, null, null, null, null));
		System.out.println(req.getAttribute("category"));
		for(Product product : products)
		{
			System.out.println(product);
		}
		
		
		
		products.sort(new Comparator<Product>() {

			public int compare(Product o1, Product o2) {
				return o2.getSoldNum() - o1.getSoldNum();
			}
			
		});
		req.setAttribute(AttrName.RequestScope.PRODUCTS, products);
//		req.setAttribute("productList2",productList);
		req.setAttribute("showAdList",showAdList);
		req.getRequestDispatcher("WEB-INF/customer/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
