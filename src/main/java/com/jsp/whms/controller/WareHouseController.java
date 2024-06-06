package com.jsp.whms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.whms.entity.WareHouse;
import com.jsp.whms.util.ResponseStructure;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/")
public class WareHouseController {
	
	@Autowired
	private 
	
	@PostMapping(value = "/warehouse")
	String createWareHouse(@RequestBody  WareHouse wareHouse) {
		return "wareHouse created";
	}
 
}
