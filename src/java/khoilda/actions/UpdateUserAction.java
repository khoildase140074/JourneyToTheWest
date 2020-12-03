/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoilda.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import khoilda.dtos.UserDTO;
import khoilda.views.UserDAO;
import org.apache.struts2.ServletActionContext;
/**
 *
 * @author User
 */
public class UpdateUserAction extends ActionSupport {
    private String username,password,fullname,role,phonenumber,email,image,description;
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";

    public String getUsername() {
        return username;
    }
    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "Username can't be blank")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "Password can't be blank")
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }
    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "Fullname can't be blank")
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }
    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "Role can't be blank")
    public void setRole(String role) {
        this.role = role;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
@RegexFieldValidator(type = ValidatorType.FIELD,
        regex = "\\d{9}",
        message = "Phone Must have 9 digits")
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }
@EmailValidator(type = ValidatorType.FIELD,
        message = "Invaid Email")
    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }
    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "Image can't be blank")
    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }
    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "Description can't be blank")
    public void setDescription(String description) {
        this.description = description;
    }
    
    public UpdateUserAction() {
    }
    
    public String execute() throws Exception {
        String url = ERROR;
        UserDAO dao = new UserDAO();
        UserDTO dto = new UserDTO(username, fullname, role, phonenumber, email, image, description);
        dto.setPassword(password);
        HttpServletRequest req = ServletActionContext.getRequest();
        if(dao.update(dto)){
            url = SUCCESS;
        }
        else
        {
            req.setAttribute("ERROR", "Update Failed");
        }
        return url;
    }    
}
