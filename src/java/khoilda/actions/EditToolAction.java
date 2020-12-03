/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoilda.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import khoilda.dtos.ToolDTO;
import khoilda.views.ToolDAO;

/**
 *
 * @author User
 */
public class EditToolAction extends ActionSupport {
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
    public EditToolAction() {
    }
    
    public String execute() throws Exception {
        ToolDAO dao = new ToolDAO();
        ToolDTO dto = dao.findByPrimaryKey(id);
        Map session = ActionContext.getContext().getSession();
        session.put("DTO", dto);
                System.out.println("Id: "+id);
        return "success";
    }   
}
