package com.sous.health.pharmacie.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sous.health.pharmacie.entities.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
	

}
