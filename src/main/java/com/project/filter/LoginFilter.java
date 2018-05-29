package com.project.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 过滤器
 * @author howroad
 * @Date 2018年4月3日
 * @version 1.0
 */
@WebFilter(filterName="LoginFilter",urlPatterns="*.jsp")
public class LoginFilter implements Filter {
	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req =(HttpServletRequest)request;
		HttpServletResponse resp =(HttpServletResponse)response;
		//如果有session对象,且session中有user记录才可以登陆
		if(req.getSession(false) != null && req.getSession(false).getAttribute("session_user") != null) {
			chain.doFilter(req, resp);
		}else {
			resp.sendRedirect(req.getContextPath()+"/html/login.html");
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("注册过滤器");
	}
}
