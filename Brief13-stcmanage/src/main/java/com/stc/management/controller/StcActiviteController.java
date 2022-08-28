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
import com.stc.management.repository.ActiviteRepository;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/management/activite")
public class StcActiviteController {

	@Autowired
	private ActiviteRepository activitepository;

	
	public StcActiviteController(ActiviteRepository activitepository) {
		super();
		this.activitepository = activitepository;
	}

	@GetMapping
	private List<Activite> getAllExercices() {
		return activitepository.findAll();
	}

	// build create employee REST API
	@PostMapping
	public Activite create(@RequestBody Activite exercice) {
		return activitepository.save(exercice);

	}

	// build get employee by id REST API
	@GetMapping("{id}")
	public ResponseEntity<Activite> getActiviteById(@PathVariable long id) {
		Activite activite = activitepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Activite not exist with id:" + id));
		return ResponseEntity.ok(activite);
	}

	// build update employee REST API
	@PutMapping("{id}")
	public ResponseEntity<Activite> updateActivite(@PathVariable long id, @RequestBody Activite activiteDetails) {
		Activite activite = activitepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Activite not exist with id: " + id));

		activite.setTitre(activiteDetails.getTitre());
		activite.setDescription(activiteDetails.getDescription());
		activite.setDateDebut(activiteDetails.getDateDebut());
		activite.setDateFin(activiteDetails.getDateFin());
		activite.setParticipants(activiteDetails.getParticipants());
		activite.setResponsable(activiteDetails.getResponsable());
		activitepository.save(activite);
		return ResponseEntity.ok(activite);
	}

	// build delete employee REST API
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteexercice(@PathVariable long id) {

		Activite activite = activitepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Activite not exist with id: " + id));

		activitepository.delete(activite);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
