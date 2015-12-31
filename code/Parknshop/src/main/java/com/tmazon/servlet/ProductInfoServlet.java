package com.tmazon.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.Product;
import com.tmazon.domain.ProductInfo;
import com.tmazon.domain.Shop;
import com.tmazon.domain.User;
import com.tmazon.service.CartService;
import com.tmazon.service.ProductService;
import com.tmazon.service.ShopService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.ParseUtil;


public class ProductInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private CartService cartService = BasicFactory.getImpl(CartService.class);
	private ShopService shopService = BasicFactory.getImpl(ShopService.class);
	private ProductService productService = BasicFactory.getImpl(ProductService.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(AttrName.SessionScope.USER);
		if(user != null){
			req.setAttribute("user", user);
			req.setAttribute("isLogin", true);
		}
		
		
		
		@SuppressWarnings("unchecked")
		Map<String, String[]> params = req.getParameterMap();
		if(params == null ){
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/customer/product_information.jsp");
			requestDispatcher.forward(req, resp);
			return;
		}
		String productIdStrings[] = params.get("pid");
		if(productIdStrings == null){
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/customer/product_information.jsp");
			requestDispatcher.forward(req, resp);
			return;
		}
		String productIdString = productIdStrings[0];
		
		int productId = ParseUtil.String2Integer(productIdString, null);
		
		
		boolean existsFlag = false;
		String[] quantityStrings = params.get("quantity");
		Product product = productService.getProductById(productId);
		if(product != null && user != null){
			if(quantityStrings != null){
				String quantityString = new String();
				quantityString = quantityStrings[0];
				if(quantityString != null){
					int quantity = ParseUtil.String2Integer(quantityString, 1);
					if(quantity != 0)
						existsFlag = cartService.addProduct(user.getUserId(), productId, quantity);
				}
			}
		}
		
		
		if(product != null){
			req.setAttribute("product", product);
			ProductInfo productInfo = productService.getProductInfo(productId);
			if(productInfo != null){
				req.setAttribute("productInfo", productInfo);
			}
			Shop shop = shopService.findById(product.getShopId());
			req.setAttribute("shop", shop);
			if(existsFlag){
				req.setAttribute("isExists", true);
			}else if(user != null){
				if(cartService.isExists(user.getUserId(), productId)){
					req.setAttribute("isExists", true);
				}else {
					req.setAttribute("isExists", false);
				}
			}
			if(product.getStatus() == null){
				req.setAttribute("expired", false);
			}else {
				if(product.getStatus().equals(Product.STATUS_PULL)){
					req.setAttribute("expired", true);
				}else {
					req.setAttribute("expired", false);
				}
			}
			
		}
		
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/customer/product_information.jsp");
		requestDispatcher.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	
}
