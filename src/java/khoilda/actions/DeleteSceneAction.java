/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoilda.actions;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import khoilda.views.SceneDAO;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author User
 */
public class DeleteSceneAction extends ActionSupport {
    private String id,lastSearchValue;
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSearchValue() {
        return lastSearchValue;
    }

    public void setSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }
    
    public DeleteSceneAction() {
    }
    
    public String execute() throws Exception {
        String url = ERROR;
        SceneDAO dao = new SceneDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        if(dao.delete(id))
            url = SUCCESS;
        request.setAttribute("ERROR", "Delete Failed");
        return url;
    }
    
}
