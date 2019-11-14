package com.yc.uglygroup.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.uglygroup.util.StringUtil;


/**
 * 编码集过滤器
 * @author 12412
 *
 */
@WebFilter(value="/*", initParams={@WebInitParam(name="encoding", value="utf-8")})
public class CharacterEncodingFilter implements Filter{

	private String encoding = "utf-8";
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		
		//交给下一个过滤器过滤
		arg2.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		String temp = arg0.getInitParameter("encoding");
		if (!StringUtil.checkNull(temp)) {
			encoding = temp;
		}
	}

}
