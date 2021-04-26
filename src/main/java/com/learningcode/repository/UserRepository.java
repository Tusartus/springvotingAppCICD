package com.learningcode.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.learningcode.domain.User;



public interface UserRepository extends JpaRepository<User, Long>{

  User findByUsername(String username);

}