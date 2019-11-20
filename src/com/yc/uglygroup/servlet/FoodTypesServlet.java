package com.yc.uglygroup.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.uglygroup.biz.IFoodTypesBiz;
import com.yc.uglygroup.biz.impl.FoodTypesBizImpl;
import com.yc.uglygroup.entity.FoodTypes;

@WebServlet("/foodtypes")
public class FoodTypesServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("findAllTypes".equals(op)) {
			findAllTypes(request, response);
		}
	}
	/**
	 * 查询所有美食类型
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void findAllTypes(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IFoodTypesBiz foodTypesBiz = new FoodTypesBizImpl();
		List<FoodTypes> list = foodTypesBiz.findAllTypes();
		this.send(response, list);
	}
}
