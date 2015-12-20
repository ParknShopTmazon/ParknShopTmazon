package com.tmazon.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.Delivery;
import com.tmazon.domain.Product;
import com.tmazon.domain.ProductInfo;
import com.tmazon.domain.User;
import com.tmazon.service.CartService;
import com.tmazon.service.DeliveryService;
import com.tmazon.service.ProductService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.ParseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ShowCartInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ProductService productService = BasicFactory.getImpl(ProductService.class);
	private CartService cartService = BasicFactory.getImpl(CartService.class);
	private DeliveryService deliveryService = BasicFactory.getImpl(DeliveryService.class);

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(AttrName.SessionScope.USER);
		JSONObject jsonObject = new JSONObject();
		
		//cart
		if (user == null) {
			jsonObject.put("cid", "");
			jsonObject.put("uid", "");
		} else {
			List<Map<String, Integer>> list = cartService.getProductIdANDQuantity(user);
			jsonObject.put("cid", user.getUserId());
			jsonObject.put("uid", user.getUserId());
			
			JSONArray cart = new JSONArray();
			
			for(int i = 0, size = list.size(); i < size; i++){
				int productId = list.get(i).get(AttrName.CartServiceImplMapGet.PRODUCT_ID);
				int quantity = list.get(i).get(AttrName.CartServiceImplMapGet.QUANTITY);
				
				Product product = productService.getProductById(productId);
				ProductInfo productInfo = productService.getProductInfo(productId);
				
				JSONObject item = new JSONObject();
				item.put("sid", product.getProductId());
				item.put("name", product.getName());
				item.put("origin_price", ParseUtil.Price2String(product.getPrice()));
				item.put("price", ParseUtil.Price2String(product.getDiscountPrice()));
				item.put("quantity", quantity);
				item.put("stock", product.getStockNum());
				if(productInfo != null){
					item.put("size", productInfo.getSize());
					item.put("color", productInfo.getColor());
				}else {
					item.put("size", "");
					item.put("color", "");
				}
				
				item.put("shop_url", "");
				item.put("shop_pic", "");
				
				cart.add(item);
				
			}
			jsonObject.put("cart", cart);
			
			//delivery_options
			JSONArray deliveryOptions = new JSONArray();
			List<Delivery> deliverieCompanies = deliveryService.getAllCompany();
			for(int i = 0, size = deliverieCompanies.size(); i < size; i++){
				JSONObject deliveryJson = new JSONObject();
				Delivery deliveryItem = deliverieCompanies.get(i);
				deliveryJson.put("company_name", deliveryItem.getCompany());
				List<Delivery> priceList = deliveryService.select(deliveryItem);
				JSONArray priceOption = new JSONArray();
				for(int ii = 0, sizes = priceList.size(); ii < sizes; ii++){
					JSONObject priceJson = new JSONObject();
					Delivery deliveryPriceItem = priceList.get(ii);
					priceJson.put("delivery_id", deliveryPriceItem.getDeliveryId());
					priceJson.put("value", ParseUtil.Price2String(deliveryPriceItem.getPrice()));
					priceJson.put("description", "delivery price: $" + ParseUtil.Price2String(deliveryPriceItem.getPrice()) + "(" + deliveryPriceItem.getType() + ")");
					priceOption.add(priceJson);
				}
				deliveryJson.put("price_option", priceOption);
				deliveryOptions.add(deliveryJson);
			}
			jsonObject.put("delivery_options", deliveryOptions);
			
		}
		
		resp.getWriter().write(jsonObject.toString());
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};

}
