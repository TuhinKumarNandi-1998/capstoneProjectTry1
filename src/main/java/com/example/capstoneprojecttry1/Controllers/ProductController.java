package com.example.capstoneprojecttry1.Controllers;

import com.example.capstoneprojecttry1.Commons.AuthenticationCommons;
import com.example.capstoneprojecttry1.Exceptions.ProductNotFoundException;
import com.example.capstoneprojecttry1.Models.Product;
import com.example.capstoneprojecttry1.Services.ProductServices.ProductService;
import com.example.capstoneprojecttry1.dtos.ProductNotFoundExceptionDTO;
import com.example.capstoneprojecttry1.dtos.Role;
import com.example.capstoneprojecttry1.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

 //Hey Spring this class is going to accept API request,
                // each method within this class will serve a particular API request as per the path defined

//Now I have to tell spring which on path I will have to serve the API request, the common prefix of the path of all the request I need to mention
@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private AuthenticationCommons authenticationCommons;

    @Autowired
    public ProductController(@Qualifier("selfProductService") ProductService productService,
                             AuthenticationCommons authenticationCommons) {
        this.productService = productService;
        this.authenticationCommons = authenticationCommons;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
//        UserDTO userDTO = authenticationCommons.validateToken(token);
//        if(userDTO==null) {
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//
//        boolean isAdmin = false;
//        List<Role> roles = userDTO.getRoles();
//        for(Role role : roles) {
//            if(role.getName().equalsIgnoreCase("ADMIN")){
//                isAdmin = true;
//                break;
//            }
//        }
//        if(!isAdmin) {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
        List<Product> products = productService.getAllProducts();

        List<Product> finalProducts = new ArrayList<>();
//        for(int i=0; i<products.size(); i++) {
//            Product p = products.get(i);
//            p.setTitle("Hello "+p.getTitle());
//            finalProducts.add(products.get(i));
//        }
        ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(products, HttpStatus.FOUND);
        return responseEntity;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") long id) throws ProductNotFoundException {

        ResponseEntity<Product> responseEntity = new ResponseEntity<>(
                productService.getSingleProduct(id), HttpStatus.OK);
        return responseEntity;
//        try {
//
//        }
//        catch (ArithmeticException arithmeticException) {
//            ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            return responseEntity;
//        }

    }
    //Handling Product Not Found exception in the controller class itself
    @org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDTO> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        ProductNotFoundExceptionDTO productNotFoundExceptionDTO = new ProductNotFoundExceptionDTO();
        productNotFoundExceptionDTO.setMessage("Product is not found in the DB mentioned at class");

        return new ResponseEntity<>(productNotFoundExceptionDTO, HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product product){
        return productService.addNewProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.replaceProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }
}
