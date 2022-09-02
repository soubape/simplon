package net.stc.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.stc.management.model.Exercice;



@Repository
public interface ExercieRepository extends JpaRepository<Exercice, Long>{

	List<Exercice> findAll();
}
