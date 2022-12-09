package com.nest.OnlineComplaint.controller;

import com.nest.OnlineComplaint.dao.UserDao;
import com.nest.OnlineComplaint.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addusers", consumes = "application/json", produces = "application/json")
    public Map<String, String> AddUser(@RequestBody User u) {
        System.out.println(u.getName().toString());
        System.out.println(u.getAddress().toString());
        System.out.println(u.getPhno().toString());
        System.out.println(u.getEmail().toString());
        System.out.println(u.getPassword().toString());
        dao.save(u);
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }
}
