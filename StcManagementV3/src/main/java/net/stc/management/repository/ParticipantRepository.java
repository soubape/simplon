package net.stc.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.stc.management.model.Participant;


@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
	List<Participant> findAll();
}
