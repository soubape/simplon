//package com.stc.management.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.stc.management.exception.ResourceNotFoundException;
//import com.stc.management.model.Activite;
//import com.stc.management.model.Responsable;
//import com.stc.management.model.TypeActivite;
//import com.stc.management.repository.ActiviteRepository;
//import com.stc.management.repository.TYpeActiviteRepository;
//
//@CrossOrigin("*")
//@RestController
//@RequestMapping("/api/v1/management/typeactivite")
//public class StcTypeActiviteController {
//	
//	 @Autowired
//	 private TYpeActiviteRepository typeactiviterepository;
//	 
//	 
//	 public StcTypeActiviteController(TYpeActiviteRepository typeactiviterepository) {
//		super();
//		this.typeactiviterepository = typeactiviterepository;
//	}
//	@GetMapping 
//	 private List<TypeActivite> getAllTypeActivites()   
//	 {  
//	 return typeactiviterepository.findAll();  
//	 }  
//	 // build create employee REST API
//	 @PostMapping
//	 public TypeActivite create(@RequestBody TypeActivite typeactivite) {
//		 return typeactiviterepository.save(typeactivite);
//	
//	 }
//
//	 // build get employee by id REST API
//	    @GetMapping("{id}")
//	    public ResponseEntity<TypeActivite> getTypeActiviteById(@PathVariable  long id){
//	    	TypeActivite typeactivite =  typeactiviterepository.findById(id)
//	                .orElseThrow(() -> new ResourceNotFoundException("Type Activite not exist with id:" + id));
//	        return ResponseEntity.ok(typeactivite);
//	    }
//
//	    //build update employee REST API
//	    @PutMapping("{id}")
//	    public ResponseEntity<TypeActivite> updateTypeActivite(@PathVariable long id,@RequestBody TypeActivite typeActiviteDetails) {
//	    	TypeActivite typeactivite =  typeactiviterepository.findById(id)
//	                .orElseThrow(() -> new ResourceNotFoundException("TYpe Activite not exist with id: " + id));
//
//	    	typeactivite.setType(typeActiviteDetails.getType());
//	    	typeactiviterepository.save(typeactivite);
//	        return ResponseEntity.ok(typeactivite);
//	    }
//	    
//
//	    // build delete employee REST API
//	    @DeleteMapping("{id}")
//	    public ResponseEntity<HttpStatus> deletetypeactivite(@PathVariable long id){
//
//	        TypeActivite typeactivite = typeactiviterepository.findById(id)
//	                .orElseThrow(() -> new ResourceNotFoundException("TYpe Exercice not exist with id: " + id));
//
//	        typeactiviterepository.delete(typeactivite);
//
//	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//	    }
//
//}
