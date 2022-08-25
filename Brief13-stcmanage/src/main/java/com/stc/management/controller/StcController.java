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
import com.stc.management.model.Activite;
import com.stc.management.model.Administrateur;
import com.stc.management.repository.AdministrateurRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/management")
public class StcController {
	
	@Autowired
	 private AdministrateurRepository administrateurrepository;
	 	 
//	 public StcController(AdministrateurRepository administrateurrepository) {
//		super();
//		this.administrateurrepository = administrateurrepository;
//	}
	@GetMapping
	 private List<Administrateur> getAlladministrateurs()   
	 {  
		 return administrateurrepository.findAll();  
	 }  
	 // build create employee REST API
	 @PostMapping
	 public Administrateur create(Administrateur administrateur) {
		 return administrateurrepository.save(administrateur);
	
	 }

	 // build get employee by id REST API
	    @GetMapping("{id}")
	    public ResponseEntity<Administrateur> getAdministrateurById(@PathVariable  long id){
	    	Administrateur administrateur =  administrateurrepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Administrateur not exist with id:" + id));
	        return ResponseEntity.ok(administrateur);
	    }

	    //build update employee REST API
	    @PutMapping("{id}")
	    public ResponseEntity<Administrateur> updateAdministrateur(@PathVariable long id,@RequestBody Administrateur administrateurDetails) {
	    	Administrateur administrateur =  administrateurrepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Administrateur not exist with id: " + id));

	    	administrateur.setName(administrateurDetails.getName());
	    	administrateur.setUsername(administrateurDetails.getUsername());
	    	administrateur.setEmail(administrateurDetails.getEmail());
	    	administrateur.setPassword(administrateurDetails.getPassword());
	    	administrateur.setTelephone(administrateurDetails.getTelephone());
	    	administrateurrepository.save(administrateur);
	        return ResponseEntity.ok(administrateur);
	    }
	    

	    // build delete employee REST API
	    @DeleteMapping("{id}")
	    public ResponseEntity<HttpStatus> deleteadministrateur(@PathVariable long id){

	        Administrateur administrateur = administrateurrepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Administrateur not exist with id: " + id));
	        administrateurrepository.delete(administrateur);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	    }

}
