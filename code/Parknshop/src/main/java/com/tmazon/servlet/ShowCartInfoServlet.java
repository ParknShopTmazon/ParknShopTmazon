package com.tmazon.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ShowCartInfoServlet extends HttpServlet {

	private ProductService productService = BasicFactory.getImpl(ProductService.class);
	private CartService cartService = BasicFactory.getImpl(CartService.class);
	private ShopService shopService = BasicFactory.getImpl(ShopService.class);

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(AttrName.SessionScope.USER);
		JSONObject jsonObject = new JSONObject();
		
		if (user == null) {
			
		} else {
			List<Map<String, Integer>> list = cartService.getProductIdANDQuantity(user);
			jsonObject.put("cid", user.getUserId());
			jsonObject.put("uid", user.getUserId());
			
			JSONArray cart = new JSONArray();
			
			for(int i = 0, size = list.size(); i < size; i++){
				int productId = list.get(i).get(AttrName.CartServiceImplMapGet.PRODUCT_ID);
				int quantity = list.get(i).get(AttrName.CartServiceImplMapGet.QUANTITY);
				
				Product product = productService.getProductById(productId);
				Shop shop = shopService.findById(product.getShopId());
				ProductInfo productInfo = productService.getProductInfo(productId);
				
				JSONObject item = new JSONObject();
				item.put("sid", shop.getShopId());
				item.put("sname", shop.getName());
				item.put("pname", product.getName());
				item.put("origin_price", product.getPrice());
				item.put("price", product.getDiscontPrice());
				item.put("quality", quantity);
				if(productInfo != null){
					item.put("size", productInfo.getSize());
					item.put("color", productInfo.getColor());
				}
				
//				item.put("shop_url", "#");
//				item.put("shop_pic", null);
				
				cart.add(item);
				
			}
			jsonObject.put("cart", cart);
			
		}
		
		resp.getWriter().write(jsonObject.toString());
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	};

}
