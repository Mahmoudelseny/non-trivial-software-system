package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {

//check this again because i'am not sure if it must be final or not :)

            //    ###################################### //
        private  Map<String, Customer> registeredUsers = new HashMap<>();

        public void registerUser(Customer customer, String password) {
//            String hashedPassword = hashPassword(password);
//            customer.hashedPassword = hashedPassword;
            registeredUsers.put(customer.username, customer);
        }


    //  authentication
    public boolean authuser(String username, String password) {
            Customer customer = registeredUsers.get(username);
            if (customer != null) {
                String hashedPassword = hashPassword(password);
                return hashedPassword.equals(customer.hashedPassword);
            }
            return false;
        }

        public Customer login(String username, String password){
            return registeredUsers.get(username);
        }

        private String hashPassword(String password) {
            return password;
        }

    }



