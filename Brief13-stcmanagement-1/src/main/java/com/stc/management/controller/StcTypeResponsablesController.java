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
import com.stc.management.model.Responsable;
import com.stc.management.model.TypeResponsable;
import com.stc.management.repository.ResponsableRepository;
import com.stc.management.repository.TypeResponsableRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/management/typeresponsable")
public class StcTypeResponsablesController {
	
	 @Autowired
	 private TypeResponsableRepository typeresponsablerepository;
	 
	 public StcTypeResponsablesController(TypeResponsableRepository typeresponsablerepository) {
		super();
		this.typeresponsablerepository = typeresponsablerepository;
	}
	@GetMapping()
	 private List<TypeResponsable> getAllResponsables()   
	 {  
	 return typeresponsablerepository.findAll();  
	 }  
	 // build create employee REST API
	 @PostMapping
	 public TypeResponsable create(@RequestBody TypeResponsable typeresponsable) {
		 return typeresponsablerepository.save(typeresponsable);
	
	 }

	 // build get employee by id REST API
	    @GetMapping("{id}")
	    public ResponseEntity<TypeResponsable> getResponsableById(@PathVariable  long id){
	    	TypeResponsable typeresponsable =  typeresponsablerepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Type Responsable not exist with id:" + id));
	        return ResponseEntity.ok(typeresponsable);
	    }

	    //build update employee REST API
	    @PutMapping("{id}")
	    public ResponseEntity<TypeResponsable> updateTypeResponsable(@PathVariable long id,@RequestBody TypeResponsable typeResponsableDetails) {
	    	TypeResponsable typeresponsable = typeresponsablerepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("TYpe Responsable not exist with id: " + id));

	    	typeresponsable.setType(typeResponsableDetails.getType());
	    	typeresponsablerepository.save(typeresponsable);
	        return ResponseEntity.ok(typeresponsable);
	    }
	    

	    // build delete employee REST API
	    @DeleteMapping("{id}")
	    public ResponseEntity<HttpStatus> deleteTypeResponsable(@PathVariable long id){

	       TypeResponsable typeresponsable = typeresponsablerepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Type Responsable not exist with id: " + id));

	        typeresponsablerepository.delete(typeresponsable);

	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	    }

}
