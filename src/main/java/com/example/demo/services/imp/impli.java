package com.example.demo.services.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exp_handling.ResourceNotFoundException;
import com.example.demo.models.user;
import com.example.demo.payload.user_payload;
import com.example.demo.repo.user_repo;
import com.example.demo.services.user_services;
@Service
public class impli implements user_services {
	@Autowired
	user_repo repo;
	@Autowired
	ModelMapper modelmapper;
	@Override
	public user_payload addusers(user_payload adu) {
		user u=this.dto_users(adu);
		user saveusers=this.repo.save(u);
		return this.users_dto(saveusers);
	}

	@Override
	public user_payload updateusers(user_payload upu, int id) {
		user u=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("user","id",id));
	    u.setName(upu.getName());
	    u.setName(upu.getEmail());
	    u.setPassword(upu.getPassword());
	    user u1=this.repo.save(u);
	    user_payload us=this.users_dto(u1);
	    return us;
	}

	@Override
	public void deleteusers(int id) {
		user u=this.repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user","id",id));
	    this.repo.delete(u);
   
	}

	@Override
	public List<user_payload> getallusers() {
	   List<user> u=(List<user> ) this.repo.findAll();
//	   List<user_payload> up=u.stream().map(users->this.users_dto(user)).collect(Collectors.toList());
	   List<user_payload> up = u.stream().map(user -> this.users_dto(user)).collect(Collectors.toList());
	   return up;
	}

	@Override
	public user_payload getusersbyid(int id) {
		user u=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("user","id",id));
		return this.users_dto(u);
	}
	
	public user dto_users(user_payload us) {
		user u=this.modelmapper.map(us,user.class);
		return u;
	}
	public user_payload users_dto(user us) {
		user_payload userdto=this.modelmapper.map(us,user_payload.class);
		return userdto;
}
}
