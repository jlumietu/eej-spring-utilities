/**
 * 
 */
package com.eej.utilities.controller;

import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;

import com.eej.utilities.model.DataTableTagModel;
import com.eej.utilities.model.DataTableTagModelConfiguration;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public abstract class CategorizedDataTableEntityController extends
		DataTableEntityController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	public abstract String getTagModelConfigurationKey();

	public DataTableTagModelConfiguration getTagModelConfiguration(){
		return this.getTagModelConfiguration(this.getTagModelConfigurationKey());
	}
	
	/* (non-Javadoc)
	 * @see com.ib.utilities.controller.DataTableEntityController#getTagModelConfiguration(java.lang.String)
	 */
	@Override
	public DataTableTagModelConfiguration getTagModelConfiguration(
			String entityKey) {
		try{
			return this.getDataTableCollectionContainer().getModelConfiguration(entityKey, this.getTagModelConfigurationKey());
		}catch(Exception e){
			logger.error("Error recovering " + entityKey + " dataTableTagModelConfiguration: " + e.getMessage());
			return this.getDataTableTagModelConfigurationFactory().getDataTableTagModelBaseConfiguration();
		}
	}

	/* (non-Javadoc)
	 * @see com.ib.utilities.controller.DataTableEntityController#getDataTableListContainerView(org.springframework.ui.ModelMap, java.lang.String)
	 */
	@Override
	public String getDataTableListContainerView(ModelMap model, String entityKey) {
		try{
			DataTableTagModel tagModel = this.getDataTableCollectionContainer().getModel(entityKey, this.getTagModelConfigurationKey());
			if(tagModel == null){
				throw new NullPointerException("tagModel is null");
			}
			model.addAttribute("dataTableTagModel", tagModel);
		}catch(Throwable t){
			logger.error("Error : " + t.getMessage(), t);
			//return this.getTagModelConfiguration(entityKey).getPageNotFoundUri();
			return this.getDataTableTagModelConfigurationFactory().getDataTableTagModelBaseConfiguration().getPageNotFoundUri();
		}				
		return this.getTagModelConfiguration(entityKey).getListView();
	}

	

	

}
