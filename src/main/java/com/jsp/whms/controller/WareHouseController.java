package com.jsp.whms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.whms.entity.WareHouse;
import com.jsp.whms.requestdto.WareHouseRequest;
import com.jsp.whms.responsedto.WareHouseResponse;
import com.jsp.whms.service.WareHouseService;
import com.jsp.whms.util.ResponseStructure;

@RestController
@RequestMapping("/api/v1")
public class WareHouseController {
	
	@Autowired
	private WareHouseService wareHouseService;
	
	@PreAuthorize("hasAuthority('CREATE_WAREHOUSE')")
	@PostMapping(value = "/warehouses")
	public ResponseEntity<ResponseStructure<WareHouseResponse>> createWareHouse(@RequestBody  WareHouseRequest wareHouseRequest) {
		return wareHouseService.createWareHouse(wareHouseRequest);
	}
	
	@PreAuthorize("hasAuthority('CREATE_WAREHOUSE')")
	@PutMapping(value = "/warehouses/{warehouseId}")
	public ResponseEntity<ResponseStructure<WareHouseResponse>> updateWareHouse(@RequestBody WareHouseRequest wareHouseRequest,@PathVariable int warehouseId){
		return wareHouseService.updateWareHouse(wareHouseRequest,warehouseId);
	}
 
}
