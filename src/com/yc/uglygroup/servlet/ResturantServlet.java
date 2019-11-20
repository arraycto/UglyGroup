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
import com.yc.uglygroup.entity.User;
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
		}else if("findres".equals(op)){
			findres(request,response);
		}
	}

	private void findres(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user  = (com.yc.uglygroup.entity.User)request.getSession().getAttribute("user");
		int uid =Integer.valueOf(user.getUid());
		System.out.println(uid);
		IRestaurantBiz biz = new RestaurantBizImpl();
		int result = 0;
		Map<String, String> restaurant = biz.findres(uid);
		if(restaurant != null){
			if(Integer.parseInt(restaurant.get("rstate")) == 0 || Integer.parseInt(restaurant.get("rstate")) == 1){//营业中或休息中
				result = 1;
				request.getSession().setAttribute("restaurant", restaurant);
			}else if(Integer.parseInt(restaurant.get("rstate")) == 2 ){//审核中
				result = 2;
			}else if(Integer.parseInt(restaurant.get("rstate")) == 3 ){//已删除
				result = 3;
			}else if(Integer.parseInt(restaurant.get("rstate")) == 4 ){//未通过
				result = 4;
			}
			
		}else{
			result = -1;
		}
		this.send(response, result);

	}

	private void addRestaurant(HttpServletRequest request, HttpServletResponse response) throws IOException {
		FileUploadUtil fuu = new FileUploadUtil();
		PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
		Map<String, String> map = fuu.upload(pageContext);
		System.out.println(map.get("rdisc"));
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
