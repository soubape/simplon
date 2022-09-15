package com.sous.health.pharmacie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sous.health.pharmacie.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
