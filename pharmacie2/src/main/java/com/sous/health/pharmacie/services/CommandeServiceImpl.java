package com.sous.health.pharmacie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sous.health.pharmacie.entities.Categorie;
import com.sous.health.pharmacie.entities.Commande;
import com.sous.health.pharmacie.repository.CategorieRepository;
import com.sous.health.pharmacie.repository.CommandeRepository;

@Service
public class CommandeServiceImpl implements PharmacieServices<Commande>{

	@Autowired
	CommandeRepository commandeRepository;
	
	
	public CommandeServiceImpl(CommandeRepository commandeRepository) {
		super();
		this.commandeRepository = commandeRepository;
	}

	@Override
	public List<Commande> getAll() {
		return commandeRepository.findAll();
	}

	@Override
	public Commande getById(Long id) {
		return commandeRepository.findById(id).get();
	}

	@Override
	public Commande save(Commande commande) {
		return commandeRepository.save(commande);
	}

	@Override
	public void update(Commande commande, Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Commande> findByNameOrPartName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
