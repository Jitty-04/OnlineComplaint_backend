package com.nest.OnlineComplaint.controller;

import com.nest.OnlineComplaint.dao.ComplaintDao;
import com.nest.OnlineComplaint.dao.UserDao;
import com.nest.OnlineComplaint.model.Complaints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ComplaintController {
    @Autowired
    private ComplaintDao dao;
    @PostMapping(path="/addcomplaint",consumes="application/json",produces = "application/json")
    public HashMap<String,String > AddComplaints(@RequestBody Complaints c){
     HashMap<String,String>  map=new HashMap<>();
    dao.save(c);
    map.put("status","success");
     return map;

    }
}
