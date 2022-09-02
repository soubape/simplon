package net.stc.management.controller;

import java.util.List;

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

import net.stc.management.model.Participant;
import net.stc.management.services.impl.ParticipantServicesImpl;

@RestController
@RequestMapping("/api/v1/management/participant")
public class StcParticipantController {

	private ParticipantServicesImpl participantserviceimpl;
	 
	public StcParticipantController(ParticipantServicesImpl participantserviceimpl) {
		this.participantserviceimpl = participantserviceimpl;
	}
	@GetMapping  
	 private List<Participant> getAllParticipants()   
	 {  
	 return participantserviceimpl.getAll();  
	 }  
	 // build create employee REST API
	 @PostMapping
	 public Participant create(Participant participant) {
		 return participantserviceimpl.save(participant);
	
	 }

	 // build get employee by id REST API
	    @GetMapping("{id}")
	    public Participant getParticipantById(@PathVariable  long id){
	    	return participantserviceimpl.getById(id);
	    }

	    //build update employee REST API
	    @PutMapping("{id}")
	    public ResponseEntity<Participant> updateParticipant(@PathVariable long id,@RequestBody Participant participant) {
	    	participantserviceimpl.getById(id);
	        return new ResponseEntity<Participant>(participantserviceimpl.getById(id), HttpStatus.OK);
	    }
	    

	    // build delete employee REST API
	    @DeleteMapping("{id}")
	    public void deleteParticipant(@PathVariable long id){
	    	participantserviceimpl.delete(id);

	    }

}
