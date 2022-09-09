package net.stc.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.stc.management.model.Administrateur;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {
	List<Administrateur> findAll();
}
