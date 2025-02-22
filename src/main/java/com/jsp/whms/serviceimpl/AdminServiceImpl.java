package com.jsp.whms.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.whms.entity.Admin;
import com.jsp.whms.enums.AdminType;
import com.jsp.whms.enums.Privilage;
import com.jsp.whms.exception.IllLegalOperationException;
import com.jsp.whms.mapper.AdminMapper;
import com.jsp.whms.repository.AdminRepository;
import com.jsp.whms.requestdto.AdminRequest;
import com.jsp.whms.responsedto.AdminResponse;
import com.jsp.whms.service.AdminService;
import com.jsp.whms.util.ResponseStructure;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	AdminMapper adminMapper;

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(AdminRequest adminRequest) {
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

		if (adminRepository.existByAdminType(AdminType.SUPER_ADMIN))
			throw new IllLegalOperationException("");
		Admin admin = adminMapper.mapToAdmin(adminRequest, new Admin());
		admin.setAdmintype(AdminType.SUPER_ADMIN);
		adminRepository.save(admin);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseStructure<AdminResponse>().setMessage("Super admin Created ")
						.setStatus(HttpStatus.CREATED.value()).setData(adminMapper.mapToAdminResponse(admin)));

	}

}
