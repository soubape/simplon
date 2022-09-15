package com.sous.health.pharmacie.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sous.health.pharmacie.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	

}
