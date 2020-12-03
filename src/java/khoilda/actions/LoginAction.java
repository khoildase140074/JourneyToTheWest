/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoilda.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import khoilda.dtos.UserDTO;
import khoilda.views.SceneDAO;
import khoilda.views.UserDAO;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author User
 */
public class LoginAction extends ActionSupport {
    private String username,password;
    private static final String ERROR = "error";
    private static final String ADMIN = "admin";
    private static final String ACTOR = "actor";
    private static final String DICRECTOR = "director";
    
    public String getUsername() {
        return username;
    }
    @StringLengthFieldValidator(type = ValidatorType.FIELD,
            minLength = "1",maxLength = "30",
            message = "Must Type More Than 1 letter")
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
    public LoginAction() {
    }   
    public String execute() throws Exception {
        String url = ERROR;
        UserDAO dao = new UserDAO();
        UserDTO dto = dao.checkLogin(username, password);
        Map session = ActionContext.getContext().getSession();
        session.put("ROLE", dto.getRole().trim());
        HttpServletRequest request = ServletActionContext.getRequest();
        dao.findByLikeName(dto.getFullname());
        if(dto == null){
            request.setAttribute("ERROR", "Invalid Username or Password");
        } else {
            session.put("DTO", dto);
            if(dto.getRole().equals("admin"))
                url = ADMIN;
             else if(dto.getRole().equals("actor"))
                url = ACTOR;
             else if(dto.getRole().equals("director"))
                url = DICRECTOR;
             else 
                request.setAttribute("ERROR", "Your action is invalid");
        }       
        return url;
    }   
}