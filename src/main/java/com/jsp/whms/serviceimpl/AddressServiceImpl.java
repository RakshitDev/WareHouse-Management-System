package com.jsp.whms.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.whms.entity.Address;
import com.jsp.whms.entity.WareHouse;
import com.jsp.whms.exception.AddressNotFoundByIDException;
import com.jsp.whms.exception.WareHouseNotFoundByIdException;
import com.jsp.whms.mapper.AddressMapper;
import com.jsp.whms.repository.AddressRepository;
import com.jsp.whms.repository.WareHouseRepository;
import com.jsp.whms.requestdto.AddressRequest;
import com.jsp.whms.responsedto.AddressResponse;
import com.jsp.whms.service.AddressService;
import com.jsp.whms.util.ResponseStructure;

@Service
public class AddressServiceImpl  implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AddressMapper addressMapper;
	
	@Autowired
	WareHouseRepository wareRepository;

	@Override
	public ResponseEntity<ResponseStructure<AddressResponse>> addAddress(AddressRequest addressRequest,int warehouseId) {
		return  wareRepository.findById(warehouseId).map(warehouse->{
			Address address = addressMapper.mapToAddress(addressRequest, new Address());
			address.setWareHouse(warehouse);
			addressRepository.save(address);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new ResponseStructure<AddressResponse>()
							.setStatus(HttpStatus.CREATED.value())
							.setMessage("Address created")
							.setData(addressMapper.mapToAddressResponse(address)));
		}).orElseThrow(()->new WareHouseNotFoundByIdException("No WareHouse found by Sent Id"));
		
		
	}

	@Override
	public ResponseEntity<ResponseStructure<AddressResponse>> findAddress(int addressId) {
	return 	addressRepository.findById(addressId).map(address->{
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(new ResponseStructure<AddressResponse>()
						.setMessage("Address found based on Id")
						.setStatus(HttpStatus.FOUND.value())
						.setData(addressMapper.mapToAddressResponse(address)));
	
	}).orElseThrow(()-> new AddressNotFoundByIDException(""));
		
	}
	


}
