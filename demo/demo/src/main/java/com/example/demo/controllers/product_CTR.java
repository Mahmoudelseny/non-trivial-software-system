package com.example.demo.controllers;
import com.example.demo.controllers.user_ctr;
import com.example.demo.Category;
import com.example.demo.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController

@RequestMapping(value = "/product")

public class product_CTR {
    public static Map<String, Product> stock = new HashMap<>();

    static List<Category> categories = new ArrayList<>();
    static int serial = 0;

    public product_CTR() {
        this.stock = new HashMap<>();
        user_ctr user_ctr = new user_ctr();

    }

    @GetMapping("/runStock")
    public static ResponseEntity<String> runadmin() {
        Product p = new Product(serial++, "Iphone 12", "Apple", "mobile", 12000, 30);
        Product p1 = new Product(serial++, "samsung s15", "samsung", "mobile", 11000, 10);
        Product p2 = new Product(serial++, "Iphone 13", "Apple", "mobile", 30000, 40);
        Product p3 = new Product(serial++, "Iphone 11", "Apple", "mobile", 9000, 30);
        Product p4 = new Product(serial++, "hawawi13", "hawawii", "mobile", 2000, 11);
        Product p5 = new Product(serial++, "mobile cover", "mt4", "accessory", 2000, 6);
        Product p6 = new Product(serial++, "charger", "mt4", "accessory", 120, 7);
        Product p7 = new Product(serial++, "screen", "sony", "accessory", 100, 66);
        Product p8 = new Product(serial++, "buds", "wq3", "accessory", 1000, 11);
        Product p9 = new Product(serial++, "hand free", "z101", "accessory", 3000, 2);
        Product p10 = new Product(serial++, "wire-t4", "Apple", "accessory", 1000, 32);
        stock.put(p.name, p);
        stock.put(p1.name, p1);
        stock.put(p2.name, p2);
        stock.put(p3.name, p3);
        stock.put(p4.name, p4);
        stock.put(p5.name, p5);
        stock.put(p6.name, p6);
        stock.put(p7.name, p7);
        stock.put(p8.name, p8);
        stock.put(p9.name, p9);
        stock.put(p10.name, p10);

        for (Product product : stock.values()) {
            boolean found = false;
            for (Category c : categories) {
                if (product.category == c.name) {
                    c.quantity += product.quantity;
                    found = true;
                }
            }
            if (!found) {
                categories.add(new Category(product.category, product.quantity));
            }
        }
        String message = " --- Stock has been set successfully --- ";
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }


    // user
    @GetMapping("/displayStock")
    public static ResponseEntity<Map<String, Product>> DisplayStock() {
        System.out.println("List of Products");
        if (!stock.isEmpty())
            for (Product p : stock.values()) {

                return ResponseEntity.ok(stock);
            }
        else {
            return ResponseEntity.noContent().build();
        }
    return null;
    }



@PostMapping("/chooseProduct/{name}/{quantity}")
    public static ResponseEntity<Product> choose_product(@PathVariable int quantity ,@PathVariable String name){

        System.out.println("enter name:");

        Product p = stock.get(name);
        if(p == null){
            System.out.println("no product with this name!!");
            return ResponseEntity.noContent().build();
        }

        System.out.println("enter quantity:");

        Integer q = quantity;
        if(q > p.quantity){
            System.out.println("invalid quantity");
            return ResponseEntity.noContent().build();
        }

       Order_ctr.chooseorder(p,q,user_ctr.customer.address);

    return ResponseEntity.ok(stock.get(name));
    }
}
