/**
 * 
 */
package com.project.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.project.pojo.TUser;
import com.project.service.IRoleService;

/**
 * @author howroad
 * @Date 2018年5月4日
 * @version 1.0
 */
public class MyInterceptor implements HandlerInterceptor {
	@Autowired
	private IRoleService roleService;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getSession().getAttribute("session_user")==null) {
			response.sendRedirect(request.getContextPath()+"/html/login.html");
			return false;
		}
		if (handler instanceof HandlerMethod) {
			HandlerMethod h = (HandlerMethod) handler;
			MyOperation m = h.getMethod().getDeclaringClass().getAnnotation(MyOperation.class);
			if (m != null) {
				TUser user = (TUser) request.getSession().getAttribute("session_user");
				String userId = user.getUserId();
				// 判断后执行操作...
				System.out.println("执行:" + m.value());
				if(!roleService.checkPower(m.value(), userId)) {
					System.out.println("非法权限!");
					response.sendRedirect(request.getContextPath()+"/jsp/error.jsp");
					return false;
				}
			}
			// 这里可以根据权限做一些判断
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
