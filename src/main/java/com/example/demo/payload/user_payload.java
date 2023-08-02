package com.example.demo.payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class user_payload {
	private int id;
	@Column(name="Usernme",nullable=false,length=40)
	@NotEmpty
	private String name;
	@Email
	private String email;
	@Pattern(regexp= "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	@Column(length=16)
	private String password;

}
