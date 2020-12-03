/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoilda.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import javax.servlet.http.HttpServletRequest;
import khoilda.dtos.SceneDTO;
import khoilda.views.SceneDAO;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author User
 */
public class UpdateSceneAction extends ActionSupport {
    private String id,name,description,location,starttime,endtime,record;
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "SceneName can't be blank")
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "Description can't be blank")
    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }
    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "Description can't be blank")
    public void setLocation(String location) {
        this.location = location;
    }

    public String getStarttime() {
        return starttime;
    }
    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "StartTime can't be blank")
    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }
    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "EndTime can't be blank")
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getRecord() {
        return record;
    }
    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "Record can't be blank")
    public void setRecord(String record) {
        this.record = record;
    }
    public UpdateSceneAction() {
    }
    
    public String execute() throws Exception {
        String url = ERROR;
        SceneDAO dao = new SceneDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        SceneDTO dto = new SceneDTO(id, name, description, location, starttime, endtime, record);
        if(dao.update(dto))
            url = SUCCESS;
        else{
            request.setAttribute("ERROR", "Update Failed");
        }
        return url;
    }
    
}
