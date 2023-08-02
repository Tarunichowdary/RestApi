package com.example.demo.exp_handling;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
	String ResourceName;
	String FeildName;
	int FeildValue;
	public ResourceNotFoundException(String ResourceName,String FeildName,int FeildValue) {
		super(String.format("%s Not Found with %s :%s",ResourceName,FeildName,FeildValue));
		this.ResourceName=ResourceName;
		this.FeildName=FeildName;
		this.FeildValue=FeildValue;
	}

}
