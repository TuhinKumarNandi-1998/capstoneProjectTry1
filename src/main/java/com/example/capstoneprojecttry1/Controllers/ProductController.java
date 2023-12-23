package com.example.capstoneprojecttry1.Controllers;

import com.example.capstoneprojecttry1.Models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

 //Hey Spring this class is going to accept API request,
                // each method within this class will serve a particular API request as per the path defined

//Now I have to tell spring which on path I will have to serve the API request, the common prefix of the path of all the request I need to mention
@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping()
    public List<Product> getAllProducts(){
        return new ArrayList<>();
    }


    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") long id){
        return new Product();
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product product){
        Product p = new Product();
        p.setTitle("A new Product");
        return p;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){

    }
}
