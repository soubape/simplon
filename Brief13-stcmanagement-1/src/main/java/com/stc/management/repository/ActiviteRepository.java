package com.stc.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stc.management.model.Activite;

@Repository
public interface ActiviteRepository extends JpaRepository<Activite, Long> {
	
//	Administrateur create(Administrateur administrateur);
//	Administrateur getAdministrateurById(long id);
//	Administrateur updateAdministrateur(Administrateur administrateur, long id);
//	void deleteadministrateur(long id);

}
