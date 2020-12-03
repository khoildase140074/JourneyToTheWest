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
import khoilda.dtos.SceneDTO;
import khoilda.dtos.UserDTO;

/**
 *
 * @author User
 */
public class SceneDAO implements Serializable{
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
    public Vector<SceneDTO> findByLikeName(String name) throws Exception{
        Vector<SceneDTO> list = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select sceneId,sceneName,description,location,starttime,endtime,record From tblScene Where sceneName Like ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%"+name+"%");
            rs = preStm.executeQuery();
            list = new Vector<>();
            while(rs.next()){
                String id = rs.getString("sceneid");
                String scenename = rs.getString("scenename");
                String des = rs.getString("description");
                String location = rs.getString("location");
                String starttime = rs.getString("starttime");
                String endtime = rs.getString("endtime");
                String record = rs.getString("record");
                SceneDTO dto = new SceneDTO(id, scenename, des, location, starttime, endtime, record);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    public SceneDTO findByPrimaryKey(String id) throws Exception{
        SceneDTO dto = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select sceneName,description,location,starttime,endtime,record From tblScene Where sceneId = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if(rs.next()){
                String scenename = rs.getString("scenename");
                String des = rs.getString("description");
                String location = rs.getString("location");
                String starttime = rs.getString("starttime");
                String endtime = rs.getString("endtime");
                String record = rs.getString("record");
                dto = new SceneDTO(id, endtime, location, location, starttime, endtime, record);
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
            String sql = "Delete From tblScene Where sceneId = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            status = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return status;
    }
    public boolean update(SceneDTO dto) throws Exception{
        boolean status = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Update tblScene Set sceneName = ?, description = ?, location = ? , starttime = ? , "
                    + "endtime = ?, record = ? Where sceneId = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setString(2, dto.getDescription());
            preStm.setString(3, dto.getLocation());
            preStm.setString(4, dto.getStarttime());
            preStm.setString(5, dto.getEndtime());
            preStm.setString(6, dto.getRecord());
            preStm.setString(7, dto.getId());
            status = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return status;
    }
    public boolean create(SceneDTO dto) throws Exception{
        boolean check = false;
        try {
            String query = "Insert into tblScene(sceneId,sceneName,description,location,starttime,endtime,record) values (?,?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, dto.getId());
            preStm.setString(2, dto.getName());
            preStm.setString(3, dto.getDescription());
            preStm.setString(4, dto.getLocation());
            preStm.setString(5, dto.getStarttime());
            preStm.setString(6, dto.getEndtime());
            preStm.setString(7, dto.getRecord());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }    
}
