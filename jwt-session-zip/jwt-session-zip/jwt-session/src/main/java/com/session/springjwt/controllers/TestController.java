package com.session.springjwt.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
	
  @GetMapping("/public")
  public String publicMethod() {
    return "This Method is Public and No Authorization given for this Method";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public String UserMethod() {
    return "This Method can access by User,Moderator & Admin";
  }

  @GetMapping("/moderator")
  @PreAuthorize("hasRole('MODERATOR')")
  public String moderatorMethod() {
    return "This method can access by Moderator alone";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminMethod() {
    return "This method can access by Admin alone";
  }
}
