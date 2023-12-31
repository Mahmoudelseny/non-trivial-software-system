package com.example.demo.model;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Product> products;

    @ManyToOne
    private Customer customer;

    private boolean isCompoundOrder;

    // Constructors, Getters, and Setters (as previously shown)
}

