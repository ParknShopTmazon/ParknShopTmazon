package com.tmazon.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmazon.domain.Product;
import com.tmazon.domain.ProductInfo;
import com.tmazon.domain.Shop;
import com.tmazon.service.ProductService;
import com.tmazon.service.ShopService;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.ParseUtil;

import net.sf.json.JSONObject;

public class ProductInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ShopService shopService = BasicFactory.getImpl(ShopService.class);
	private ProductService productService = BasicFactory.getImpl(ProductService.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		JSONObject jsonObject = new JSONObject();
		@SuppressWarnings("unchecked")
		Map<String, String[]> params = req.getParameterMap();
		if(params == null ){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Can't get product id, please try it again!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		String productIdStrings[] = params.get("pid");
		if(productIdStrings == null){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Can't get product id, please try it again!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		String productIdString = productIdStrings[0];
		
		int productId = ParseUtil.String2Integer(productIdString, null);
		Product product = productService.getProductById(productId);
		if(product != null){
			jsonObject.put("pid", product.getProductId());
			jsonObject.put("name", product.getName());
			jsonObject.put("origin_price", ParseUtil.Price2String(product.getPrice()));
			jsonObject.put("price", ParseUtil.Price2String(product.getDiscountPrice()));
			jsonObject.put("stock", product.getStockNum());
			ProductInfo productInfo = productService.getProductInfo(productId);
			if(productInfo != null){
				jsonObject.put("size", productInfo.getSize());
				jsonObject.put("color", productInfo.getColor());
			}else {
				jsonObject.put("size", "");
				jsonObject.put("color", "");
			}
			jsonObject.put("pro_pic", product.getPicture());
			jsonObject.put("description", product.getDescription());
			
			Shop shop = shopService.findById(product.getShopId());
			jsonObject.put("shop_name", shop.getName());
			jsonObject.put("shop_url", "#");
			
			
		}
		
		resp.getWriter().write(jsonObject.toString());
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	
}
