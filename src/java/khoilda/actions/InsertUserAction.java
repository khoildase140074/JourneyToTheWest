/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoilda.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import javax.servlet.http.HttpServletRequest;
import khoilda.dtos.UserDTO;
import khoilda.views.UserDAO;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author User
 */
public class InsertUserAction extends ActionSupport {
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";
    private String username,password,confirm,fullname,role,phone,email,image,description;

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

    public String getConfirm() {
        return confirm;
    }
    @FieldExpressionValidator(expression = "confirm==password",
            message = "Must Match Password")
    public void setConfirm(String confirm) {
        this.confirm = confirm;
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
        return phone;
    }
@RegexFieldValidator(type = ValidatorType.FIELD,
        regex = "\\d{9}",
        message = "Phone Must have 9 digits")
    public void setPhonenumber(String phonenumber) {
        this.phone = phone;
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
    
    public String getPhone() {
        return phone;
    }
@RegexFieldValidator(type = ValidatorType.FIELD,
        regex = "\\d{9}",
        message = "Phone Must have 9 digits")
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public InsertUserAction() {
    }
    
    public String execute() throws Exception {
        String url = ERROR;
        UserDAO dao = new UserDAO();
        UserDTO dto = new UserDTO(username, fullname, role, phone, email, image, description);
        dto.setPassword(password);
        System.out.println(dto.toString());
        HttpServletRequest request = ServletActionContext.getRequest();
        if(dao.create(dto))
            url = SUCCESS;
        else {
            request.setAttribute("ERROR", "Insert Failed");
        }
        return url;
    }    
}
