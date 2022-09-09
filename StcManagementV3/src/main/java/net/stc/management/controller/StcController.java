package net.stc.management.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.stc.management.model.Administrateur;
import net.stc.management.services.impl.AdministrateurServicesImpl;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/management")

public class StcController {
	
	 private AdministrateurServicesImpl administrateurServicesImpl;
	 	 
	 public StcController(AdministrateurServicesImpl administrateurServicesImpl) {
		this.administrateurServicesImpl = administrateurServicesImpl;
	}
	@GetMapping
	@ResponseStatus(HttpStatus.CREATED)
	 private List<Administrateur> getAlladministrateurs()   
	 {  
		 return administrateurServicesImpl.getAll();  
	 }  
	 // build create employee REST API
	 @PostMapping
		@ResponseStatus(HttpStatus.CREATED)
	 public Administrateur create(Administrateur administrateur) {
		 return administrateurServicesImpl.save(administrateur);
	
	 }

	 // build get employee by id REST API
	    @GetMapping("{id}")
		@ResponseStatus(HttpStatus.CREATED)
	    public Administrateur getAdministrateurById(@PathVariable("id")  long id){
	    	return administrateurServicesImpl.getById(id);
	    }

	    //build update employee REST API
	    @PutMapping("{id}")
		@ResponseStatus(HttpStatus.CREATED)
	    public ResponseEntity<Administrateur> updateAdministrateur(@PathVariable long id,@RequestBody Administrateur administrateur) {
	    	administrateurServicesImpl.update(administrateur, id);
			return  new ResponseEntity<>(administrateurServicesImpl.getById(id), HttpStatus.OK) ;
	    }
	    

	    // build delete employee REST API
	    @DeleteMapping("{id}")
		@ResponseStatus(HttpStatus.CREATED)
	    public void deleteadministrateur(@PathVariable("id") long id){
	      administrateurServicesImpl.delete(id);

	    }

}
