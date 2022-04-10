package com.crescent.rentcloud.authorizationserver.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthUserDetails extends User implements UserDetails {
	
	List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
	
	

	public AuthUserDetails(User user) {
		super(user);		
	}

	
	
	public AuthUserDetails() {
		super();
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		super.getRoles().forEach(role->{
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
			role.getPermissions().forEach(permission->{
				grantedAuthorities.add(new SimpleGrantedAuthority(permission.getName()));
			});
		});
		
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return super.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return super.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return super.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return super.isEnabled();
	}

}
