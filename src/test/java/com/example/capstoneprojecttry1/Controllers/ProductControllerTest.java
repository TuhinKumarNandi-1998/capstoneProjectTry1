package com.example.capstoneprojecttry1.Controllers;

import com.example.capstoneprojecttry1.Exceptions.ProductNotFoundException;
import com.example.capstoneprojecttry1.Models.Product;
import com.example.capstoneprojecttry1.Repositories.ProductRepository;
import com.example.capstoneprojecttry1.Services.ProductServices.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

//    @Autowired
//    private ProductController productController;
//
//    @MockBean
//    private ProductService productService;
//
//    @MockBean
//    private ProductRepository productRepository;
//    @Test
//    void testProductSameAsService() {
//        // arrange
//        Product p1 = new Product();
//        p1.setTitle("Whey Protein Concentrate");
//
//        Product p2 = new Product();
//        p2.setTitle("Whey Protein Isolate");
//
//        Product p3 = new Product();
//        p3.setTitle("CreaPro Creatine");
//
//        List<Product> productList = new ArrayList<>();
//        productList.add(p1);
//        productList.add(p2);
//        productList.add(p3);
//
//        List<Product> actualProductList = new ArrayList<>();
//        for(Product p : productList) {
//            Product p11 = new Product();
//            p11.setTitle(p.getTitle());
//            actualProductList.add(p11);
//        }
//
//        when(
//                productService.getAllProducts()
//        ).thenReturn(
//               productList
//        );
//
//        // act
//        ResponseEntity<List<Product>> productsResponse = productController.getAllProducts();
//        List<Product> productsInResponse = productsResponse.getBody();
//
//        // assert
//        assertEquals(productList.size(), productsInResponse.size());
//
//        for(int i=0; i<productsInResponse.size(); i++) {
//            assertEquals(actualProductList.get(i).getTitle(), productsInResponse.get(i).getTitle());
//        }
//    }
//
//    @Test
//    void nonExistingProductThrowsExceptions() {
//        // arrange
//        when(
//                productRepository.findById(10l)
//        ).thenReturn(
//                Optional.empty()
//        );
//
//        // assert
//        assertThrows(
//                ProductNotFoundException.class,
//                () -> productController.getSingleProduct(10l)
//        );
//    }
}