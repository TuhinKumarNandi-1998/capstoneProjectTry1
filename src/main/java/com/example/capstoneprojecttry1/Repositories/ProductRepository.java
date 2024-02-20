package com.example.capstoneprojecttry1.Repositories;

import com.example.capstoneprojecttry1.Models.Category;
import com.example.capstoneprojecttry1.Models.Product;
import com.example.capstoneprojecttry1.Projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAll();

    //find single product by id
    Optional<Product> findById(Long id);

    //Add new product
    Product save(Product product);

    //delete product by id
    Product deleteProductById(Long id);

    @Query("SELECT p.id as id, p.title as title FROM Product p WHERE p.id =:id")
    List<ProductWithIdAndTitle> someThingSomeThing(@Param("id") Long id);

    @Query(value = "SELECT * FROM product p WHERE p.id=:id",nativeQuery = true)
    List<Product> someSome2(@Param("id") Long id);
}
