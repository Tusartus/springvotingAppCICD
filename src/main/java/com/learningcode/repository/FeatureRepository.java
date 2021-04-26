package com.learningcode.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningcode.domain.Feature;



@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {

}
