package com.example.capstoneprojecttry1.Services.CategoryServices;

import com.example.capstoneprojecttry1.Exceptions.CategoryNotFoundException;
import com.example.capstoneprojecttry1.Models.Category;
import com.example.capstoneprojecttry1.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfCategoryService implements CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public SelfCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getACategoryByID(Long id) throws CategoryNotFoundException {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if(optionalCategory.isEmpty()) {
            throw new CategoryNotFoundException("Category with id "+id+" not found");
        }

        return optionalCategory.get();
    }
}
