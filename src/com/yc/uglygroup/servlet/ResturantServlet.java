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
		if ("addRestaurant".equals(op)) { // 注册店铺
			addRestaurant(request,response);
		} else if ("uploadPic".equals(op)) { // 上传店铺图片
			uploadPic(request,response);
		} else if ("findByPage".equals(op)) { // 查询店铺信息
			findByPage(request,response);
		} else if ("allow".equals(op)) { // 批准店铺申请
			allow(request,response);
		} else if ("refuse".equals(op)) { // 驳回店铺申请
			refuse(request,response);
		} else if ("delete".equals(op)) { // 驳回店铺申请
			delete(request,response);
		} else if("findres".equals(op)){
			findres(request,response);
		}
	}

	private void findres(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user  = (com.yc.uglygroup.entity.User)request.getSession().getAttribute("user");
		int uid =Integer.valueOf(user.getUid());
		System.out.println(uid);
		IRestaurantBiz biz = new RestaurantBizImpl();
		int result;
		Map<String, String> restaurant = biz.findres(uid);
		if(restaurant != null){
			result = 1;
			request.getSession().setAttribute("restaurant", restaurant);
		}else{
			result = -1;
		}
		this.send(response, result);

	}

	
	/**
	 * 删除店铺，将店铺的状态改为 3.已删除 
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int rid = Integer.parseInt(request.getParameter("rid"));
		IRestaurantBiz restaurantBiz = new RestaurantBizImpl();
		this.send(response, restaurantBiz.updateState(3, rid));
	}

	/**
	 * 店铺审核通过，将店铺的状态改为1.休息中
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void allow(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int rid = Integer.parseInt(request.getParameter("rid"));
		IRestaurantBiz restaurantBiz = new RestaurantBizImpl();
		this.send(response, restaurantBiz.updateState(1, rid));
	}
	
	/**
	 * 店铺审核通过，将店铺的状态改为4.未通过
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void refuse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int rid = Integer.parseInt(request.getParameter("rid"));
		IRestaurantBiz restaurantBiz = new RestaurantBizImpl();
		this.send(response, restaurantBiz.updateState(4, rid));
	}

	/**
	 * 分页查询店铺信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void findByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IRestaurantBiz restaurantBiz = new RestaurantBizImpl();
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		Object[] rstate = request.getParameter("rstate").split("/");
		this.send(response, restaurantBiz.findByPage(page, rows, rstate));
	}

	/**
	 * 添加店铺信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
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
