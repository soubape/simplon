package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Employe;

public interface EmployeService {
	Employe create(Employe employe);
	Employe update(Employe employe);
	List<Employe> getAll();
	Employe findById(Long id);
	String delete(Long id);

}
