package com.yc.uglygroup.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.yc.uglygroup.biz.IFoodBiz;
import com.yc.uglygroup.biz.impl.FoodBizlmpl;
import com.yc.uglygroup.entity.Foods;
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
			}else if("findfood".equals(op)) {
				findfood(request,response);
			}else if("findfoods".equals(op)){
				findfoods(request, response);
			}
		}
		/**
		 * 查询食品
		 * @param request
		 * @param response
		 * @throws IOException 
		 */
		private void findfood(HttpServletRequest request, HttpServletResponse response) throws IOException {
			IFoodBiz foodsbiz = new FoodBizlmpl();
			List<Foods> list = foodsbiz.findfood();
			this.send(response, list);
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
