package com.jsp.whms.mapper;

import com.jsp.whms.entity.Admin;
import com.jsp.whms.requestdto.AdminRequest;
import com.jsp.whms.responsedto.AdminResponse;

public class AdminMapper {

	public Admin mapToAdmin(AdminRequest adminRequest,Admin admin) {
		admin.setEmail(adminRequest.getEmail());
		admin.setName(adminRequest.getName());
		admin.setPassword(adminRequest.getPassword());
		return admin;
	}
	
	public AdminResponse mapToAdminResponse(Admin admin) {
		return AdminResponse.builder()
				 .email(admin.getEmail())
				 .name(admin.getName())
				 .adminId(admin.getAdminId())
				 .build();
		
	}

}
