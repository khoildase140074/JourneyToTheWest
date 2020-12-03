/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoilda.actions;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import khoilda.views.ToolDAO;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author User
 */
public class DeleteToolAction extends ActionSupport {
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";
    private String id,lastSearchValue;

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
    public DeleteToolAction() {
    }
    
    public String execute() throws Exception {
        String url = ERROR;
        ToolDAO dao = new ToolDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        if(dao.delete(id))
            url = SUCCESS;
        else{
            request.setAttribute("ERROR", "Delete Tool Failed");
        }
        return url;
    }
    
}
