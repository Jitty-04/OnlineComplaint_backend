package com.nest.OnlineComplaint.controller;

import com.nest.OnlineComplaint.dao.UserDao;
import com.nest.OnlineComplaint.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
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
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/usersearch",consumes ="application/json",produces ="application/json")
    public Map<String,String> SearchUser(@RequestBody User u)
    {
        String email=u.getEmail().toString();
        String password=u.getPassword().toString();
        System.out.println(email);
        System.out.println(password);
        List<User> result= (List<User>) dao.SearchUser(u.getEmail(),u.getPassword());
        HashMap<String,String> st=new HashMap<>();
        if(result.size()==0)
        {
            st.put("status","failed");
            st.put("message","user doesn't exist");
        }
        else{
            int id =result.get(0).getId();
            st.put("userid",String.valueOf(id));
            st.put("status","success");
            st.put("message","user login success");
        }
        return st;

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewprofile",consumes = "application/json",produces = "application/json")
    public List<User> ViewProfile(@RequestBody User u) {
        String id=String.valueOf(u.getId());
        System.out.println(id);
        return (List<User>) dao.ViewProfile(u.getId());


    }


}
