package net.stc.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.stc.management.model.Activite;
@Repository
public interface ActiviteRepository extends JpaRepository<Activite, Long> {
	List<Activite> findAll();

}
