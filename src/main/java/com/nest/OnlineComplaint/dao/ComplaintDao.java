package com.nest.OnlineComplaint.dao;

import com.nest.OnlineComplaint.model.Complaints;
import com.nest.OnlineComplaint.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ComplaintDao extends CrudRepository<Complaints,Integer> {
@Query(value="SELECT u.`address`, u.`email`, u.`name`, u.`phno`,c.complaints FROM `user` u JOIN complaints c ON c.userid=u.id",nativeQuery = true)
    List<Map<String,String>> complaints();
@Query(value = "SELECT `id`, `complaints`, `userid` FROM `complaints` WHERE `userid`=:userid",nativeQuery = true)
    List<Complaints> ViewComplaint(@Param("userid") Integer id);
}
