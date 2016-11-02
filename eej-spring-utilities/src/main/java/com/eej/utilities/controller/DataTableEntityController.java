/**
 * 
 */
package com.eej.utilities.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import com.eej.utilities.datatables.DataTableBuilder;
import com.eej.utilities.datatables.DataTableBusinessEngine;
import com.eej.utilities.datatables.DataTableCollectionContainer;
import com.eej.utilities.datatables.DataTablePaginationRequestBuilder;
import com.eej.utilities.model.DataTableObject;
import com.eej.utilities.model.DataTableTagModel;
import com.eej.utilities.model.DataTableTagModelConfiguration;
import com.eej.utilities.model.factory.DataTableTagModelConfigurationFactory;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public abstract class DataTableEntityController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private DataTableTagModelConfigurationFactory dataTableTagModelConfigurationFactory;
	
	@Autowired
	private DataTableCollectionContainer dataTableCollectionContainer;
	
	@Autowired
	private DataTableBuilder dataTableBuilder;
	
	@Autowired
	private DataTableBusinessEngine dataTableBusinessEngine;
	
	@Autowired
	private DataTablePaginationRequestBuilder dataTableRequestBuilder;
	
	public String getDataTableListContainerView(ModelMap model, String entityKey){
		try{
			DataTableTagModel tagModel = this.dataTableCollectionContainer.getModel(entityKey, null);
			model.addAttribute("dataTableTagModel", tagModel);
		}catch(Throwable t){
			logger.error("Error : " + t.getMessage(), t);
			return this.getTagModelConfiguration(entityKey).getPageNotFoundUri();
		}				
		return this.getTagModelConfiguration(entityKey).getListView();
	}
	
	public DataTableObject getDataTable(HttpServletRequest req, String entityKey){
		try{
			Class<? extends Serializable> clazz = this.dataTableCollectionContainer.getClass(entityKey);
			
			return this.dataTableBuilder.getDataTable(
					this.dataTableBusinessEngine.getEntityListViewItemCollection(
							dataTableRequestBuilder.getDataTablePaginationRequest(req),
							entityKey),
						clazz);
		}catch(Throwable t){
			logger.fatal("Error " + t.getMessage(), t);
			return null;
		}
	}
	
	public DataTableTagModelConfiguration getTagModelConfiguration(String entityKey){
		try{
			return this.dataTableCollectionContainer.getModelConfiguration(entityKey, null);
		}catch(Exception e){
			logger.error("Error recovering " + entityKey + " dataTableTagModelConfiguration: " + e.getMessage());
			return this.dataTableTagModelConfigurationFactory.getDataTableTagModelBaseConfiguration();
		}
	}

	
	/**
	 * @return the dataTableCollectionContainer
	 */
	public DataTableCollectionContainer getDataTableCollectionContainer() {
		return dataTableCollectionContainer;
	}

	/**
	 * @return the dataTableTagModelConfigurationFactory
	 */
	public final DataTableTagModelConfigurationFactory getDataTableTagModelConfigurationFactory() {
		return dataTableTagModelConfigurationFactory;
	}

	/**
	 * @param dataTableTagModelConfigurationFactory the dataTableTagModelConfigurationFactory to set
	 */
	public final void setDataTableTagModelConfigurationFactory(
			DataTableTagModelConfigurationFactory dataTableTagModelConfigurationFactory) {
		this.dataTableTagModelConfigurationFactory = dataTableTagModelConfigurationFactory;
	}
	
	

}
