package com.example.capstoneprojecttry1.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.REMOVE)
//being already mapped by an attribute called category in Product class
    private List<Product> products;
    private String description;
}
