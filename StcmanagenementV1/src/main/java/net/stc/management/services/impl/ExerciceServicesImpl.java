package net.stc.management.services.impl;

import java.util.List;

import net.stc.management.exception.ResourceNotFoundException;
import net.stc.management.model.Exercice;
import net.stc.management.repository.ExercieRepository;
import net.stc.management.services.StcServices;

public class ExerciceServicesImpl implements StcServices<Exercice>{

	private ExercieRepository exercicerepository;
	
	public ExerciceServicesImpl(ExercieRepository exercicerepository) {
		super();
		this.exercicerepository = exercicerepository;
	}

	@Override
	public List<Exercice> getAll() {
		return exercicerepository.findAll();
	}

	@Override
	public Exercice getById(Long id) {
		return exercicerepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Exercice not found" +id) );
	}

	@Override
	public Exercice save(Exercice Exercice) {
		return exercicerepository.save(Exercice);
	}


	@Override
	public void delete(Long id) {
		exercicerepository.deleteById(id);
		
	}

	@Override
	public void update(Exercice exercice, Long id) {
		Exercice exercice1 =  exercicerepository.findById(id).get();
		
		exercice1.setAnnee(exercice.getAnnee());
		exercice1.setDateDebut(exercice.getDateDebut());
		exercice1.setDateFin(exercice.getDateFin());
		exercice1.setStatut(exercice.isStatut());
		exercice1.setActivites(exercice.getActivites());
		exercicerepository.save(exercice);
	}

}
