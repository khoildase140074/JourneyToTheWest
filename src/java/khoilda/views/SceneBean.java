/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoilda.views;

import java.io.Serializable;
import java.util.Vector;
import khoilda.dtos.SceneDTO;

/**
 *
 * @author User
 */
public class SceneBean implements Serializable{
    private String search,Id;

    private Vector<SceneDTO> list;
    private SceneDAO dao;

    public SceneBean() {
        dao = new SceneDAO();
    }
    public void findByLikeName() throws Exception{
        list = dao.findByLikeName(search);
    }
    public SceneDTO findByPrimaryKey() throws Exception{
        return dao.findByPrimaryKey(Id);
    }
    public boolean update(SceneDTO dto) throws Exception{
        return dao.update(dto);
    }
    public boolean create(SceneDTO dto) throws Exception{
        return dao.create(dto);
    }
    public boolean delete() throws Exception{
        return dao.delete(Id);
    }    

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }
    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Vector<SceneDTO> getList() {
        return list;
    }

    public void setList(Vector<SceneDTO> list) {
        this.list = list;
    }

    public SceneDAO getDao() {
        return dao;
    }

    public void setDao(SceneDAO dao) {
        this.dao = dao;
    }
    
}
