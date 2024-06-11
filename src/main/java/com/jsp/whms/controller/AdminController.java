package com.jsp.whms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.whms.entity.Admin;
import com.jsp.whms.requestdto.AdminRequest;
import com.jsp.whms.responsedto.AdminResponse;
import com.jsp.whms.service.AdminService;
import com.jsp.whms.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping(value = "/register")
	ResponseEntity<ResponseStructure<AdminResponse>> saveSuperAdmin(@RequestBody AdminRequest adminRequest){
		return adminService.saveSuperAdmin(adminRequest);
		
	}
	@PostMapping(value="/warehouses/{wareHouseId}/admins")
	ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(@RequestBody AdminRequest adminRequest,@PathVariable int warehouseId){
		return adminService.saveAdmin(adminRequest,warehouseId);
				
	}
	
	@PutMapping(value = "/admins")
	ResponseEntity<ResponseStructure<AdminResponse>> updateByAdminId(@RequestBody AdminRequest adminRequest){
		return adminService.updateAdmin(adminRequest);
	}
	

}
