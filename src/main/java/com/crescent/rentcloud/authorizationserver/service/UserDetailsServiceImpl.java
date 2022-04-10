package com.crescent.rentcloud.authorizationserver.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crescent.rentcloud.authorizationserver.model.AuthUserDetails;
import com.crescent.rentcloud.authorizationserver.model.User;
import com.crescent.rentcloud.authorizationserver.repository.UserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("PASSED USERNAME VALUE IS: "+username);
		
		Optional<User> optionalUser=userDetailsRepository.findByUsername(username);
		
		optionalUser.orElseThrow(()->new UsernameNotFoundException("Username and/or Password wrong"));
		UserDetails userDetails=new AuthUserDetails(optionalUser.get());
		
		
		
		
		new AccountStatusUserDetailsChecker().check(userDetails);
		
		return userDetails;
		
	}

}
