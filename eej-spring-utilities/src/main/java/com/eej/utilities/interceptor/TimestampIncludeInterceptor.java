/**
 * 
 */
package com.eej.utilities.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author DOIBALMI
 *
 */
public class TimestampIncludeInterceptor extends HandlerInterceptorAdapter implements HandlerInterceptor {

	public static final String DEFAULT_TIMESTAMP_PARAM_NAME = "ts";
	
	private String timestampParamName = DEFAULT_TIMESTAMP_PARAM_NAME;
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//modelAndView.addObject(this.timestampParamName, System.currentTimeMillis());
		request.setAttribute(this.timestampParamName, System.currentTimeMillis());
		super.postHandle(request, response, handler, modelAndView);
	}

	public String getTimestampParamName() {
		return timestampParamName;
	}

	public void setTimestampParamName(String timestampParamName) {
		this.timestampParamName = timestampParamName;
	}
	
	
}
