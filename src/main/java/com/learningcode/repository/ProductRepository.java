package com.learningcode.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learningcode.domain.Product;
import com.learningcode.domain.User;


public interface ProductRepository extends JpaRepository<Product, Long>{

  @Query("select p from Product p"
      + " join fetch p.user"
      + " where p.id = :id")
  Optional<Product> findByIdWithUser(Long id);
  
  List<Product> findByUser(User user);
  
  // this will (roughtly) create this SQL statement: select * from product where name = :name
  Optional<Product> findByName(String name); 
}
