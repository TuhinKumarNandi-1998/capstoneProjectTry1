package com.example.capstoneprojecttry1.Services.CategoryServices;

import com.example.capstoneprojecttry1.Exceptions.CategoryNotFoundException;
import com.example.capstoneprojecttry1.Models.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategory();
    public Category getACategoryByID(Long id) throws CategoryNotFoundException;
}
