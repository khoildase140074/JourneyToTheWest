/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoilda.views;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import khoilda.db.MyConnection;
import khoilda.dtos.UserDTO;

/**
 *
 * @author User
 */
public class UserDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    public void closeConnection(){
        try {
            if(rs != null)
                rs.close();
            if(preStm != null)
                preStm.close();
            if(conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public UserDTO checkLogin(String username, String password) throws Exception{
        UserDTO dto = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Fullname, Role, Phone, Email, ImageLink, Description From tblAccount Where Username = ? And Password = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if(rs.next()){
                String fullname = rs.getString("Fullname");
                String role = rs.getString("Role");
                String phone = rs.getString("Phone");
                String email = rs.getString("Email");
                String imagelink = rs.getString("ImageLink");
                String description = rs.getString("Description");
                dto = new UserDTO(username, fullname, role, phone, email, imagelink, description);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    public Vector<UserDTO> findByLikeName(String name) throws Exception{
        Vector<UserDTO> list = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Username,Fullname, Role, Phone, Email, ImageLink, Description "
                    + "From tblAccount Where Fullname Like ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + name + "%");
            rs = preStm.executeQuery();
            list = new Vector<>();
            while(rs.next()){
                String username = rs.getString("Username");
                String fullname = rs.getString("Fullname");
                String role = rs.getString("Role");
                String phone = rs.getString("Phone");
                String email = rs.getString("Email");
                String imagelink = rs.getString("ImageLink");
                String description = rs.getString("Description");
                UserDTO dto = new UserDTO(username, fullname, role, phone, email, imagelink, description);                
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    public UserDTO findByPrimaryKey(String id) throws Exception{
        UserDTO dto = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Fullname, Role, Phone, Email, ImageLink, Description From tblAccount Where Username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if(rs.next()){
                String fullname = rs.getString("Fullname");
                String role = rs.getString("Role");
                String phone = rs.getString("Phone");
                String email = rs.getString("Email");
                String imagelink = rs.getString("ImageLink");
                String description = rs.getString("Description");
                dto = new UserDTO(id, fullname, role, phone, email, imagelink, description);                
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    public boolean delete(String id) throws Exception{
        boolean status = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Delete From tblAccount Where Username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            status = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return status;
    }
    public boolean update(UserDTO dto) throws Exception{
        boolean status = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Update tblAccount Set Password = ?, Fullname = ?, Role = ? , Phone = ? , "
                    + "Email = ?, ImageLink = ?, Description = ? Where Username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getPassword());
            preStm.setString(2, dto.getFullname());
            preStm.setString(3, dto.getRole());
            preStm.setString(4, dto.getPhone());
            preStm.setString(5, dto.getEmail());
            preStm.setString(6, dto.getImagelink());
            preStm.setString(7, dto.getDescription());
            preStm.setString(8, dto.getUsername());
            status = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return status;
    }
    public boolean create(UserDTO dto) throws Exception{
        boolean status = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Insert Into tblAccount (Username,Password,Fullname,Role,Phone,Email,ImageLink,Description) Values (? , ?, ? ,?, ?, ?, ?, ?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getFullname());
            preStm.setString(4, dto.getRole());
            preStm.setString(5, dto.getPhone());
            preStm.setString(6, dto.getEmail());
            preStm.setString(7, dto.getImagelink());
            preStm.setString(8, dto.getDescription());
            status = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return status;
    }    
}
