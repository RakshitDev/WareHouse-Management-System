package com.jsp.whms.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.jsp.whms.entity.Admin;
import com.jsp.whms.enums.AdminType;
import com.jsp.whms.requestdto.AdminRequest;
import com.jsp.whms.responsedto.AdminResponse;
import com.jsp.whms.util.ResponseStructure;

public interface AdminService {

	ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(AdminRequest adminRequest);
	
	

}
