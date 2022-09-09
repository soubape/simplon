package com.example.demo.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeServiceImpl implements EmployeService {
	
	@Autowired
	private EmployeRepository employeRepository;

	public EmployeServiceImpl(EmployeRepository employeRepository) {
		super();
	}

	@Override
	public Employe create(Employe employe) {
		return employeRepository.save(employe);
	}

	@Override
	public Employe update(Employe employe) {
		 Employe existingEmploye = employeRepository.findById(employe.getId()).orElse(null);
		 existingEmploye.setNom(employe.getNom());
	        return employeRepository.save(existingEmploye);
	}

	@Override
	public List<Employe> getAll() {
		return employeRepository.findAll();
	}

	@Override
	public Employe findById(Long id) {
		return employeRepository.findById(id).orElse(null);
	}

	@Override
	public String delete(Long id) {
		employeRepository.deleteById(id);
		return "L'employe "+id +"a ete supprime avec succes";
		
	}

}
