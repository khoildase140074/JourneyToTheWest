/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoilda.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Vector;
import khoilda.dtos.ToolDTO;
import khoilda.views.ToolDAO;

/**
 *
 * @author User
 */
public class SearchToolAction extends ActionSupport {
    private String searchValue;
    private Vector<ToolDTO> listTool;

    public Vector<ToolDTO> getListTool() {
        return listTool;
    }

    public void setListTool(Vector<ToolDTO> listTool) {
        this.listTool = listTool;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
    
    public SearchToolAction() {
    }
    
    public String execute() throws Exception {
        ToolDAO dao = new ToolDAO();
        listTool = dao.findByLikeName(searchValue);
        return "success";
    }
    
}
