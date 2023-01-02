package com.upct.etsit.msvc.auth.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upct.etsit.msvc.auth.entity.Users;
import com.upct.etsit.msvc.auth.repository.UsersRepository;
import com.upct.etsit.msvc.auth.service.IUsersService;

@Service
public class UsersServiceImpl implements IUsersService{
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Users> findAll() {
		return usersRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Users> findById(Long id) {
		return usersRepository.findById(id);
	}

	@Override
	@Transactional
	public Users save(Users user) {
		return usersRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		usersRepository.deleteById(id);
		
	}

}
