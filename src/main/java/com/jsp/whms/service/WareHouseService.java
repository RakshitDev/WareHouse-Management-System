package com.jsp.whms.service;

import org.springframework.http.ResponseEntity;

import com.jsp.whms.entity.WareHouse;
import com.jsp.whms.requestdto.WareHouseRequest;
import com.jsp.whms.responsedto.AdminResponse;
import com.jsp.whms.responsedto.WareHouseResponse;
import com.jsp.whms.util.ResponseStructure;

public interface WareHouseService {

public	ResponseEntity<ResponseStructure<WareHouseResponse>> createWareHouse(WareHouseRequest wareHouseRequest);

public ResponseEntity<ResponseStructure<WareHouseResponse>> updateWareHouse(WareHouseRequest wareHouseRequest, int wareHouseId);

public ResponseEntity<ResponseStructure<WareHouseResponse>> findWarehouse(int warehouseId);

}
