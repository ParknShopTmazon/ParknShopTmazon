package com.tmazon.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.Product;
import com.tmazon.domain.User;
import com.tmazon.service.CartService;
import com.tmazon.service.ProductService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.ParseUtil;

import net.sf.json.JSONObject;

public class AddCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private CartService cartService = BasicFactory.getImpl(CartService.class);
	private ProductService productService = BasicFactory.getImpl(ProductService.class);
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(AttrName.SessionScope.USER);
		
		JSONObject jsonObject = new JSONObject();
		
		if(user == null){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "You're already offline!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		
		@SuppressWarnings("unchecked")
		Map<String, String[]> params = req.getParameterMap();
		if(params.get("sid") == null){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Can't get product id, please try it again!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		if(params.get("quantity") == null){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Can't get quantity, please try it again!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		
		String productIdString = params.get("sid")[0];
		String quantityString = params.get("quantity")[0];
		if (productIdString == null || productIdString.isEmpty() || productIdString == "") {
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Can't get product id, please try it again!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		if(quantityString == null || quantityString.isEmpty() || quantityString == ""){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Can't get quantity, please try it again!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		
		int productId = ParseUtil.String2Integer(productIdString, null);
		int quantity = ParseUtil.String2Integer(quantityString, null);
		if(cartService.isExists(user.getUserId(), productId)){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Product(ID:" + productId +") already in cart!");
		}else {
			Product product = productService.getProductById(productId);
			if(product.getStockNum().intValue() < quantity){
				jsonObject.put("result", false + "");
				jsonObject.put("errMsg", "Low stock(product id : " + productId + ")!");
			}else if (quantity == 0) {
				jsonObject.put("result", false + "");
				jsonObject.put("errMsg", "Quantity must be more than 0!");
			}else {
				boolean flag = cartService.addProduct(user.getUserId(), productId, quantity);
				jsonObject.put("result", flag + "");
				if(flag == true){
					jsonObject.put("errMsg", "");
				}else {
					jsonObject.put("errMsg", "Failed,please try it again!");
				}
			}
		}
		
		resp.getWriter().write(jsonObject.toString());
		
	}
	
}
