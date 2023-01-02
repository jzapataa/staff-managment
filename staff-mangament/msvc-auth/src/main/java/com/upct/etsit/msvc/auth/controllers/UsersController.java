package com.upct.etsit.msvc.auth.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upct.etsit.msvc.auth.entity.Users;
import com.upct.etsit.msvc.auth.service.IUsersService;

@RestController
@RequestMapping("users")
public class UsersController {

	@Autowired
	private IUsersService usersService;

	@GetMapping("/list")
	public List<Users> listUsers() {
		return usersService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Users> user = usersService.findById(id);
		if (user.isPresent())
			return ResponseEntity.ok(user.get());

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Users user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usersService.save(user));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Users user) {
		Optional<Users> userOptional = usersService.findById(id);
		if (userOptional.isPresent())
			ResponseEntity.status(HttpStatus.CREATED).body(usersService.save(user));

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Users> userOptional = usersService.findById(id);
		if (userOptional.isPresent()) {
			usersService.deleteById(id);
			ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

}
