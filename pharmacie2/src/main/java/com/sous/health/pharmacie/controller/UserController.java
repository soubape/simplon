package com.sous.health.pharmacie.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sous.health.pharmacie.entities.User;
import com.sous.health.pharmacie.services.UserServiceImpl;


@RestController
@RequestMapping("/api/v1/pharmacie")
public class UserController {
	@Autowired
	private UserServiceImpl userImpl;

	public UserController(UserServiceImpl userImpl) {
		super();
		this.userImpl = userImpl;
	}

	@GetMapping("/users")
	  List<User> findAll() {
	    return userImpl.getAll();

	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody User user) {
		return userImpl.save(user);
}
	
	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public User getUserById(@PathVariable Long id) {
		return userImpl.getById(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User>  updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		userImpl.update(user, id);
		return  new ResponseEntity<>(userImpl.getById(id), HttpStatus.OK) ;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void deleteUser(@PathVariable Long id) {
		userImpl.delete(id);

	}
}
	
