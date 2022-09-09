package com.example.demo.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeController {
	
	@Autowired
	private EmployeServiceImpl employeServiceImpl;

	public EmployeController(EmployeServiceImpl employeServiceImpl) {
		super();
		this.employeServiceImpl = employeServiceImpl;
	}
	
	@PostMapping("/addEmploye")
    public Employe addProduct(@RequestBody Employe employe) {
        return employeServiceImpl.create(employe);
    }

    @GetMapping("/employes")
    public List<Employe> findAllEmployes() {
        return employeServiceImpl.getAll();
    }

    @GetMapping("/employe/{id}")
    public Employe findEmployeById(@PathVariable Long id) {
        return employeServiceImpl.findById(id);
    }

    @PutMapping("/update/employe")
    public Employe updateEmploye(@RequestBody Employe employe) {
        return employeServiceImpl.update(employe);

    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return employeServiceImpl.delete(id);
        
    }

}
