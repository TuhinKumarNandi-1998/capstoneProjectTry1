package com.example.capstoneprojecttry1.InheritanceDemo.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_mentor")
public class Mentor extends User{
    private double avgRating;
}
