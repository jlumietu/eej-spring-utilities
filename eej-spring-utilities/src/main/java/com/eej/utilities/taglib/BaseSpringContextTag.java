/**
 * 
 */
package com.eej.utilities.taglib;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import com.eej.utilities.ApplicationVersion;


/**
 * @author doibalmi
 *
 */
public abstract class BaseSpringContextTag extends RequestContextAwareTag{

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	/*@Autowired
	protected SpringTagAccessEngine springTagAccessEngine;*/

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.tags.RequestContextAwareTag#doStartTagInternal()
	 */
	@Override
	protected int doStartTagInternal() throws Exception {
		/*if (springTagAccessEngine == null) {
            logger.debug("Autowiring the bean");
            WebApplicationContext wac = getRequestContext().getWebApplicationContext();
            AutowireCapableBeanFactory acbf = wac.getAutowireCapableBeanFactory();
            acbf.autowireBean(this);
        }*/
        return SKIP_BODY;
	}
	
	/*protected SpringTagAccessEngine getContextAccessEngine(){
		return springTagAccessEngine;
	}*/
	
	
	
	

}
