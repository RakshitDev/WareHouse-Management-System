package com.jsp.whms.service;

import org.springframework.http.ResponseEntity;

import com.jsp.whms.requestdto.AddressRequest;
import com.jsp.whms.responsedto.AddressResponse;
import com.jsp.whms.util.ResponseStructure;

public interface AddressService {

	ResponseEntity<ResponseStructure<AddressResponse>> addAddress(AddressRequest addressRequest,int warehouseId);

	ResponseEntity<ResponseStructure<AddressResponse>> findAddress(int addressId);

	ResponseEntity<ResponseStructure<AddressResponse>> updateAddress(AddressRequest addressRequest, int addressId);

}
