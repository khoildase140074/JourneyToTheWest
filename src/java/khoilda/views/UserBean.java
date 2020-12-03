/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoilda.views;

import java.io.Serializable;
import java.util.Vector;
import khoilda.dtos.UserDTO;

/**
 *
 * @author User
 */
public class UserBean implements Serializable{
    private String username,password,search;
    private Vector<UserDTO> list;
    private UserDAO dao;

    public UserBean() {
        dao = new UserDAO();
    }
    public UserDTO checkLogin() throws Exception{
        return dao.checkLogin(username, password);
    }
    public void findByLikeName() throws Exception{
        list = dao.findByLikeName(search);
    }
    public UserDTO findByPrimaryKey() throws Exception{
        return dao.findByPrimaryKey(username);
    }
    public boolean update(UserDTO dto) throws Exception{
        return dao.update(dto);
    }
    public boolean create(UserDTO dto) throws Exception{
        return dao.create(dto);
    }
    public boolean delete() throws Exception{
        return dao.delete(username);
    }    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Vector<UserDTO> getList() {
        return list;
    }

    public void setList(Vector<UserDTO> list) {
        this.list = list;
    }

    public UserDAO getDao() {
        return dao;
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }
    
}
