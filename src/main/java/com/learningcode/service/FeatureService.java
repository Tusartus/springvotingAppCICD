package com.learningcode.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningcode.domain.Feature;
import com.learningcode.domain.Product;
import com.learningcode.domain.User;
import com.learningcode.repository.FeatureRepository;
import com.learningcode.repository.ProductRepository;



@Service
public class FeatureService {
  @Autowired
  private ProductRepository productRepo;
  @Autowired
  private FeatureRepository featureRepo;
  
  public Feature createFeature(Long productId, User user) {
    Feature feature = new Feature();
    
    Optional<Product> productOpt = productRepo.findById(productId);
    
    if (productOpt.isPresent()) {
      Product product = productOpt.get();
      
      feature.setProduct(product);     // on Feature  we have Product product getter setter ManyToOne
      product.getFeatures().add(feature);  //on Product.java   set<Feature> features = new HashSet<>(); OneToMany 
      
      feature.setUser(user);      // on Feature  we have User user getter setter ManyToOne 
      user.getFeatures().add(feature); //on User.java   set<Feature> features = new HashSet<>(); OneToMany 
      
      feature.setStatus("Pending review");
      
      return featureRepo.save(feature);
    }
    
    return feature;
  }

  public Feature save(Feature feature) {
    return featureRepo.save(feature);
  }

  public Optional<Feature> findById(Long featureId) {
    return featureRepo.findById(featureId);
  }
}
