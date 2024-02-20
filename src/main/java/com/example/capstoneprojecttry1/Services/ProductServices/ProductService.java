package com.example.capstoneprojecttry1.Services.ProductServices;

import com.example.capstoneprojecttry1.Exceptions.ProductNotFoundException;
import com.example.capstoneprojecttry1.Models.Product;

import java.util.List;

public interface ProductService {
    public Product getSingleProduct(long id) throws ProductNotFoundException;

    public List<Product> getAllProducts();

    public Product updateProduct(long id, Product product) throws ProductNotFoundException;

    public Product addNewProduct(Product product);

    public void deleteProduct(long productID);
    public Product replaceProduct(long productID, Product product) throws ProductNotFoundException;
}
