/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoilda.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Vector;
import khoilda.dtos.SceneDTO;
import khoilda.views.SceneDAO;

/**
 *
 * @author User
 */
public class SearchSceneAction extends ActionSupport {
    private String searchValue;
    private Vector<SceneDTO> listScene;

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }



    public Vector<SceneDTO> getListScene() {
        return listScene;
    }

    public void setListScene(Vector<SceneDTO> listScene) {
        this.listScene = listScene;
    }
    
    public SearchSceneAction() {
    }
    
    public String execute() throws Exception {
        SceneDAO dao = new SceneDAO();
        SceneDTO dto = new SceneDTO();
        listScene = dao.findByLikeName(searchValue);
        System.out.println(dto.toString());
        return "success";
    }
    
}
