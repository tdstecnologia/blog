package br.com.tdstecnologia.blog.controller;

import java.io.Serializable;
import java.util.Map;
import javax.faces.context.FacesContext;

public abstract class AbstractController implements Serializable {

    protected String getParam(final String param){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get(param);
    }
    
}
