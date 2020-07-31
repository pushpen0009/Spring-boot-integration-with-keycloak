package com.keycloak.service;

import java.security.Principal;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
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
			System.out.println(token.getSubject());
		}
		
		return "Welcome, User:: "+principal.getName();
	}
	
	@GetMapping(path = "/test")
	public String hello() {

	    Keycloak keycloak = KeycloakBuilder.builder()
	    		.serverUrl("http://localhost:8080/auth")
	            .realm("master")
	            .grantType(OAuth2Constants.PASSWORD)
	            .clientId("admin-cli")
	            .username("admin")
	            .password("pass").build();
		

	    RealmResource realmResource = keycloak.realm("mytoshika");
	    
	    System.out.println("*************** GROUPS **************");
	    realmResource.groups().groups().stream().forEach(gr -> System.out.println(gr.getName()));
	    
	    System.out.println("*************** ROLES **************");
	    realmResource.roles().list().stream().forEach(ro -> System.out.println(ro.getName()));
	    
	    UserResource user = realmResource.users().get("f6c07617-4886-4dd1-92f7-35b3e60ab3d3");  // user id
	    user.joinGroup(realmResource.groups().groups().stream().filter(gr -> gr.getName().equals("visitors")).findFirst().get().getId());
	    
	    return realmResource.toRepresentation().getRealm();
	}

}
