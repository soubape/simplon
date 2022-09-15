package com.sous.health.pharmacie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sous.health.pharmacie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
