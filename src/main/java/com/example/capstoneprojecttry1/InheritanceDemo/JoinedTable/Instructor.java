package com.example.capstoneprojecttry1.InheritanceDemo.JoinedTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_instructor")
public class Instructor extends User {
    private String favouriteStudent;
}
