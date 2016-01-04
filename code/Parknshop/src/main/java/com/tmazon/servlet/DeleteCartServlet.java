package com.tmazon.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.User;
import com.tmazon.service.CartService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.ParseUtil;

import net.sf.json.JSONObject;

public class DeleteCartServlet extends HttpServlet {
	
	private CartService cartService = BasicFactory.getImpl(CartService.class);

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JSONObject jsonObject = new JSONObject();
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(AttrName.SessionScope.USER);
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
		String productIdString = params.get("sid")[0];
		if(productIdString == null || productIdString.isEmpty() || productIdString == ""){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Can't get product id, please try it again!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		
		int productId = ParseUtil.String2Integer(productIdString, null);
		if(!cartService.isExists(user.getUserId(), productId)){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Product(ID:" + productId +") NOT in cart!");
		}else {
			boolean flag = cartService.deleteProduct(user.getUserId(), productId);
			
			jsonObject.put("result", flag + "");
			if(flag == true){
				jsonObject.put("errMsg", "");
			}else {
				jsonObject.put("errMsg", "Delete failed,please try it again!");
			}
		}
		
		resp.getWriter().write(jsonObject.toString());
	}
	
	
	
}
