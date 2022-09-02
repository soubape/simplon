package net.stc.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.stc.management.model.Responsable;



@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Long>{
	List<Responsable> findAll();

}
