package com.nest.OnlineComplaint.dao;

import com.nest.OnlineComplaint.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Integer> {
}
