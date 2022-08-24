package com.stc.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.stc.management.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	List<Users> findAll();
	
//	Administrateur create(Administrateur administrateur);
//	Administrateur getAdministrateurById(long id);
//	Administrateur updateAdministrateur(Administrateur administrateur, long id);
//	void deleteadministrateur(long id);

}
