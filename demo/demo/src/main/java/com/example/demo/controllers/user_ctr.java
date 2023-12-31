package com.example.demo.controllers;

import com.example.demo.AuthenticationService;
import com.example.demo.Customer;
//import com.order.system.AuthenticationService;
//import com.order.system.Customer;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class user_ctr {

    public static AuthenticationService auth = new AuthenticationService();

    public static Customer customer;

    public static int id = 1;

    @PostMapping(value = "/register")
    public static ResponseEntity<String> create_acc(@RequestBody Customer c){

        String name=c.name;
        String username=c.username;
        String pass =c.hashedPassword;
        double balance = c.balance;
        String address=c.address;

        System.out.println(c.name);
        c = new Customer(id++,name,username,pass,balance,address);
        auth.registerUser(c,pass);//customer,pass);
        System.out.println("welcome " + name);
        return ResponseEntity.status(HttpStatus.CREATED).body(name);

    }

@PostMapping(value = "/login")
    public static ResponseEntity<String> login(@RequestBody Customer c2){

     String name = c2.username; String pass = c2.hashedPassword;

        if(auth.authuser(name,pass)){
            customer = auth.login(name,pass);
            String message = "login successful for " + name;
            System.out.println("welcome " + name);
            return  ResponseEntity.status(HttpStatus.CREATED).body(message);


        }
        else{
            System.out.println("wrong password/username");
        }

        return  ResponseEntity.status(HttpStatus.CREATED).body("end");
    }

    public static void inbox(){
        if(customer.notifications.isEmpty()){
            System.out.println("inbox in empty!!");
            return;
        }
        for(String e : customer.notifications){
            System.out.println(e);
        }
    }

}

