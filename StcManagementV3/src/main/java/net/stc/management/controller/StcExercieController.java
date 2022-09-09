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
import org.springframework.web.bind.annotation.RestController;

import net.stc.management.model.Exercice;
import net.stc.management.services.impl.ExerciceServicesImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/management/exercice")

public class StcExercieController {

	private ExerciceServicesImpl exerciceServicesImpl;

	
	public StcExercieController(ExerciceServicesImpl exerciceServicesImpl) {
		this.exerciceServicesImpl = exerciceServicesImpl;
	}

	@GetMapping
	private List<Exercice> getAllExercices() {
		return exerciceServicesImpl.getAll();
	}

	// build create employee REST API
	@PostMapping
	public Exercice create(@RequestBody Exercice exercice) {
		return exerciceServicesImpl.save(exercice);

	}

	// build get employee by id REST API
	@GetMapping("{id}")
	public Exercice getExerciceById(@PathVariable long id) {
				
		return exerciceServicesImpl.getById(id);
	}

	// build update employee REST API
	@PutMapping("{id}")
	public ResponseEntity<Exercice> updateExercice(@PathVariable("id") long id, @RequestBody Exercice exercice) {
		exerciceServicesImpl.update(exercice, id);
		return new ResponseEntity<Exercice>(exerciceServicesImpl.getById(id), HttpStatus.OK) ;
			
	}

	// build delete employee REST API
	@DeleteMapping("{id}")
	public void deleteexercice(@PathVariable long id) {
		exerciceServicesImpl.delete(id);

	}

}
