package com.remzi.springblogapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remzi.springblogapi.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
