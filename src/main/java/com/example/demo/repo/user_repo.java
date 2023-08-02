package com.example.demo.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.user;

@Repository
public interface user_repo extends CrudRepository<user, Integer>{
	

}
