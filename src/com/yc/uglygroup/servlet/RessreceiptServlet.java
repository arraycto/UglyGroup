package com.yc.uglygroup.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Synthesizer;

import com.yc.uglygroup.dao.IRessreceiptDao;
import com.yc.uglygroup.dao.impl.RessreceiptDaolmpl;
import com.yc.uglygroup.util.StringUtil;

@WebServlet("/ressreceipt")
public class RessreceiptServlet extends BasicServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("findress".equals(op)) {//查询收货地址
			findress(request, response);
		}else if("address".equals(op)){
			address(request, response);

		}else if("findarea".equals(op)){
			findarea(request, response);

		}
	}
	/**
	 * 查询区域
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void findarea(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IRessreceiptDao dao = new RessreceiptDaolmpl();
		List<Map<String, String>> result =dao.findarea();
		this.send(response, result);
	}
	/**
	 * 添加收货地址
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void address(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uid = request.getParameter("uid");
		String arname = request.getParameter("arname");
		String artel = request.getParameter("artel");
		String aradd = request.getParameter("aradd");
		IRessreceiptDao dao = new RessreceiptDaolmpl();
		if(StringUtil.checkNull(uid)){
			return;
		}
		int result =dao.address(Integer.parseInt(uid), arname, artel, aradd);
		this.send(response, result);
		
	}

	/**
	 * 查询收货地址
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void findress(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uid = request.getParameter("uid");
		IRessreceiptDao dao = new RessreceiptDaolmpl();
		if(StringUtil.checkNull(uid)){
			return;
		}
		List<Map<String,String>>  ressreceipt =dao.findress(Integer.parseInt(uid));
		this.send(response, ressreceipt);
	}
}
