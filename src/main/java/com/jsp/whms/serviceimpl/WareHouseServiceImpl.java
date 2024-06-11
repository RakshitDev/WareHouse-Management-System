package com.jsp.whms.serviceimpl;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.jsp.whms.entity.WareHouse;
import com.jsp.whms.enums.Privilage;
import com.jsp.whms.mapper.WareHouseMapper;
import com.jsp.whms.repository.WareHouseRepository;
import com.jsp.whms.requestdto.WareHouseRequest;
import com.jsp.whms.responsedto.WareHouseResponse;
import com.jsp.whms.service.WareHouseService;
import com.jsp.whms.util.ResponseStructure;
@Service
public class WareHouseServiceImpl implements WareHouseService{
	
	
	@Autowired
	private WareHouseRepository wareHouseRepository;
	
	@Autowired
	WareHouseMapper wareHouseMapper;

	@Override
	public ResponseEntity<ResponseStructure<WareHouseResponse>> createWareHouse(WareHouseRequest wareHouseRequest) {
		WareHouse wareHouse = wareHouseMapper.mapToWareHouse(wareHouseRequest, new WareHouse());
		wareHouse = wareHouseRepository.save(wareHouse);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseStructure<WareHouseResponse>()
						.setStatus(HttpStatus.CREATED.value())
						.setMessage("WareHouse created")
						.setData(wareHouseMapper.mapToWareHouseResponse(wareHouse)));
		
	}

}
