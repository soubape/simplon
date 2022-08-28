package net.stc.management.services.impl;

import java.util.List;

import net.stc.management.exception.ResourceNotFoundException;
import net.stc.management.model.Administrateur;
import net.stc.management.repository.AdministrateurRepository;
import net.stc.management.services.StcServices;

public class AdministrateurServicesImpl implements StcServices<Administrateur>{

	private AdministrateurRepository administrateurRepository;
	
	public AdministrateurServicesImpl(AdministrateurRepository administrateurRepository) {
		super();
		this.administrateurRepository = administrateurRepository;
	}

	@Override
	public List<Administrateur> getAll() {
		return administrateurRepository.findAll();
	}

	@Override
	public Administrateur getById(Long id) {
		return administrateurRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Administrateur not found "+id));
	}

	@Override
	public Administrateur save(Administrateur administrateur) {
		return administrateurRepository.save(administrateur);
	}

	@Override
	public void update(Administrateur administrateur, Long id) {
		Administrateur admin1 = administrateurRepository.findById(id).get();
		admin1.setName(administrateur.getName());
		admin1.setUsername(administrateur.getUsername());
		admin1.setEmail(administrateur.getEmail());
		admin1.setPassword(administrateur.getPassword());
		admin1.setTelephone(administrateur.getTelephone());
		administrateurRepository.save(administrateur);
	}

	@Override
	public void delete(Long id) {
		administrateurRepository.deleteById(id);
	}


}
