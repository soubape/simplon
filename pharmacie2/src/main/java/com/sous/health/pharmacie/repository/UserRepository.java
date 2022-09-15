package com.sous.health.pharmacie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sous.health.pharmacie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);

	  Boolean existsByUsername(String username);

	  Boolean existsByPassword(String password);
}
