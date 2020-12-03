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
public class SceneDTO implements Serializable{
    private String Id,name,description,location,starttime,endtime,record;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public SceneDTO(String Id, String name, String description, String location, String starttime, String endtime, String record) {
        this.Id = Id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.starttime = starttime;
        this.endtime = endtime;
        this.record = record;
    }

    public SceneDTO() {
    }    
}
