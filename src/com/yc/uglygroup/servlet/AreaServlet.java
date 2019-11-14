package com.yc.uglygroup.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.uglygroup.biz.IAreaBiz;
import com.yc.uglygroup.biz.impl.AreaBizImpl;
import com.yc.uglygroup.entity.Area;

@WebServlet("/area")
public class AreaServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("getArea".equals(op)) {
			getArea(request, response);
		}
	}

	private void getArea(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IAreaBiz areaBiz = new AreaBizImpl();
		List<Area> list = areaBiz.getArea();
		this.send(response, list);
	}
}
