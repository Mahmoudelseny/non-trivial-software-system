package com.example.demo.controllers;

import com.example.demo.Order;
import com.example.demo.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.demo.notification_system;



@RestController
@RequestMapping(value = "/order")
public class Order_ctr {

    public static List<Order> orders = new ArrayList<>();
    static List<Order> purchases= new ArrayList<>();

    public static List<String> templates = new ArrayList<>();
    Order_ctr(){
        orders = new ArrayList<Order>();
        purchases=new ArrayList<Order>();
        templates = new ArrayList<>();
    }

    // inserting new product in order

    public static String chooseorder(Product pro,int q,String add ) {

        int serialnum = pro.serialNumber;
        String p_name = pro.name;
        double p = pro.price;
        int orderid = 0;
        orderid=orderid;

            if (user_ctr.customer.address==add){
                System.out.println("user address is " + user_ctr.customer.address);
            }

            Order o = new Order(orderid, pro, q,add, p * q + 50);
            orders.add(o);


            for (Order o1 : orders) {
                if (!orders.isEmpty()) {
                    o.orderid++;
                }
            }

            String message = "order placed successfully for Order " + o.orderid;
            return message;

    }

       @GetMapping("/display_order")
    public static ResponseEntity<List<Order>> displayOrderAtIndex() {

           if (!orders.isEmpty()) {
               return ResponseEntity.ok(orders);
           } else {
               return ResponseEntity.noContent().build();
           }
    }

    @GetMapping ("/purchase_order/{id}/{c_id}")
    public static ResponseEntity<String> purchase_order(@PathVariable int id,@PathVariable int c_id){

        int o_id= id;
        int cus_id=c_id;


        for(Order o : orders){
            if(Objects.equals(o.orderid,o_id)){
                if (Objects.equals(user_ctr.customer.id,cus_id))
                 if(o.totalfees > user_ctr.customer.balance){
                    System.out.println();
                     String message = " .. insufficient funds! .. for Order_ID: " + o.orderid;
                     return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
                    }

                user_ctr.customer.balance -= o.totalfees;
                user_ctr.customer.purchases.add(o);
                orders.remove(o);
                String message2="Your order has been purchased successfully for Order_ID: " + o.orderid;

                notification_system.createTemplates();
                notification_system.createTemplates();
                notification_system.CreateNotification(o.products.get(0).name,user_ctr.customer.username);

                return ResponseEntity.status(HttpStatus.CREATED).body(message2);
            }
        }
        return null;
    }


    @GetMapping("/display_purchases")
    public static ResponseEntity<List<Order>> displayPurchases() {

        if (!user_ctr.customer.purchases.isEmpty()) {
            return ResponseEntity.ok(user_ctr.customer.purchases);
        } else {
            return ResponseEntity.noContent().build();
        }
    }



    @DeleteMapping("/CancelOrder/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable int orderId) {

        Order orderToCancel = null;

        for (Order order : orders) {
            if (orders.get(0).orderid == orderId) {
                orderToCancel = order;
                System.out.println(" ana henaaaa 1 ");
                break;
            }
        }

        if (orderToCancel != null) {

            orders.remove(orderToCancel);
            return ResponseEntity.ok("Order canceled successfully.");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }





}
