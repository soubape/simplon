package com.stc.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stc.management.model.Administrateur;
import com.stc.management.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
	
//	Administrateur create(Administrateur administrateur);
//	Administrateur getAdministrateurById(long id);
//	Administrateur updateAdministrateur(Administrateur administrateur, long id);
//	void deleteadministrateur(long id);

}
