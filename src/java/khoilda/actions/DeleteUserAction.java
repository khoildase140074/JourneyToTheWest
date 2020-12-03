/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoilda.actions;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import khoilda.views.UserDAO;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author User
 */
public class DeleteUserAction extends ActionSupport {
    private String id, lastSearchValue;
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }
    
    public DeleteUserAction() {
    }
    
    public String execute() throws Exception {
        String url = ERROR;
        UserDAO dao = new UserDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        if(dao.delete(id))
            url = SUCCESS;
        else 
            request.setAttribute("ERROR", "Delete Failed");
        return url;
    }
    
}
