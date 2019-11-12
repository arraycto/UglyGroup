package com.yc.uglygroup.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BasicServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	public void send(HttpServletResponse response, int result) throws IOException{
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
	}
	
	public void send(HttpServletResponse response, String string) throws IOException{
		PrintWriter out = response.getWriter();
		out.print(string);
		out.flush();
	}
	
	/**
	 * 以json的格式返回
	 * @param response
	 * @param object
	 * @throws IOException
	 */
	public void send(HttpServletResponse response, Object object) throws IOException{
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().serializeNulls().create();
		out.print(gson.toJson(object));
		out.flush();
	}
}
