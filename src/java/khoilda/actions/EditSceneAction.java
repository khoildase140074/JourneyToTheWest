/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoilda.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import khoilda.dtos.SceneDTO;
import khoilda.views.SceneDAO;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author User
 */
public class EditSceneAction extends ActionSupport {
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
    
    public EditSceneAction() {
    }
    
    public String execute() throws Exception {
        SceneDAO dao = new SceneDAO();
        SceneDTO dto = dao.findByPrimaryKey(id);
        Map session = ActionContext.getContext().getSession();
        session.put("DTO", dto);
        return "success";
    }
    
}
