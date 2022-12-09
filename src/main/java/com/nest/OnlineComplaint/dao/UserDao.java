package com.nest.OnlineComplaint.dao;

import com.nest.OnlineComplaint.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<User,Integer> {
@Query(value ="SELECT `id`, `address`, `email`, `name`, `password`, `phno` FROM `user` WHERE `email`=:email AND `password`=:password",nativeQuery = true)
List<User> SearchUser(@Param("email") String name, @Param("password") String password);
@Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phno` FROM `user` WHERE `id`=:id",nativeQuery = true)
List<User> ViewProfile(@Param("id") Integer id);
}
