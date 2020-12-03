/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoilda.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Vector;
import khoilda.dtos.UserDTO;
import khoilda.views.UserDAO;

/**
 *
 * @author User
 */
public class SearchUserAction extends ActionSupport {
    private String searchValue;
    private Vector<UserDTO> listUser;

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public Vector<UserDTO> getListUser() {
        return listUser;
    }

    public void setListUser(Vector<UserDTO> listUser) {
        this.listUser = listUser;
    }
    
    public SearchUserAction() {
    }
    
    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        listUser = dao.findByLikeName(searchValue);
        return "success";
    }
    
}
