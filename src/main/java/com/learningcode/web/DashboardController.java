package com.learningcode.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learningcode.domain.Product;
import com.learningcode.domain.User;
import com.learningcode.repository.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.ModelMap;




@Controller
public class DashboardController {
	
	  @Autowired
	  private ProductRepository productRepo;
	  
  
  @RequestMapping(value="/", method=RequestMethod.GET)
  public String rootView () {
    return "index";
  }
  
  
  /*
  @GetMapping("/dashboard")
  public String dashboard() {
    return "dashboard";
  }
  */
  
  
  @GetMapping("/dashboard")
  public String dashboard(@AuthenticationPrincipal User user, ModelMap model) {
    List<Product> products = productRepo.findByUser(user);
    
    model.put("products", products);
    
    return "dashboard";
  }
  
  
  
}

