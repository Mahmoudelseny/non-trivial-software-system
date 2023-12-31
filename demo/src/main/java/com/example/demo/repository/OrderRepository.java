package com.example.demo.repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Define custom queries or methods if needed
}

