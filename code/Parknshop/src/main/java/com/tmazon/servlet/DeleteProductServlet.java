package com.tmazon.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.tmazon.domain.Product;
import com.tmazon.domain.User;
import com.tmazon.service.ProductService;
import com.tmazon.util.AttrName;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.IOUtil;

public class DeleteProductServlet extends HttpServlet{

	private ProductService productService = BasicFactory.getImpl(ProductService.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User userId =  (User) session.getAttribute(AttrName.SessionScope.USER);
		String shopId = (String) session.getAttribute(AttrName.SessionScope.SHOPID);
		if(userId==null){
			resp.sendRedirect("login");
			return;
		}
		String productId = req.getParameter("product_id");
		int id =0;
		try {
			id=Integer.parseInt(productId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.sendRedirect("selectedshop");
			return;
		}
		if(id==0){
			resp.sendRedirect("selectedshop");
			return;
		}
		Product product = productService.findOnSellById(id);
		if(product==null||product.getProductId()==null||product.getProductId()!=id){
			resp.sendRedirect("selectedshop");
			return;
		}
		int shop = -1;
		try {
			shop=Integer.parseInt(shopId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(shop!=product.getShopId()){
			resp.sendRedirect("myshop");
			return;
		}
		req.setAttribute("product_id", product.getProductId());
		req.setAttribute("image", product.getPicture());
		req.setAttribute("productName", product.getName());
		req.setAttribute("category", product.getCategory());
		req.setAttribute("price", product.getPrice());
		req.setAttribute("discount_price", product.getDiscountPrice());
		req.setAttribute("stockNum", product.getStockNum());
		req.setAttribute("description", product.getDescription());
		req.getRequestDispatcher("/WEB-INF/shopowner/delete_products.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		
		System.out.println("**************************");
		String productId = req.getParameter("product_id");
		int id=-1;
		try {
			id=Integer.parseInt(productId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(id==-1){
			resp.sendRedirect("selectedshop");
			return;
		}
		Product product =new Product();
		product.setProductId(id);
		boolean modify = productService.delete(product);
		if(modify==true){
			System.out.println("ÐÞ¸Ä³É¹¦");
		}
		resp.sendRedirect("selectedshop");
	}
}
