/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoilda.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import khoilda.dtos.UserDTO;
import khoilda.views.UserDAO;

/**
 *
 * @author User
 */
public class EditUserAction extends ActionSupport {
    private String id, lastSearchValue ;

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
    
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";    
    public EditUserAction() {
    }
    
    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        Map session = ActionContext.getContext().getSession();
        UserDTO dto = dao.findByPrimaryKey(id);
        session.put("DTO", dto);
        return "success";
    }
    
}
