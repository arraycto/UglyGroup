package com.yc.uglygroup.listener;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.yc.uglygroup.util.FileUploadUtil;



@WebListener
public class InitListener implements ServletContextListener{
	
	private String path = "files";
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext servletContext = arg0.getServletContext();
		String temp = servletContext.getInitParameter("uploadPic");
		if (temp != null && !"".equals(temp)) {
			path = temp;
		}
		
		//判断这个路径是否存在
		String basepath = servletContext.getRealPath("/"); // 当前项目在服务器的绝对路径
		File file = new File(new File(basepath).getParentFile(), path);
		if (!file.exists()) {
			file.mkdirs();
		}
		FileUploadUtil.PICPATH = "../" + path;
		
		
		temp = servletContext.getInitParameter("uploadVideo");
		if (temp != null && !"".equals(temp)) {
			path = temp;
		}
		file = new File(new  File(basepath).getParentFile(), path);
		if (!file.exists()) {
			file.mkdirs();
		}
		FileUploadUtil.VIDEOPATH = "../" + path;
	}

}
