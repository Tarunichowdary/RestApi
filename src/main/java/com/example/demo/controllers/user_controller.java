package com.example.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exp_handling.APIResponse;
import com.example.demo.payload.user_payload;
import com.example.demo.services.user_services;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")

public class user_controller {
	@Autowired
    user_services service;
	@PostMapping("/insert")
	public ResponseEntity<user_payload>adduser(@Valid @RequestBody user_payload users){
	user_payload user=this.service.addusers(users);
	return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<user_payload>updateusers(@Valid @PathVariable int id ,@RequestBody user_payload users){
		user_payload user=this.service.updateusers(users,id);
		return ResponseEntity.ok(user);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<APIResponse>delete(@Valid @PathVariable int id){
		this.service.deleteusers(id);
		return new ResponseEntity<APIResponse>(new APIResponse("id delete succesfully",true),HttpStatus.OK);
	}
	@GetMapping("/getall")
	public ResponseEntity<List<user_payload>>getall(){
		return  ResponseEntity.ok(this.service.getallusers());
	}
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<user_payload>getbyid(@Valid @PathVariable int id){
		return ResponseEntity.ok(this.service.getusersbyid(id));
	}
}

