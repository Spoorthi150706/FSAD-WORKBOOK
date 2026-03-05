package com.klu.productsearch.controller;

import com.klu.productsearch.entity.Product;
import com.klu.productsearch.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    // Get All Products
    @GetMapping
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    // Category Search
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    // Price Filter
    @GetMapping("/filter")
    public List<Product> filterByPrice(@RequestParam double min,
                                       @RequestParam double max) {
        return repo.findByPriceBetween(min, max);
    }

    // Sorted Products
    @GetMapping("/sorted")
    public List<Product> getSortedProducts() {
        return repo.getProductsSortedByPrice();
    }

    // Expensive Products
    @GetMapping("/expensive/{price}")
    public List<Product> getExpensive(@PathVariable double price) {
        return repo.getExpensiveProducts(price);
    }
}