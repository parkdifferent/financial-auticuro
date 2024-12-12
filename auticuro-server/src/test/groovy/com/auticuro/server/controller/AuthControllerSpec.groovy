package com.auticuro.server.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = com.auticuro.server.AuticuroServerApplication.class)
class AuthControllerSpec extends Specification {

    @Autowired
    TestRestTemplate restTemplate

    def "test user registration"() {
        when: "A user registers with username and password"
        ResponseEntity<String> response = restTemplate.postForEntity("/api/auth/register", [username: "testuser", password: "password"], String)

        then: "The response status is OK"
        response.statusCode == HttpStatus.OK

        and: "The response body contains a success message"
        response.body.contains("User registered successfully")
    }

    def "test user login"() {
        when: "A user logs in with username and password"
        ResponseEntity<String> response = restTemplate.postForEntity("/api/auth/login", [username: "testuser", password: "password"], String)

        then: "The response status is OK"
        response.statusCode == HttpStatus.OK

        and: "The response body contains a success message"
        response.body.contains("User logged in successfully")
    }
}
