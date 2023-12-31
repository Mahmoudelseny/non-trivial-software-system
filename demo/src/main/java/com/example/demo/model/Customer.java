package com.example.demo.model;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private double balance;

    // Constructors, Getters, and Setters (as previously shown)
}

