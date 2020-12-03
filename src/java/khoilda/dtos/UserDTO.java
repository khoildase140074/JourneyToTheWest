/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoilda.dtos;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class UserDTO implements Serializable {
    private String username,password,fullname,role,phone,email,imagelink,description;

    public UserDTO() {
    }

    public UserDTO(String username, String fullname, String role, String phone, String email, String imagelink, String description) {
        this.username = username;
        this.fullname = fullname;
        this.role = role;
        this.phone = phone;
        this.email = email;
        this.imagelink = imagelink;
        this.description = description;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "username=" + username + ", password=" + password + ", fullname=" + fullname + ", role=" + role + ", phone=" + phone + ", email=" + email + ", imagelink=" + imagelink + ", description=" + description + '}';
    }
    
    
    
}
