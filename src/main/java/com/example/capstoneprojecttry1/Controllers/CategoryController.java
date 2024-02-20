package com.example.capstoneprojecttry1.Controllers;

import com.example.capstoneprojecttry1.Exceptions.CategoryNotFoundException;
import com.example.capstoneprojecttry1.Models.Category;
import com.example.capstoneprojecttry1.Services.CategoryServices.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getACategory(@PathVariable("id") Long id) throws CategoryNotFoundException {
        ResponseEntity<Category> responseEntity = new ResponseEntity<>(categoryService.getACategoryByID(id), HttpStatus.OK);
        return responseEntity;
    }
}
