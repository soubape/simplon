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

import net.stc.management.model.Activite;
import net.stc.management.services.impl.ActiviteServicesImpl;


@RestController
@RequestMapping("/api/v1/management/activite")
public class StcActiviteController {

	private ActiviteServicesImpl activiteServicesImpl;


	public StcActiviteController(ActiviteServicesImpl activiteServicesImpl) {
		super();
		this.activiteServicesImpl = activiteServicesImpl;
	}

	@GetMapping
	private List<Activite> getAllActivites() {
		return activiteServicesImpl.getAll();
	}

	// build create employee REST API
	@PostMapping
	public Activite create(@RequestBody Activite activite) {
		return activiteServicesImpl.save(activite);

	}

	// build get employee by id REST API
	@GetMapping("{id}")
	public Activite getActiviteById(@PathVariable Long id) {
		return activiteServicesImpl.getById(id);
	}

	// build update employee REST API
	@PutMapping("{id}")
	public ResponseEntity<Activite>  updateActivite(@PathVariable("id") Long id, @RequestBody Activite activite) {
		activiteServicesImpl.update(activite, id);
		return  new ResponseEntity<>(activiteServicesImpl.getById(id), HttpStatus.OK) ;
	}

	// build delete employee REST API
	@DeleteMapping("{id}")
	public void deleteexercice(@PathVariable Long id) {
		activiteServicesImpl.delete(id);

	}

}
