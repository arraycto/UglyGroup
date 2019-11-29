package com.yc.uglygroup.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.uglygroup.biz.IFoodTypesBiz;
import com.yc.uglygroup.biz.IResfoodtypebiz;
import com.yc.uglygroup.biz.impl.FoodTypesBizImpl;
import com.yc.uglygroup.biz.impl.ResfoodtypeBizlmpl;
import com.yc.uglygroup.entity.FoodTypes;
import com.yc.uglygroup.entity.ResFoodType;


@WebServlet("/ResfoodtypeServlet")
public class ResfoodtypeServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("findAllTypes".equals(op)) {
			findAllTypes(request, response);
		}else if("addTypes".equals(op)){
			addTypes(request, response);
		}
		}
	
	/**
	 * 查找所有店铺美食类型
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
		private void findAllTypes(HttpServletRequest request, HttpServletResponse response) throws IOException {
			int rid = Integer.parseInt(request.getParameter("rid"));
			IResfoodtypebiz Resfoodtypebiz = new ResfoodtypeBizlmpl();
			List<ResFoodType> list = Resfoodtypebiz.findAllTypes(rid);
			this.send(response, list);
		}
		/**
		 * 添加店铺美食类型
		 * @param request
		 * @param response	
		 * @throws IOException 
		 */
	private void addTypes(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("添加操作");
		IResfoodtypebiz iResfoodtypebiz = new ResfoodtypeBizlmpl();
		int rid = Integer.parseInt(request.getParameter("rid"));
		String trtype = request.getParameter("trtype");
		int result = iResfoodtypebiz.addTypes(rid, trtype);
		this.send(response, result);
	}

}
