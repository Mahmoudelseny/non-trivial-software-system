package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Customer {
    public Customer customer;
    public int id;
    public String name;
    public String username;
   public String hashedPassword;
    public double balance;
    public List<Order> purchases;

    AuthenticationService Service;

    public List<String> notifications;

   public String address ="";

    public Customer(int id, String name, String username, String hashedPassword, double balance,String address1) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.balance = balance;
        this.purchases = new ArrayList<>();
        this.notifications = new ArrayList<>();
        this.address=address1;
    }

    }
