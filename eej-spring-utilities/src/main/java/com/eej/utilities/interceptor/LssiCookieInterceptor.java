/**
 * 
 */
package com.eej.utilities.interceptor;

import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author doibalmi
 *
 */
public class LssiCookieInterceptor implements HandlerInterceptor {

	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	public static final String LSSI_ACCEPT_COOKIE_NAME = "lssiCeAcceptCookieName";
	
	private String cookieName;

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object arg2) throws Exception {
				
		boolean found = false;
		if(req.getCookies() != null && req.getCookies().length > 0){
			String cookieName = LSSI_ACCEPT_COOKIE_NAME;
			for(Cookie cookie: req.getCookies()){
				if(cookie.getName().equals(cookieName)){
					found = true;
					break;
				}
			}
		}
		if(found){
			req.setAttribute("includeLssiCe", Boolean.TRUE);
		}
		return true;
	}

	/**
	 * @return the cookieName
	 */
	public String getCookieName() {
		return cookieName;
	}

	/**
	 * @param cookieName the cookieName to set
	 */
	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}
	
	

}
