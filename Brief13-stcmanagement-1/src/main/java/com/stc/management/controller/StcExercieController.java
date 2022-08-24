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
import com.stc.management.model.Administrateur;
import com.stc.management.model.Exercice;
import com.stc.management.repository.AdministrateurRepository;
import com.stc.management.repository.ExercieRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/management/exercice")
public class StcExercieController {

	@Autowired
	private ExercieRepository exercicerepository;

	
	public StcExercieController(ExercieRepository exercicerepository) {
		super();
		this.exercicerepository = exercicerepository;
	}

	@GetMapping
	private List<Exercice> getAllExercices() {
		return exercicerepository.findAll();
	}

	// build create employee REST API
	@PostMapping
	public Exercice create(@RequestBody Exercice exercice) {
		return exercicerepository.save(exercice);

	}

	// build get employee by id REST API
	@GetMapping("{id}")
	public ResponseEntity<Exercice> getExerciceById(@PathVariable long id) {
		Exercice exercice = exercicerepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Exercice not exist with id:" + id));
		return ResponseEntity.ok(exercice);
	}

	// build update employee REST API
	@PutMapping("{id}")
	public ResponseEntity<Exercice> updateExercice(@PathVariable long id, @RequestBody Exercice exerciceDetails) {
		Exercice exercice = exercicerepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Exercice not exist with id: " + id));

		exercice.setAnnee(exerciceDetails.getAnnee());
		exercice.setDateDebut(exerciceDetails.getDateDebut());
		exercice.setDateFin(exerciceDetails.getDateFin());
		exercice.setStatut(exerciceDetails.isStatut());
		exercicerepository.save(exercice);
		return ResponseEntity.ok(exercice);
	}

	// build delete employee REST API
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteexercice(@PathVariable long id) {

		Exercice exercice = exercicerepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Exercice not exist with id: " + id));

		exercicerepository.delete(exercice);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
