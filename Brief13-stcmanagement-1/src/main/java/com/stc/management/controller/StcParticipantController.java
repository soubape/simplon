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
import com.stc.management.model.Participant;
import com.stc.management.repository.ParticipantRepository;

@RestController
@RequestMapping("/api/v1/management/participant")
public class StcParticipantController {
	
	 @Autowired
	 private ParticipantRepository participantrepository;
	 
	 public StcParticipantController(ParticipantRepository participantrepository) {
		super();
		this.participantrepository = participantrepository;
	}
	@GetMapping  
	 private List<Participant> getAllParticipants()   
	 {  
	 return participantrepository.findAll();  
	 }  
	 // build create employee REST API
	 @PostMapping
	 public Participant create(Participant participant) {
		 return participantrepository.save(participant);
	
	 }

	 // build get employee by id REST API
	    @GetMapping("{id}")
	    public ResponseEntity<Participant> getParticipantById(@PathVariable  long id){
	    	Participant participant =  participantrepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Participant not exist with id:" + id));
	        return ResponseEntity.ok(participant);
	    }

	    //build update employee REST API
	    @PutMapping("{id}")
	    public ResponseEntity<Participant> updateParticipant(@PathVariable long id,@RequestBody Participant participantDetails) {
	    	Participant participant =  participantrepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Participant not exist with id: " + id));

	    	participant.setFullname(participantDetails.getFullname());
	    	participant.setEmail(participantDetails.getEmail());
	    	participant.setStructure(participantDetails.getStructure());
	    	participant.setTelephone(participantDetails.getTelephone());
	    	participant.setResponsable(participantDetails.getResponsable());
	    	participantrepository.save(participant);
	        return ResponseEntity.ok(participant);
	    }
	    

	    // build delete employee REST API
	    @DeleteMapping("{id}")
	    public ResponseEntity<HttpStatus> deleteParticipant(@PathVariable long id){

	        Participant participant = participantrepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Participant not exist with id: " + id));
	        participantrepository.delete(participant);

	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	    }

}
