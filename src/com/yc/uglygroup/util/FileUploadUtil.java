package com.yc.uglygroup.util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

@SuppressWarnings("unchecked")
public class FileUploadUtil {
	public static String PICPATH = "pics";
	public static String VIDEOPATH = "video";
	private static final String DENIED = "exe, bat, jsp, html"; //不许上传的文件后缀
	private static final int SINGLEFILESIZE = 1024*1024*1024; //单个文件的最大大小
	private static final int TOTALMAXSIZE = 1024*1024*1024*1024; //每次上传的文件总大小
	
	public Map<String, String> upload(PageContext pageContext){
		Map<String, String> map = new HashMap<String, String>();
		
		try {
			//实例化一个SmartUpload对象
			SmartUpload smartUpload = new SmartUpload();
			
			//初始化
			smartUpload.initialize(pageContext);
			
			//设置参数
			smartUpload.setCharset("utf-8");
			smartUpload.setDeniedFilesList(DENIED); //不允许上传的文件后缀
			smartUpload.setTotalMaxFileSize(TOTALMAXSIZE); 
			smartUpload.setMaxFileSize(SINGLEFILESIZE);
			
			//开始上传
			smartUpload.upload();
			
			//获取请求中的参数
			Request request = smartUpload.getRequest();
			
			//取出请求中的所有非文本域参数
			Enumeration<String> enumeration = request.getParameterNames();
			String name = null;
			
			while (enumeration.hasMoreElements()) {
				name = enumeration.nextElement();
				map.put(name, request.getParameter(name));
			}
			
			//处理请求中的文件
			Files files = smartUpload.getFiles();
			if (files == null || files.getCount() <= 0) {
				return map;
			}
			
			String fileName = null; //上传时的文本域的name属性的属性值
			String fieldName = null;
			String preName = null;
			String pathStr = "";
			String temp = PICPATH;
			
			//取出当期项目在服务器中绝对路径
			String basePath = pageContext .getServletContext().getRealPath("/");
			System.out.println("取出当期项目在服务器中绝对路径" + basePath);
			
			Collection<File> fls = files.getCollection();
			for(File file : fls){ //循环取出每一个文件
				if (!file.isMissing()) {
					fileName = new Date().getTime() + file.getFileName().substring(file.getFileName().length()-4, file.getFileName().length()); //取出上传的文件文件名
					fieldName = file.getFieldName(); // pics video
					System.out.println("取出上传的文件文件名" + fileName);
					System.out.println(fieldName);
					if ("video".equals(fieldName)) {
						temp = VIDEOPATH;
					} else {
						temp = PICPATH;
					}
					
					if (preName == null || preName.equals(fieldName)) {
						preName = fieldName; //preName = pics
					} else { // 说明第一个文件域中的内容已经读取完成
						map.put(preName, pathStr);
						preName = fieldName;
						pathStr = "";
					}
					
					//将图片保存到服务器中
					file.saveAs(basePath + "\\" + temp + "\\" + fileName);
					if (!"".equals(pathStr)) { // 说明以前已经有值
						pathStr += ";";
					}
					pathStr += temp + "/" + fileName;
				}
			}
			map.put(fieldName, pathStr);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
		return map;
	}
}
