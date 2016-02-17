/**
 * 
 */
package com.eej.utilities.taglib;

import javax.servlet.jsp.JspWriter;

import org.apache.log4j.Logger;

import com.eej.utilities.ApplicationVersion;

/**
 * @author jlumietu
 *
 */
public class DataTableTag extends BaseSpringContextTag{
	
private Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	
	private int rowsPerPage = 15;
	
	private String tableName;
	
	private String pageName;
	
	private boolean serverSide = false;
	
	private String sourceData;
	
	private String resultListName = "resultados";
	
	private String contentType = "application/x-www-form-urlencoded; charset=utf-8";
	
	private boolean allowNewRowCreation = false;
	
	private String newRowCreationUrlEndpoint = null;
	
	/* (non-Javadoc)
	 * @see com.eej.utilities.taglib.BaseSpringContextTag#doStartTagInternal()
	 */
	@Override
	protected int doStartTagInternal() throws Exception {
		super.doStartTagInternal();
		JspWriter out = pageContext.getOut();
		logger.debug("pageContext.getServletContext()  = " + pageContext.getServletContext().getContextPath());
		String appContext = pageContext.getServletContext().getContextPath();
		out.print(
				"<section id='" + this.tableName + "' class='tableSection dynamicDataTable' " +
				" data-attr-pageName='" + this.pageName + "' " + 
				" data-attr-serverSide='" + this.serverSide + "' " + 
				" data-attr-sourceData='" + (appContext.equals("")?"": appContext + "/") + this.sourceData + "' " + 
				" data-attr-resultListName='" + this.resultListName + "' " + 
				" data-attr-allowNewRowCreation='" + this.allowNewRowCreation + "' " +
				" data-attr-newRowCreationUrlEndpoint='" + this.newRowCreationUrlEndpoint + "' " + 
				"/>");
		return SKIP_BODY;
	}

	/**
	 * @return the rowsPerPage
	 */
	public int getRowsPerPage() {
		return rowsPerPage;
	}

	/**
	 * @param rowsPerPage the rowsPerPage to set
	 */
	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the pageName
	 */
	public String getPageName() {
		return pageName;
	}

	/**
	 * @param pageName the pageName to set
	 */
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	/**
	 * @return the serverSide
	 */
	public boolean isServerSide() {
		return serverSide;
	}

	/**
	 * @param serverSide the serverSide to set
	 */
	public void setServerSide(boolean serverSide) {
		this.serverSide = serverSide;
	}

	/**
	 * @return the sourceData
	 */
	public String getSourceData() {
		return sourceData;
	}

	/**
	 * @param sourceData the sourceData to set
	 */
	public void setSourceData(String sourceData) {
		this.sourceData = sourceData;
	}

	/**
	 * @return the resultListName
	 */
	public String getResultListName() {
		return resultListName;
	}

	/**
	 * @param resultListName the resultListName to set
	 */
	public void setResultListName(String resultListName) {
		this.resultListName = resultListName;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the allowNewRowCreation
	 */
	public boolean isAllowNewRowCreation() {
		return allowNewRowCreation;
	}

	/**
	 * @param allowNewRowCreation the allowNewRowCreation to set
	 */
	public void setAllowNewRowCreation(boolean allowNewRowCreation) {
		this.allowNewRowCreation = allowNewRowCreation;
	}

	/**
	 * @return the newRowCreationUrlEndpoint
	 */
	public String getNewRowCreationUrlEndpoint() {
		return newRowCreationUrlEndpoint;
	}

	/**
	 * @param newRowCreationUrlEndpoint the newRowCreationUrlEndpoint to set
	 */
	public void setNewRowCreationUrlEndpoint(String newRowCreationUrlEndpoint) {
		this.newRowCreationUrlEndpoint = newRowCreationUrlEndpoint;
	}
	
	
}
