package com.spring.rest.webservices.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.webservices.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
