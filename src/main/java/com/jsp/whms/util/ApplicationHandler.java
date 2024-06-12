package com.jsp.whms.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.whms.exception.AddressNotFoundByIDException;
import com.jsp.whms.exception.AdminNotFoundByIdException;
import com.jsp.whms.exception.IllLegalOperationException;

@RestControllerAdvice
public class ApplicationHandler {
	
		@ExceptionHandler
		public ResponseEntity<ErrorStructure<String>> handleIllLegalOperationException(IllLegalOperationException ex){
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ErrorStructure<String>()
							.setStatus(HttpStatus.FORBIDDEN.value())
							.setMessage(ex.getMessage())
							.setCause("Already SuperAdmin Exist"));
		}
		
		@ExceptionHandler
		public ResponseEntity<ErrorStructure<String>> handleAdminNotFoundEception(AdminNotFoundByIdException ex){
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ErrorStructure<String>()
							.setStatus(HttpStatus.NOT_FOUND.value())
							.setMessage(ex.getMessage())
							.setCause("The Requested  Id Does not Exist"));
		}
		
		@ExceptionHandler
		ResponseEntity<ErrorStructure<String>> handleAddressNotFoundByIDException(AddressNotFoundByIDException ex){
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ErrorStructure<String>()
							.setStatus(HttpStatus.NOT_FOUND.value())
							.setMessage(ex.getMessage())
							.setCause("The Requested  Id Does not Exist"));
		}

}
