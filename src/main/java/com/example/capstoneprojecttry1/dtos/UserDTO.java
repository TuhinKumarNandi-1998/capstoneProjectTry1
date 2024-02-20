package com.example.capstoneprojecttry1.dtos;

import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class UserDTO {
    private String name;
    private String email;
    private String hashedPassword;
    private List<Role> roles;
    private boolean isEmailVerified;
}
