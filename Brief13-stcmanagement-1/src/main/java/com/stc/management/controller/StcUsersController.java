package com.stc.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stc.management.exception.ResourceNotFoundException;
import com.stc.management.model.Users;
import com.stc.management.repository.UsersRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/management/user")
public class StcUsersController {
	
	@Autowired
	 private UsersRepository usersrepository;
	 	 
	 public StcUsersController(UsersRepository usersrepository) {
		super();
		this.usersrepository = usersrepository;
	}
	@GetMapping
	 private List<Users> getAllusers()   
	 {  
		 return usersrepository.findAll();  
	 }  
	 // build create employee REST API
	 @PostMapping
	 public Users create(Users user) {
		 return usersrepository.save(user);
	
	 }

	 // build get employee by id REST API
	    @GetMapping("{id}")
	    public ResponseEntity<Users> getUserById(@PathVariable  long id){
	    	Users user =  usersrepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + id));
	        return ResponseEntity.ok(user);
	    }

	    //build update employee REST API
	    @PutMapping("{id}")
	    public ResponseEntity<Users> updateUser(@PathVariable long id,@RequestBody Users userDetails) {
	    	Users user =  usersrepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));

	    	user.setName(userDetails.getName());
	    	user.setEmail(userDetails.getEmail());
	    	user.setPassword(userDetails.getPassword());
	    	user.setTelephone(userDetails.getTelephone());
	    	user.setUsername(userDetails.getUsername());
	    	usersrepository.save(user);
	        return ResponseEntity.ok(user);
	    }
	    

	    // build delete employee REST API
	    @DeleteMapping("{id}")
	    public ResponseEntity<HttpStatus> deleteuser(@PathVariable long id){

	        Users user = usersrepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));
	        usersrepository.delete(user);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	    }

}
