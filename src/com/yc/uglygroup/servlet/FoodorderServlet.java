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
import com.yc.uglygroup.entity.User;

@WebServlet("/order")
public class FoodorderServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		
		if ("findByPage".equals(op)) {//查询订单
			findByPage(request, response);
		}else if("ordertransmission".equals(op)){//订单信息传输
			ordertransmission(request, response);
		}else if("getorder".equals(op)){//获取订单信息
			getorder(request, response);
		}
	}
	/**
	 * 订单信息获取
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void getorder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		System.out.println(request.getSession().getAttribute("orderinfo"));
		list = (List<Map<String, String>>)request.getSession().getAttribute("orderinfo");
		if(!list.isEmpty()){
			this.send(response, list);
		}else{
			System.out.println("22222");
		}
		
		
	}
	/**
	 * 订单信息传输
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void ordertransmission(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fids = request.getParameter("fids");//fid集合
		String fpics = request.getParameter("fpics");//fpic集合
		String fnames = request.getParameter("fnames");//fname集合
		String fprices = request.getParameter("fprices");//fprice集合
		String nums = request.getParameter("nums");//num集合
		String prices = request.getParameter("prices");//price集合
		String total = request.getParameter("total");//总价
		String numbers = request.getParameter("numbers");//商品总数量
		String rid = request.getParameter("rid");//店铺

		System.out.println(fids+fpics+fnames+fprices+nums+prices);
		String[] fid =fids.split(",");
		String[] fpic =fpics.split(",");
		String[] fname =fnames.split(",");
		String[] fprice =fprices.split(",");
		String[] num =nums.split(",");
		String[] price =prices.split(",");
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		IFoodorderBiz biz = new FoodorderBizlmpl();
		for (int i = 0; i < fid.length; i++) {
			System.out.println(i);
			System.out.println(fid[i]+ fpic[i]+ fname[i]+fprice[i]+ num[i]+price[i]);
			Map<String,String> map = biz.ordertransmission(fid[i], fpic[i], fname[i], fprice[i], num[i], price[i]);
			list.add(map);
		}
		request.getSession().setAttribute("orderinfo", list);
		this.send(response, 1);
	}
	/**
	 * 查询订单
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void findByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		int  page= Integer.parseInt(request.getParameter("page"));
		int  rows= Integer.parseInt(request.getParameter("rows"));
		IFoodorderBiz biz = new FoodorderBizlmpl();
		List<Map<String,String>> list = biz.findByPage(uid, page, rows);
		this.send(response, list);
	}
}
