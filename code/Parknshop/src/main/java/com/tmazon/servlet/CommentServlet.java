package com.tmazon.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.swing.internal.plaf.basic.resources.basic;
import com.tmazon.domain.Comment;
import com.tmazon.domain.User;
import com.tmazon.service.CommentService;
import com.tmazon.service.OrderService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.ParseUtil;

import net.sf.json.JSONObject;

public class CommentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private OrderService orderService = BasicFactory.getImpl(OrderService.class);
	private CommentService commentService = BasicFactory.getImpl(CommentService.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		
		String[] productIdStrings = params.get("productId");
		String[] contents = params.get("content");
		String[] shopScoreStrings = params.get("shopScore");
		String[] productScoreStrings = params.get("productScore");
		String[] deliveryScoreStrings = params.get("deliveryScore");
		
		if(productIdStrings == null || productIdStrings.length != 1){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Cannot get product,please try it again!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		if(contents == null || contents.length != 1){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Cannot get content,please try it again!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		if(shopScoreStrings == null || shopScoreStrings.length != 1){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Cannot get shop score,please try it again!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		if(productScoreStrings == null || productScoreStrings.length != 1){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Cannot get product score,please try it again!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		if(deliveryScoreStrings == null || deliveryScoreStrings.length != 1){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Cannot get delivery score,please try it again!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		
		String productIdString = productIdStrings[0];
		String content = contents[0];
		String shopScoreString = shopScoreStrings[0];
		String productScoreString = productScoreStrings[0];
		String deliveryScoreString = deliveryScoreStrings[0];
		
		int productId = ParseUtil.String2Integer(productIdString, null);
		
		if(!orderService.isBought(user.getUserId(), productId)){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Never bought this product!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		
		int shopScore = ParseUtil.String2Score(shopScoreString, null);
		int productScore = ParseUtil.String2Score(productScoreString, null);
		int deliveryScore = ParseUtil.String2Score(deliveryScoreString, null);
		
		Comment comment = new Comment(null, user.getUserId(), productId, content, null, shopScore, productScore, deliveryScore, null);
		comment = commentService.addComment(comment);
		if(comment == null){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Failed!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}else {
			jsonObject.put("result", true + "");
			jsonObject.put("errMsg", "");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	
}
