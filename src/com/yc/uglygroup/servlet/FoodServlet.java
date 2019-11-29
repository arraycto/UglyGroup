package com.yc.uglygroup.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.yc.uglygroup.biz.IFoodBiz;
import com.yc.uglygroup.biz.IRestaurantBiz;
import com.yc.uglygroup.biz.impl.FoodBizlmpl;
import com.yc.uglygroup.biz.impl.RestaurantBizImpl;
import com.yc.uglygroup.entity.Foods;
import com.yc.uglygroup.entity.Restaurant;
import com.yc.uglygroup.util.FileUploadUtil;
import com.yc.uglygroup.util.StringUtil;

@WebServlet("/foods")
public class FoodServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String op = request.getParameter("op");
			if ("addfoods".equals(op)) {//添加美食
				addfoods(request, response);
			}else if("findfood".equals(op)) {//查询食品 和店铺名字
				findfood(request,response);
			}else if("findfoods".equals(op)){
				findfoods(request, response);
			}else if("findAllfood".equals(op)){
				findAllfood(request, response);
			}else if("foodup".equals(op)){
				foodup(request, response);
			}else if("fooddelete".equals(op)){
				fooddelete(request, response);
			}
		}
		/**
<<<<<<< HEAD
		 * 查询食品 和店铺名字
=======
		 * 店铺美食删除
		 * @param request
		 * @param response
		 * @throws IOException 
		 */
		private void fooddelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
			Integer fid = Integer.parseInt(request.getParameter("fid"));
			IFoodBiz biz = new FoodBizlmpl();
			int result = biz.fooddelete(fid);
			this.send(response, result);
		}
		/**
		 * 修改店铺美食
		 * @param request
		 * @param response
		 * @throws IOException 
		 */
		private void foodup(HttpServletRequest request, HttpServletResponse response) throws IOException {
			Integer trid = Integer.parseInt(request.getParameter("trid"));
			Integer fid = Integer.parseInt(request.getParameter("fid"));
			String fname = request.getParameter("fname");
			Double fprice = Double.parseDouble(request.getParameter("fprice"));
			IFoodBiz biz = new FoodBizlmpl();
			int result = biz.foodup(fid, fname, fprice, trid);
			this.send(response, result);
		}
		/**
		 * 查询所有店铺美食
		 * @param request
		 * @param response
		 * @throws IOException 
		 */
		private void findAllfood(HttpServletRequest request, HttpServletResponse response) throws IOException {
			Integer rid = Integer.parseInt(request.getParameter("rid"));
			IFoodBiz foodsbiz = new FoodBizlmpl();
			List<Foods> food = foodsbiz.findAllfood(rid);
			this.send(response, food);
		}
		/**
		 * 查询食品
>>>>>>> dd68adf83cb0cec312d97d4b6ce87a3dc9c6f6ee
		 * @param request
		 * @param response
		 * @throws IOException 
		 */
		private void findfood(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String str = request.getParameter("str");
			System.out.println(str);
			IFoodBiz foodsbiz = new FoodBizlmpl();
			List<Foods> list = foodsbiz.findfood(str);
			System.out.println(list.size());
			IRestaurantBiz restaurantbiz = new RestaurantBizImpl();
			List<Restaurant> list1 = restaurantbiz.findrestaurantname(str);
			System.out.println(list1.size());
			if(list.size() == 0) { //判断食物是否为空
				if(list1.size() == 0) { //判断店名
					System.out.println("店名为空");
					this.send(response, null);
				}else {
					Iterator<Restaurant> iter = list1.iterator();
					Restaurant res =  iter.next();
						if(res.getRname().indexOf(str) >= 0){//判断是否是店名
							this.send(response, list1);
						}this.send(response, null);
				}
			}else {
				if(list1.size() == 0) {
					Iterator<Foods> iter = list.iterator();
					Foods s =  iter.next();
					if(s.getFname().indexOf(str) >= 0) {//判断是否是美食名字
						this.send(response, list);
					}this.send(response, null);
				}else {
					Iterator<Restaurant> iter1 = list1.iterator();
					Restaurant res =  iter1.next();
					Iterator<Foods> iter = list.iterator();
					Foods s =  iter.next();
					if(s.getFname().indexOf(str) >= 0) {//判断是否是美食名字
						this.send(response, list);
					}else if(res.getRname().indexOf(str) >= 0){//判断是否是店名
						this.send(response, list1);
					}
					this.send(response, null);
				}
				
				
			}
			
			
	
			}
		/**
		 * 分页查询美食的方法
		 * @param request
		 * @param response
		 * @throws IOException 
		 * @throws NumberFormatException 
		 */
		private void findfoods(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, IOException {
			String rid = request.getParameter("rid");
			IFoodBiz foodBiz = new  FoodBizlmpl();
			if(StringUtil.checkNull(rid)){
				return;
			}
			List<Map<String,String>>  foodshows =foodBiz.findfoods(Integer.parseInt(rid), 1, 5);
			this.send(response, foodshows);
			
		}
		/**
		* 添加商铺美食的方法
		* @param request
		* @param response
		 * @throws IOException 
		*/
		private void addfoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
			FileUploadUtil fuu = new FileUploadUtil();
			PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
			Map<String, String> map = fuu.upload(pageContext);
			IFoodBiz biz = new FoodBizlmpl();
			this.send(response, biz.addfood(map));
		}
	}
