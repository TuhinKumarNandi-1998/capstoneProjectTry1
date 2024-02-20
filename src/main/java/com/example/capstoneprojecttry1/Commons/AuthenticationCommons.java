package com.example.capstoneprojecttry1.Commons;

import com.example.capstoneprojecttry1.dtos.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationCommons {
    private RestTemplate restTemplate;

    public AuthenticationCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDTO validateToken(String token) {
        UserDTO userDTO = restTemplate.postForObject(
                "http://localhost:8181/users/validate/"+token,
                null,
                UserDTO.class);

        if(userDTO != null) {
            return userDTO;
        }
        return null;
    }
}
