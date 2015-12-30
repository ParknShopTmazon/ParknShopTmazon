package com.tmazon.servlet;

import java.io.IOException;
import java.util.List;

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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ShowAddressServlet extends HttpServlet {
	
	private AddressService addressService = BasicFactory.getImpl(AddressService.class);

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(AttrName.SessionScope.USER);
		JSONObject jsonObject = new JSONObject();
		
		if(user == null){
			return;
		}
		
		List<Address> addresses = addressService.getAddress(user);
		JSONArray jsonArray = new JSONArray();
		for(Address address : addresses){
			JSONObject item = new JSONObject();
			item.put("a_id", address.getAddressId());
			item.put("country", address.getCountry());
			item.put("province", address.getProvince());
			item.put("city", address.getCity());
			item.put("description", address.getDescription());
			item.put("zipcode", address.getZipcode());
			item.put("name", address.getName());
			item.put("phone", address.getPhone());
			jsonArray.add(item);
		}
		jsonObject.put("addresses", jsonArray);
		
		resp.getWriter().write(jsonObject.toString());
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	
}
