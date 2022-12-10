package com.nest.OnlineComplaint.dao;

import com.nest.OnlineComplaint.model.Complaints;
import org.springframework.data.repository.CrudRepository;

public interface ComplaintDao extends CrudRepository<Complaints,Integer> {
}
