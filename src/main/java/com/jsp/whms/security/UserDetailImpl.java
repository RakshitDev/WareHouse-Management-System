package com.jsp.whms.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jsp.whms.entity.Admin;
import com.jsp.whms.enums.Privilage;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class UserDetailImpl implements UserDetails{
	
	private Admin admin;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return admin.getAdminType().getPrivilages().stream()
				.map(Privilage -> new SimpleGrantedAuthority(Privilage.name())).toList();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return admin.getPassword();
	}

	@Override
	public String getUsername() {
		
		return admin.getEmail();
	}

}
