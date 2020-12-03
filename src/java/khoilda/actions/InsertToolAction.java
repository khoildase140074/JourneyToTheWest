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
import khoilda.dtos.ToolDTO;
import khoilda.views.ToolDAO;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author User
 */
public class InsertToolAction extends ActionSupport {
    private String id,name,description,image,quantity,status;
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";

    public String getId() {
        return id;
    }
@RequiredStringValidator(type = ValidatorType.FIELD,
        message = "ToolId can't be blank")
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
@RequiredStringValidator(type = ValidatorType.FIELD,
        message = "ToolName can't be blank")
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

    public String getImage() {
        return image;
    }
@RequiredStringValidator(type = ValidatorType.FIELD,
        message = "Image can't be blank")
    public void setImage(String image) {
        this.image = image;
    }

    public String getQuantity() {
        return quantity;
    }
@RequiredStringValidator(type = ValidatorType.FIELD,
        message = "Quantity can't be blank")
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }
@RequiredStringValidator(type = ValidatorType.FIELD,
        message = "Status can't be blank")
    public void setStatus(String status) {
        this.status = status;
    }
    public InsertToolAction() {
    }
    
    public String execute() throws Exception {
        String url = ERROR;
        ToolDAO dao = new ToolDAO();
        ToolDTO dto = new ToolDTO(id, name, description, image, quantity, status);
        HttpServletRequest request = ServletActionContext.getRequest();
        if(dao.create(dto))
            url = SUCCESS;
        else{
            request.setAttribute("ERROR", "Insert Tool Failed");
        }
        return url;
    }
    
}
