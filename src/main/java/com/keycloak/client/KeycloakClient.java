package com.keycloak.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import feign.Headers;

@FeignClient(name="KeycloakApi", url="http://localhost:8080/auth/realms/mytoshika1/protocol/openid-connect" )
public interface KeycloakClient {
	
	@PostMapping(value="/token")
	@Headers("Content-Type: application/x-www-form-urlencoded")
	KeycloakResponse generateToken(@RequestBody MultiValueMap paramMap);

}
