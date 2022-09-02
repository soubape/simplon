package net.stc.management.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.stc.management.exception.ResourceNotFoundException;
import net.stc.management.model.Activite;
import net.stc.management.repository.ActiviteRepository;
import net.stc.management.services.StcServices;

@Service
public class ActiviteServicesImpl implements StcServices<Activite>{

	private ActiviteRepository activiteRepository;
	
	public ActiviteServicesImpl(ActiviteRepository activiteRepository) {
		super();
		this.activiteRepository = activiteRepository;
	}

	@Override
	public List<Activite> getAll() {
		return activiteRepository.findAll();
	}

	@Override
	public Activite getById(Long id) {
		return activiteRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Activite not found" +id) );
	}

	@Override
	public Activite save(Activite activite) {
		return activiteRepository.save(activite);
	}


	@Override
	public void delete(Long id) {
		activiteRepository.deleteById(id);
		
	}

	@Override
	public void update(Activite activite, Long id) {
		Activite activite1 =  activiteRepository.findById(id).get();
		
		activite1.setTitre(activite.getTitre());
		activite1.setDescription(activite.getDescription());
		activite1.setDateDebut(activite.getDateDebut());
		activite1.setDateFin(activite.getDateFin());
		activite1.setEtat(activite.isEtat());
//		activite1.setTypeactivite(activite.getTypeactivite());
//		activite1.setParticipant(activite.getParticipant());
//		activite1.setExercice(activite.getExercice());
//		activite1.setResponsable(activite.getResponsable());
     	activiteRepository.save(activite1);
	}

}
