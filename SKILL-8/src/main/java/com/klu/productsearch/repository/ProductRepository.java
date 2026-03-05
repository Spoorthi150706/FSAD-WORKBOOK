package com.klu.productsearch.repository;

import com.klu.productsearch.entity.Product;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // 🔹 Derived Methods
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    // 🔹 JPQL Queries

    // Sort by price
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> getProductsSortedByPrice();

    // Products above given price
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> getExpensiveProducts(@Param("price") double price);

    // Fetch by category
    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> getProductsByCategory(@Param("category") String category);
}