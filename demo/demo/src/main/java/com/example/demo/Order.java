package com.example.demo;

import java.util.*;

public class Order {

public int orderid=1;
    public List<Product> products;

    public Map<String, Integer> p_quantity;
    public String Address;
    public double totalfees;

    public Order(int orderId, Product p,Integer q, String shippingAddress, double totalfees) {
        this.orderid = orderId;
        this.products = new ArrayList<Product>();
        this.products.add(p);
        this.p_quantity = new HashMap<>();
        this.p_quantity.put(p.name,q);
        this.Address = shippingAddress;
        this.totalfees = totalfees;
    }

//    public Optional<Order> cancelOrder(int orderId) {
//        Optional<Order> orderToCancel = orders.stream()
//                .filter(order -> order.getOrderId() == orderId)
//                .findFirst();
//
//        orderToCancel.ifPresent(orders::remove);
//        return orderToCancel;
//    }

}
