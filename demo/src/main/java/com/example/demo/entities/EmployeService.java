package com.example.demo.entities;

import java.util.List;

public interface EmployeService {
	Employe create(Employe employe);
	Employe update(Employe employe);
	List<Employe> getAll();
	Employe findById(Long id);
	String delete(Long id);

}
