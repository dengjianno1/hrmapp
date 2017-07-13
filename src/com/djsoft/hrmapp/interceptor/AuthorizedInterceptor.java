package com.djsoft.hrmapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.djsoft.hrmapp.domain.User;
import com.djsoft.hrmapp.util.comman.HrmConstants;
/** 
 * 判断用户权限的Spring MVC的拦截器
 */
public class AuthorizedInterceptor implements HandlerInterceptor {
	/** 定义不需要拦截的请求 */
	private static final String[] IGNORE_URI = {"/loginform", "/login","/"};
	 /** 
     * 该方法需要preHandle方法的返回值为true时才会执行。
     * 该方法将在整个请求完成之后执行，主要作用是用于清理资源。
     */  
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}
	 /** 
     * 这个方法在preHandle方法返回值为true的时候才会执行。
     * 执行时间是在处理器进行处理之 后，也就是在Controller的方法调用之后执行。
     */  
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		/**
		 * 默认用户没有登录
		 */
		boolean isLogin=false;
		/** 获得请求的ServletPath */
		String servletPath = request.getServletPath();
		/**  判断请求是否需要拦截 */
        for (String s : IGNORE_URI) {
            if (servletPath.equals(s)) {
            	isLogin = true;
                break;
            }
        }
        /** 拦截请求 */
        if (!isLogin){
        	/** 1.获取session中的用户  */
        	User user = (User) request.getSession().getAttribute(HrmConstants.USER_SESSION);
        	/** 2.判断用户是否已经登录 */
        	if(user == null){
        		 /** 如果用户没有登录，跳转到登录页面 */
        		request.setAttribute("message", "请先登录再访问网站!");
        		request.getRequestDispatcher(HrmConstants.LOGIN).forward(request, response);
        		return isLogin;
        	}else{
        		 isLogin = true;
        	}
        }
		return isLogin;
	}

}
