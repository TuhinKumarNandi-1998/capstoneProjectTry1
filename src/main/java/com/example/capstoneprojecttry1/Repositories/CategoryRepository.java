package com.example.capstoneprojecttry1.Repositories;

import com.example.capstoneprojecttry1.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
    Category save(Category category);

    List<Category> findAll();

    Optional<Category> findById(Long id);
}
