package com.example.demo.repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Define custom queries or methods if needed
}

