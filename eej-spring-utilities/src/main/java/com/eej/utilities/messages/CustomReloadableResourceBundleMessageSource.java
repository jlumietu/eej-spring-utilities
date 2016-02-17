/**
 * 
 */
package com.eej.utilities.messages;

import java.util.Locale;
import java.util.Properties;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * @author doibalmi
 *
 */
public class CustomReloadableResourceBundleMessageSource extends
		ReloadableResourceBundleMessageSource {

	/* (non-Javadoc)
	 * @see org.springframework.context.support.AbstractMessageSource#getCommonMessages()
	 */
	@Override
	public Properties getCommonMessages() {
		// TODO Auto-generated method stub
		return super.getCommonMessages();
	}

	/* (non-Javadoc)
	 * @see org.springframework.context.support.ReloadableResourceBundleMessageSource#getMergedProperties(java.util.Locale)
	 */
	@Override
	public PropertiesHolder getMergedProperties(Locale arg0) {
		return super.getMergedProperties(arg0);
	}
	
	/**
	 * 
	 * @param arg0
	 * @return
	 */
	public Properties getProperties(Locale arg0){
		return super.getMergedProperties(arg0).getProperties();
	}
	
	

	
	
}
