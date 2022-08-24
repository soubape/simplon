package net.javaguides.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Admin;

@Repository
public interface UserRepository extends JpaRepository<Admin,Long> {

    Admin findByUsername(String username);
}