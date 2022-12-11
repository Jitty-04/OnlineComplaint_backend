package com.nest.OnlineComplaint.controller;

import com.nest.OnlineComplaint.dao.ComplaintDao;
import com.nest.OnlineComplaint.dao.UserDao;
import com.nest.OnlineComplaint.model.Complaints;
import com.nest.OnlineComplaint.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ComplaintController {
    @Autowired
    private ComplaintDao dao;
    @CrossOrigin(origins="*")
    @PostMapping(path="/addcomplaint",consumes="application/json",produces = "application/json")
    public HashMap<String,String > AddComplaints(@RequestBody Complaints c){
     HashMap<String,String>  map=new HashMap<>();
    dao.save(c);
    map.put("status","success");
     return map;

    }
    @CrossOrigin(origins="*")
    @GetMapping(path="/viewallcomplaints")
    public List<Map<String,String>> viewall(){
        return(List<Map<String,String>>) dao.complaints();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/mycomplaint",consumes = "application/json",produces = "application/json")
    public List<Complaints> ViewMyComplaint(@RequestBody Complaints c)
    {
        return (List<Complaints>) dao.ViewComplaint(c.getId());
    }
}
