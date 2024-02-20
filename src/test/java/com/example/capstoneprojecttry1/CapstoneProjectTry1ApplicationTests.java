package com.example.capstoneprojecttry1;

import com.example.capstoneprojecttry1.Models.Product;
import com.example.capstoneprojecttry1.Projections.ProductWithIdAndTitle;
import com.example.capstoneprojecttry1.Repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class CapstoneProjectTry1ApplicationTests {
    @Autowired
    ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

//    @Test
//    @Transactional
//    @Commit
//    void testQueries() {
//        List<ProductWithIdAndTitle> productList = productRepository.someThingSomeThing(52l);
//        for(ProductWithIdAndTitle product : productList){
//            System.out.println(product.getId());
//            System.out.println(product.getTitle());
//        }
//
//        List<Product> products = productRepository.someSome2(3l);
//    }
}
