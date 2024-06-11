package com.jsp.whms.mapper;

import org.springframework.stereotype.Component;

import com.jsp.whms.entity.WareHouse;
import com.jsp.whms.requestdto.WareHouseRequest;
import com.jsp.whms.responsedto.WareHouseResponse;

@Component
public class WareHouseMapper {
	
	public WareHouse mapToWareHouse(WareHouseRequest wareHouseRequest,WareHouse wareHouse) {
		System.out.println(wareHouseRequest.getWarehouseName());
		wareHouse.setWareHouseName(wareHouseRequest.getWarehouseName());
		return wareHouse;
	}
	public WareHouseResponse mapToWareHouseResponse(WareHouse wareHouse) {
		return WareHouseResponse.builder()
				.wareHouseId(wareHouse.getWareHouseId())
				.wareHouseName(wareHouse.getWareHouseName())
				.build();
	}
}
