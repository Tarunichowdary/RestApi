package com.example.demo.services;

import java.util.List;



import com.example.demo.payload.user_payload;

public interface user_services {
	user_payload addusers(user_payload adu);
	user_payload updateusers(user_payload upu,int id);
	void deleteusers(int id);
	List<user_payload>getallusers();
	user_payload getusersbyid(int id);


}
