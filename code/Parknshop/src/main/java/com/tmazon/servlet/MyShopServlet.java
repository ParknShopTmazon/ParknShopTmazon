package com.tmazon.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.w3c.dom.Attr;

import com.tmazon.domain.Order;
import com.tmazon.domain.Shop;
import com.tmazon.domain.User;
import com.tmazon.util.AttrName;
import com.tmazon.util.DaoUtil;

public class MyShopServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	    User loginUser = (User) req.getSession().getAttribute(AttrName.SessionScope.USER);
	    if(loginUser == null){
	    	resp.sendRedirect("login");
	    }else{
	    	
	    	StringBuilder sqlFindShopByUserId=new StringBuilder("select * from shop where owner=");
	    	String sql = sqlFindShopByUserId.append(loginUser.getUserId()).toString();
	    	
	    	QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
	    	
	    	try {
				List<Shop> shopList= runner.query(sql, new BeanListHandler<Shop>(Shop.class));
				List<Shop> shopGetList = new ArrayList<Shop>();
				for(int i=0;i<shopList.size();i++){
					if(!shopList.get(i).getStatus().equals(Shop.STATUS_DELETED)){
						shopGetList.add(shopList.get(i));
					}
				}
				req.setAttribute("shopList", shopGetList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	
	    	req.getRequestDispatcher("/WEB-INF/shopowner/myshop.jsp").forward(req, resp);
	    }
	    
	}
	
}
