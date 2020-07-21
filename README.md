# following features has been done 
## 1- Setup Keycloak
## 2- Create token API
## 3- Refresh Token
## 4- Login with user registered on Keycloak
## 5- Authorization based on user role
## 6- Keycloak Auth Provider to validate token expiry

# Setup KeyCloak and integration with spring boot application

## 1.Download link
## https://www.keycloak.org/downloads
## unzip the zip folder and go to bin folder and run standalone.bat file
##                            OR 
## Run Keycloak using docker otherwise download and follow the steps from- https://www.keycloak.org/getting-started/getting-started-zip
## docker run -p "8080:8080" -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=pass jboss/keycloak
## check for basic steps- https://www.baeldung.com/spring-boot-keycloak
## 2. Create an admin account on http://localhost:8080/auth link
## 3.Login in to the admin console on http://localhost:8080/auth/admin/ link
## 4. Create a Realm:   SpringBootKeycloak
## 5. Add Client: login-app--->Valid Redirect URIs field: http://localhost:8081/*
## 6. Creating a Role and a User--> add the “user” role:--->We add the user “user1
## 7. Create a spring web application.
## 8. Integrate  spring web application with Keycloak

# Import KeycloakAPIs.postman_collection.json file into postmam and test rest api integration with Keycloak




