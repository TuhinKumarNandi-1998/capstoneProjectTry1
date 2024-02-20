package com.example.capstoneprojecttry1.dtos;

import com.example.capstoneprojecttry1.Models.BaseModel;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role extends BaseModel {
    private String name;
}
