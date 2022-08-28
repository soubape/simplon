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


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/management/responsable")
public class StcResponsableController {

	 private ResponsableRepository responsablerepository;
	 
	 
	 public StcResponsableController(ResponsableRepository responsablerepository) {
		this.responsablerepository = responsablerepository;
	}
	@GetMapping 
	 private List<Responsable> getAllResponsables()   
	 {  
	 return responsablerepository.findAll();  
	 }  
	 // build create employee REST API
	 @PostMapping(consumes={"application/json"})
	 public Responsable create(@RequestBody Responsable responsable) {
		 return responsablerepository.save(responsable);
	
	 }

	 // build get employee by id REST API
	    @GetMapping("{id}")
	    public ResponseEntity<Responsable> getResponsableById(@PathVariable  long id){
	    	Responsable responsable =  responsablerepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Responsable not exist with id:" + id));
	        return ResponseEntity.ok(responsable);
	    }

	    //build update employee REST API
	    @PutMapping("{id}")
	    public ResponseEntity<Responsable> updateResponsable(@PathVariable long id,@RequestBody Responsable responsableDetails) {
	    	Responsable responsable =  responsablerepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Responsable not exist with id: " + id));

	    	responsable.setDomaine(responsableDetails.getDomaine());
	    	responsable.setEtat(responsableDetails.isEtat());
	    	responsable.setName(responsableDetails.getName());
	    	responsable.setTelephone(responsableDetails.getTelephone());
	    	responsable.setTyperesponsable(responsableDetails.getTyperesponsable());
	    	responsable.setActivites(responsableDetails.getActivites());
	    	responsablerepository.save(responsable);
	        return ResponseEntity.ok(responsable);
	    }
	    

	    // build delete employee REST API
	    @DeleteMapping("{id}")
	    public ResponseEntity<HttpStatus> deleteResponsable(@PathVariable long id){

	        Responsable responsable = responsablerepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Responsable not exist with id: " + id));

	        responsablerepository.delete(responsable);

	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	    }

}
