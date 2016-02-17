/**
 * 
 */
package com.eej.utilities.controller;

import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eej.utilities.messages.CustomReloadableResourceBundleMessageSource;


/**
 * @author doibalmi
 *
 */
@Controller
public class InternationalizationMessageController {

	private Map<String,Properties> internacionalizationProperties;
	
	@Autowired
	private ReloadableResourceBundleMessageSource messageSource;
	
	private String requestMapping;
	
	@RequestMapping({"/i18n/messages.json","/i18n/messages.properties"})
	public @ResponseBody Properties getInternationalizationMessageBundle(){
		//return this.internacionalizationProperties.get(LocaleContextHolder.getLocale());
		return ((CustomReloadableResourceBundleMessageSource)messageSource).getProperties(LocaleContextHolder.getLocale());
	}
	
}
