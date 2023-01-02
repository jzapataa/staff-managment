package com.upct.etsit.msvc.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upct.etsit.msvc.auth.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{

}
