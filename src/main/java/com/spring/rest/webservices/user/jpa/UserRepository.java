package com.spring.rest.webservices.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.webservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
