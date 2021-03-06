package com.eej.utilities.resolver.tiles;

import java.util.*;
import javax.servlet.http.*;
import org.springframework.web.context.support.ContextExposingHttpServletRequest;
import org.springframework.web.servlet.view.tiles2.TilesView;

/**
 * Esta clase es para el tilesViewResolver.
 * Soluciona el problema de la carga de los properties para los JSP.
 *
 * @author DOARECAG
 *
 */
public class TilesExposingBeansView extends TilesView {

    private boolean exposeContextBeansAsAttributes = false;
    private Set<String> exposedContextBeanNames;

    public void setExposeContextBeansAsAttributes(boolean exposeContextBeansAsAttributes) {
        this.exposeContextBeansAsAttributes = exposeContextBeansAsAttributes;
    }

    public void setExposedContextBeanNames(String[] exposedContextBeanNames) {
        this.exposedContextBeanNames = new HashSet<String>(Arrays.asList(exposedContextBeanNames));
    } 

    protected HttpServletRequest getRequestToExpose(HttpServletRequest originalRequest) {
        if (this.exposeContextBeansAsAttributes || this.exposedContextBeanNames != null) 
        return new ContextExposingHttpServletRequest(originalRequest, getWebApplicationContext(), this.exposedContextBeanNames);
        return originalRequest;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpServletRequest requestToExpose = getRequestToExpose(request);
        exposeModelAsRequestAttributes(model, requestToExpose);
        super.renderMergedOutputModel(model, requestToExpose, response);
    }

}