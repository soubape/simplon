package com.many.to.many.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.many.to.many.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{

}
