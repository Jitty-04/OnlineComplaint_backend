package com.nest.OnlineComplaint.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="complaints")
public class Complaints {
    @Id
    @GeneratedValue()
    private int id;
    private int userid;
    private String complaints;

    public Complaints() {
    }

    public Complaints(int id, int userid, String complaints) {
        this.id = id;
        this.userid = userid;
        this.complaints = complaints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }
}
