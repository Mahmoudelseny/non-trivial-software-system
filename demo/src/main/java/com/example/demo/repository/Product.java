package com.example.demo.repository;

import com.example.demo.model.Product;

@Repository
public interface Product extends JpaRepository<Product, Long> {
    // Define custom queries or methods if needed
}

