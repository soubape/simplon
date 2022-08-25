package com.many.to.many.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.many.to.many.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
