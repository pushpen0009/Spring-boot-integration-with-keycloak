package com.keycloak.service;

import java.security.Principal;
import java.util.Map;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/")
public class TestRestController {

	@GetMapping(path = "/tokenInfo")
	public String getcheckStatus(Principal principal) {

		if (principal instanceof KeycloakPrincipal) {

			KeycloakPrincipal<KeycloakSecurityContext> kp = (KeycloakPrincipal<KeycloakSecurityContext>) principal;
			AccessToken token = kp.getKeycloakSecurityContext().getToken();
			System.out.println(token.getId());
			System.out.println(token.getName());
			System.out.println(token.getOtherClaims());
		}
		
		return "Welcome, User:: "+principal.getName();
	}

}
