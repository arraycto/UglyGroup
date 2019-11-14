package com.yc.uglygroup.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.yc.uglygroup.biz.IRestaurantBiz;
import com.yc.uglygroup.biz.impl.RestaurantBizImpl;
import com.yc.uglygroup.util.FileUploadUtil;

@WebServlet("/resturant")
public class ResturantServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("addRestaurant".equals(op)) {
			addRestaurant(request,response);
		} else if ("uploadPic".equals(op)) {
			uploadPic(request,response);
		}
	}

	private void addRestaurant(HttpServletRequest request, HttpServletResponse response) throws IOException {
		FileUploadUtil fuu = new FileUploadUtil();
		PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
		Map<String, String> map = fuu.upload(pageContext);
		IRestaurantBiz restaurantBiz = new RestaurantBizImpl();
		this.send(response, restaurantBiz.addRestaurant(map));
	}
	
	private void uploadPic(HttpServletRequest request, HttpServletResponse response) throws IOException {
		FileUploadUtil fuu = new FileUploadUtil();
		PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
		Map<String, String> map = fuu.upload(pageContext);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String path = map.get("upload"); // 取出图片的保存路径
		
		resultMap.put("fileName", path.substring(path.lastIndexOf("/") + 1));
		resultMap.put("uploaded", 1);
		resultMap.put("url", "../../" + path);
		
		this.send(response, resultMap);
	}
}
