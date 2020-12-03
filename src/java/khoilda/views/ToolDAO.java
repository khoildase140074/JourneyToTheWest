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
import khoilda.dtos.ToolDTO;

/**
 *
 * @author User
 */
public class ToolDAO implements Serializable{
    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;
    
    public void closeConnection(){
        try {
        if(rs != null)
            rs.close();
        if(preStm != null)
            preStm.close();
        if(conn!= null)
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Vector<ToolDTO> findByLikeName(String toolname) throws Exception{
        Vector<ToolDTO> list = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select id,name,description,image,quantity,status From tbl_Tool Where name Like ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%"+toolname+"%");
            rs = preStm.executeQuery();
            list = new Vector<>();
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                String quantity = rs.getString("quantity");
                String status = rs.getString("status");
                ToolDTO dto = new ToolDTO(id, name, description, image, quantity, status);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    public ToolDTO findByPrimaryKey(String id) throws Exception{
        ToolDTO dto = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select name,description,image,quantity,status From tbl_Tool Where id = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if(rs.next()){
                String name = rs.getString("name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                String quantity = rs.getString("quantity");
                String status = rs.getString("status");
                dto = new ToolDTO(id, name, description, image, quantity, status);
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
            String sql = "Delete From tbl_Tool Where id = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            status = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return status;
    }
    public boolean update(ToolDTO dto) throws Exception{
        boolean status = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Update tbl_Tool Set name = ?, description = ?, image = ? , quantity = ? , "
                    + "status = ? Where id = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setString(2, dto.getDescription());
            preStm.setString(3, dto.getImage());
            preStm.setString(4, dto.getQuantity());
            preStm.setString(5, dto.getStatus());
            preStm.setString(6, dto.getId());
            status = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return status;
    }
    public boolean create(ToolDTO dto) throws Exception{
        boolean check = false;
        try {
            String query = "Insert into tbl_Tool(id,name,description,image,quantity,status) values (?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, dto.getId());
            preStm.setString(2, dto.getName());
            preStm.setString(3, dto.getDescription());
            preStm.setString(4, dto.getImage());
            preStm.setString(5, dto.getQuantity());
            preStm.setString(6, dto.getStatus());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }    
}
