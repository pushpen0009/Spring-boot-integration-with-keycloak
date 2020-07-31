package com.keycloak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.keycloak.aop.Loggable;
import com.keycloak.client.KeycloakClient;
import com.keycloak.client.KeycloakResponse;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
public class AuthServiceController {
	
	@Autowired
	private KeycloakClient keycloakClient;
		
	@Loggable
	@PostMapping(
			  value = "/generateToken", consumes = "application/x-www-form-urlencoded", produces = "application/json")
	public KeycloakResponse generateToken1(@RequestBody MultiValueMap paramMap) {
		
		return keycloakClient.generateToken(paramMap);
	}

}
