package com.crescent.rentcloud.authorizationserver.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crescent.rentcloud.authorizationserver.model.User;

public interface UserDetailsRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByUsername(String username);

}
