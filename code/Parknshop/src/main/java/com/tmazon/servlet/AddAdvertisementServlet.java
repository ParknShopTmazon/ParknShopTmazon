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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.tmazon.dao.AdvertisementDao;
import com.tmazon.dao.impl.AdvertisementDaoImpl;
import com.tmazon.domain.Advertisement;
import com.tmazon.service.AdvertisementService;
import com.tmazon.service.impl.AdvertisementServiceImpl;
import com.tmazon.util.BasicFactory;
import com.tmazon.util.CheckAdmin;
import com.tmazon.util.IOUtil;

public class AddAdvertisementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdvertisementService advertisementService = BasicFactory.getImpl(AdvertisementService.class);
    public AddAdvertisementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!CheckAdmin.isAdminOnline(request))
		{
			response.sendRedirect("login");
			return;
		}
		String costStr;
//		System.out.println(request.getParameter("productId"));
//		System.out.println(costStr);
		Integer cost,productID;
		// add picture
		request.setCharacterEncoding("utf-8"); 
		String contextPath = getServletContext().getRealPath(File.separator+"images_admin"+File.separator);
		String uploadPath =File.separator+ "upload"+File.separator;
		String tmpPath = "tmp"+File.separator;
		String path=null;
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		fileItemFactory.setSizeThreshold(1024 * 1024 * 30);
		fileItemFactory.setRepository(new File(contextPath + tmpPath));
		ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
		List<FileItem> items = null;
		try {
			items = servletFileUpload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		Map<String, String> advMap = new HashMap<String, String>();
		
		for (FileItem item : items)
		{
			if (item.isFormField())
			{
				advMap.put(item.getFieldName(), item.getString("utf-8"));
			}
		}
		
		
		
		for (FileItem item : items)
		{
			if (!item.isFormField() && !item.getName().isEmpty())
			{
				int hashCode = item.hashCode();
				int d1 = hashCode & 0xff;
				int d2 = hashCode >> 8 & 0xff;
				String filePath = contextPath + uploadPath + d1 + File.separator+ d2;
				System.out.println(filePath);
				File file = new File(filePath);
				if (!file.isDirectory())
				{
					file.mkdirs();
				}
				String fileName = UUID.randomUUID().toString()
						+ item.getName().substring(item.getName().lastIndexOf("."));
				File saveFile = new File(file, fileName);

				InputStream is = item.getInputStream();
				FileOutputStream os = new FileOutputStream(saveFile);
				IOUtil.in2out(is, os);
				IOUtil.close(is, os);
				item.delete();
				
				path ="images_admin/upload/"+ d1 + "/" + d2 + "/" + fileName;
			}
		}
		costStr = advMap.get("cost");
		
		productID = Integer.valueOf(advMap.get("productId"));
		
		if(path == null|| "".equals(path))
		{
				path = "images_admin/index.jpg";
		}
		if( costStr == null || costStr.equals(""))
		{
			cost = 0;
		}
		else
		{
			cost = Integer.valueOf(costStr);
		}
		boolean result = advertisementService.addAd(productID,cost,path);
		request.setAttribute("result",result?1:0);
		request.getRequestDispatcher("advertisement").forward(request,response);
		
	}
}
