package com.upct.etsit.msvc.auth.service;

import java.util.List;
import java.util.Optional;

import com.upct.etsit.msvc.auth.entity.Users;

public interface IUsersService {
	
	List<Users> findAll();
	Optional<Users> findById(Long id);
	Users save(Users user);
	void deleteById(Long id);

}
