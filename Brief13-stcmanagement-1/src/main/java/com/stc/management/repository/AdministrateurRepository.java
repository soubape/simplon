package com.stc.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stc.management.model.Administrateur;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {

	List<com.stc.management.model.Administrateur> findAll();
	
//	Administrateur create(Administrateur administrateur);
//	Administrateur getAdministrateurById(long id);
//	Administrateur updateAdministrateur(Administrateur administrateur, long id);
//	void deleteadministrateur(long id);

}
