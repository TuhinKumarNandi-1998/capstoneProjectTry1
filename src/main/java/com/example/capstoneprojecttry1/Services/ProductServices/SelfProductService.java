package com.example.capstoneprojecttry1.Services.ProductServices;

import com.example.capstoneprojecttry1.Exceptions.ProductNotFoundException;
import com.example.capstoneprojecttry1.Models.Category;
import com.example.capstoneprojecttry1.Models.Product;
import com.example.capstoneprojecttry1.Repositories.CategoryRepository;
import com.example.capstoneprojecttry1.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service("selfProductService")
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    @Autowired
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()) {
            throw new ProductNotFoundException("Product with id "+id+" not found in DB.");
        }
        return productOptional.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(long id, Product product) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("product with the given id "+id+" not found.");
        }
        Product product1 = optionalProduct.get();
        if(product.getTitle() != null) {
            product1.setTitle(product.getTitle());
        }
        if(product.getPrice() != null){
            product1.setPrice(product.getPrice());
        }
        if(product.getDescription()!=null){
            product1.setDescription(product.getDescription());
        }
        if(product1.getImageUrl()!=null) {
            product1.setImageUrl(product.getImageUrl());
        }
        if(!product1.getCategory().getName().equalsIgnoreCase(product.getCategory().getName())) {
            Optional<Category> optionalCategory = categoryRepository.findByName(product.getCategory().getName());
            if(optionalCategory.isEmpty()) {
                Category category = categoryRepository.save(product.getCategory());
                product1.setCategory(category);
            }
            else {
                product1.setCategory(optionalCategory.get());
            }
        }
        return productRepository.save(product1);
    }

    @Override
    public Product addNewProduct(Product product) {
        Optional<Category> optionalCategory = categoryRepository.findByName(product.getCategory().getName());
        if(optionalCategory.isEmpty()) {

        }
        else {
            product.setCategory(optionalCategory.get());
        }
       return productRepository.save(product);
    }

    @Override
    public void deleteProduct(long productID) {
        productRepository.deleteProductById(productID);
    }

    @Override
    public Product replaceProduct(long productID, Product product) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productID);
        if(optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product with id "+productID+" not found");
        }
        Product product1 = optionalProduct.get();
        product1.setTitle(product.getTitle());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setImageUrl(product.getImageUrl());

        Optional<Category> optionalCategory = categoryRepository.findByName(product.getCategory().getName());
        if(optionalCategory.isEmpty()) {
            Category category = categoryRepository.save(product.getCategory());
            product1.setCategory(category);
        }
        else {
            product1.setCategory(optionalCategory.get());
        }
        return product1;
    }
}
