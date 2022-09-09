package net.stc.management.controller;

import java.util.List;

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

import net.stc.management.exception.ResourceNotFoundException;
import net.stc.management.model.Responsable;
import net.stc.management.repository.ResponsableRepository;
import net.stc.management.services.impl.ResponsableServicesImpl;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/management/responsable")
public class StcResponsableController {

	 private ResponsableServicesImpl responsableServicesImpl;
	 
	 
	 public StcResponsableController(ResponsableServicesImpl responsableServicesImpl) {
		this.responsableServicesImpl = responsableServicesImpl;
	}
	@GetMapping 
	 private List<Responsable> getAllResponsables()   
	 {  
	 return responsableServicesImpl.getAll();  
	 }  
	 // build create employee REST API
	 @PostMapping
	 public Responsable create(@RequestBody Responsable responsable) {
		 return responsableServicesImpl.save(responsable);
	
	 }

	 // build get employee by id REST API
	    @GetMapping("{id}")
	    public Responsable getResponsableById(@PathVariable  long id){
	    	return responsableServicesImpl.getById(id);
	    }

	    //build update employee REST API
	    @PutMapping("{id}")
	    public ResponseEntity<Responsable> updateResponsable(@PathVariable long id,@RequestBody Responsable responsable) {
	    	responsableServicesImpl.getById(id);
	    	return new ResponseEntity<Responsable>(responsableServicesImpl.getById(id),HttpStatus.OK);
	    }
	    

	    // build delete employee REST API
	    @DeleteMapping("{id}")
	    public void deleteResponsable(@PathVariable long id){
	    	responsableServicesImpl.delete(id);

	    }

}
