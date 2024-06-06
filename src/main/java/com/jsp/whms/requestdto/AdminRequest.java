package com.jsp.whms.requestdto;

import com.jsp.whms.enums.AdminType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRequest {
	private String name;
	private String email;
	private String password;
	private AdminType adminType;
	
	

}
