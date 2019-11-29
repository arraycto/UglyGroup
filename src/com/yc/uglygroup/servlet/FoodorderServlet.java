package com.yc.uglygroup.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.uglygroup.biz.IFoodorderBiz;
import com.yc.uglygroup.biz.impl.FoodorderBizlmpl;
import com.yc.uglygroup.dao.IFoodorderDao;

@WebServlet("/order")
public class FoodorderServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		
		if ("findByPage".equals(op)) {//添加美食
			findByPage(request, response);
		}
	}
	private void findByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		int  page= Integer.parseInt(request.getParameter("page"));
		int  rows= Integer.parseInt(request.getParameter("rows"));
		IFoodorderBiz biz = new FoodorderBizlmpl();
		List<Map<String,String>> list = biz.findByPage(uid, page, rows);
		System.out.println(list);
		this.send(response, list);
	}
}
