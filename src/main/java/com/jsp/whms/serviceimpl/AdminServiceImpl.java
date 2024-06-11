package com.jsp.whms.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jsp.whms.entity.Admin;
import com.jsp.whms.entity.WareHouse;
import com.jsp.whms.enums.AdminType;
import com.jsp.whms.enums.Privilage;
import com.jsp.whms.exception.AdminNotFoundByIdException;
import com.jsp.whms.exception.IllLegalOperationException;
import com.jsp.whms.exception.WareHouseNotFoundByIdException;
import com.jsp.whms.mapper.AdminMapper;
import com.jsp.whms.repository.AdminRepository;
import com.jsp.whms.repository.WareHouseRepository;
import com.jsp.whms.requestdto.AdminRequest;
import com.jsp.whms.responsedto.AdminResponse;
import com.jsp.whms.service.AdminService;
import com.jsp.whms.util.ResponseStructure;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
  private AdminMapper adminMapper;
	
	@Autowired
	private WareHouseRepository wareHouseRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> saveSuperAdmin(AdminRequest adminRequest) {
//		Optional<Admin> adminType = adminRepository.findByAdminType(AdminType.SUPER_ADMIN);
//		if(adminType.isPresent()) {
//			throw new IllLegalOperationException("");
//		}else {
//		Admin admin=adminRepository.save(adminMapper.mapToAdmin( adminRequest,new Admin()));
//		return ResponseEntity.status(HttpStatus.CREATED)
//				.body(new ResponseStructure<AdminResponse>()
//						.setData(adminMapper.mapToAdminResponse(admin))
//						.setMessage("Admin saved in db")
//						.setStatus(HttpStatus.CREATED.value()));
//		}

		// use only java 8

		if (adminRepository.existsByAdminType(AdminType.SUPER_ADMIN))
			throw new IllLegalOperationException("doing ill leagal oeration");
		Admin admin = adminMapper.mapToAdmin(adminRequest, new Admin());
		admin.setAdminType(AdminType.SUPER_ADMIN);
		adminRepository.save(admin);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseStructure<AdminResponse>().setMessage("Super admin Created ")
						.setStatus(HttpStatus.CREATED.value()).setData(adminMapper.mapToAdminResponse(admin)));

	}

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(AdminRequest adminRequest, int warehouseId) {
	return	wareHouseRepository.findById(warehouseId).map(warehouse->{
		Admin admin = adminMapper.mapToAdmin(adminRequest, new Admin());
		admin.setAdminType(AdminType.ADMIN);
		admin = adminRepository.save(admin);
		warehouse.setAdmin(admin);
	   	    wareHouseRepository.save(warehouse);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new ResponseStructure<AdminResponse>()
							.setStatus(HttpStatus.CREATED.value())
							.setMessage("Admin saved to db")
							.setData(adminMapper.mapToAdminResponse(admin)));
					
			
		}).orElseThrow(()->new WareHouseNotFoundByIdException("No wareHouse with that Id is present") );
		
	}

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(AdminRequest adminRequest) {
		
		String email= SecurityContextHolder.getContext().getAuthentication().getName();
	return	adminRepository.findByEmail(email).map(admin->{
			adminRepository.save(adminMapper.mapToAdmin(adminRequest, admin));
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseStructure<AdminResponse>()
							.setStatus(HttpStatus.OK.value())
							.setMessage("updated Admin Succcessfully")
							.setData(adminMapper.mapToAdminResponse(admin)));
		}).orElseThrow(()->new AdminNotFoundByIdException("Failed to update Admin"));
		
	  
	  }
		
	}

	


