package net.stc.management.services.impl;

import java.util.List;

import net.stc.management.exception.ResourceNotFoundException;
import net.stc.management.model.Responsable;
import net.stc.management.repository.ActiviteRepository;
import net.stc.management.repository.ResponsableRepository;
import net.stc.management.services.StcServices;

public class ResponsableServicesImpl implements StcServices<Responsable>{

	private ResponsableRepository responsableRepository;
	
	public ResponsableServicesImpl(ResponsableRepository responsableRepository) {
		super();
		this.responsableRepository = responsableRepository;
	}

	@Override
	public List<Responsable> getAll() {
		return responsableRepository.findAll();
	}

	@Override
	public Responsable getById(Long id) {

		return responsableRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Responsable not found" +id) );
	}

	@Override
	public Responsable save(Responsable responsable) {
		return responsableRepository.save(responsable);
	}

	@Override
	public void update(Responsable responsable, Long id) {
		Responsable responsable1 = responsableRepository.findById(id).get();
		responsable1.setName(responsable.getName());
		responsable1.setDomaine(responsable.getDomaine());
		responsable1.setEtat(responsable.isEtat());
		responsable1.setTelephone(responsable.getTelephone());
		responsable1.setTyperesponsable(responsable.getTyperesponsable());
		responsable1.setActivites(responsable.getActivites());
		responsable1.setParticipants(responsable.getParticipants());
		responsableRepository.save(responsable);
		
	}

	@Override
	public void delete(Long id) {
		responsableRepository.deleteById(id);
		
	}

	

}
