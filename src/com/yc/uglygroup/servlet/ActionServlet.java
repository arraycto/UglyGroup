package com.yc.uglygroup.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.uglygroup.biz.IActiondetailBiz;
import com.yc.uglygroup.biz.impl.ActiondetailBizlmpl;


@WebServlet("/action")
public class ActionServlet extends BasicServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("addmj".equals(op)) {
			addmj(request, response);
		}else if("adddz".equals(op)){
			adddz(request, response);
		}
	}
	/**
	 * 打折活动
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void adddz(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String rid = request.getParameter("rid");
		String actype = request.getParameter("actype");
		String discount = request.getParameter("discount");
		String acnum = request.getParameter("acnum");
		String fids = request.getParameter("fids");
		String[] fid =fids.split("/");
		int count = 0;//活动失败的菜的数量
		IActiondetailBiz biz = new ActiondetailBizlmpl();
		String acid =("action"+ (int)((Math.random()*9+1)*10000) + rid ).toString();//活动编号 action+5位随机数 + rid
		for (int i = 0; i < fid.length; i++) {
			int ruselt = biz.adddz(acid, Integer.parseInt(rid), Integer.parseInt(actype), Integer.parseInt(discount), Integer.parseInt(acnum), Integer.parseInt(fid[i]));
			if(!(ruselt>0)){
				count++;
			}
		}
		this.send(response, count);

	}
	/**
	 * 满减活动
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void addmj(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String rid = request.getParameter("rid");
		String actype = request.getParameter("actype");
		String lowmin = request.getParameter("lowmin");
		String remoney = request.getParameter("remoney");
		String fids = request.getParameter("fids");
		String[] fid =fids.split("/");
		int count = 0;//活动失败的菜的数量
		IActiondetailBiz biz = new ActiondetailBizlmpl();
		String acid =("action"+ (int)((Math.random()*9+1)*10000) + rid ).toString();//活动编号 action+5位随机数 + rid
		for (int i = 0; i < fid.length; i++) {
			int ruselt = biz.addmj(acid, Integer.parseInt(rid), Integer.parseInt(actype), Integer.parseInt(lowmin), Integer.parseInt(remoney), Integer.parseInt(fid[i]));
			if(!(ruselt>0)){
				count++;
			}
		}
		this.send(response, count);
	}
}
