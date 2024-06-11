package com.jsp.whms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jsp.whms.repository.AdminRepository;
@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return adminRepository.findByEmail(username)
				.map(UserDetailImpl::new).orElseThrow(()->new UsernameNotFoundException(""));
				
	}

}
