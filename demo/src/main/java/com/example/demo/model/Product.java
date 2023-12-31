package com.example.demo.model;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serialNumber;
    private String name;
    private String vendor;
    private String category;
    private double price;
    private int remainingCount;

    // Constructors, Getters, and Setters (as previously shown)
}

