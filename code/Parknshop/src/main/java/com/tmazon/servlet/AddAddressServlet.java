package com.tmazon.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmazon.domain.Address;
import com.tmazon.domain.User;
import com.tmazon.service.AddressService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;

import net.sf.json.JSONObject;

public class AddAddressServlet extends HttpServlet {
	
	private AddressService addressService = BasicFactory.getImpl(AddressService.class);

	private static final long serialVersionUID = 1L;

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
		
		if(params.get("description") == null){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Description cannot be empty!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		if(params.get("zipcode") == null){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Zipcode cannot be empty!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		if(params.get("name") == null){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "The NAME of the recipient cannot be empty!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		if(params.get("phone") == null){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "The PHONE of the recipient cannot be empty!");
			resp.getWriter().write(jsonObject.toString());
			return;
		}
		
		String description = params.get("description")[0];
		String zipcode = params.get("zipcode")[0];
		String name = params.get("name")[0];
		String phone = params.get("phone")[0];
		
		Address address = new Address(null, user.getUserId(), description, zipcode, name, phone);
		
		if(addressService.insertAddress(address) == null){
			jsonObject.put("result", false + "");
			jsonObject.put("errMsg", "Failed,please try it again!");
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
