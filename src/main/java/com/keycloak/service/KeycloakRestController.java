package com.keycloak.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/")
public class KeycloakRestController {
	
	 @GetMapping(path = "/checkStatus")
	 public String getcheckStatus() {
	        
	        return "ok";
	 }
	 
}
