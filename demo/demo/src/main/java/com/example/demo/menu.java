//package com.order.system;
//
//import com.order.system.controllers.Order_ctr;
//import com.order.system.controllers.product_CTR;
//import com.order.system.controllers.user_ctr;
//
//import com.order.system.AuthenticationService;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class menu {
//
//
//   public Map<String, Customer> registeredUsers = new HashMap<>();
//    public static void firstmenu(){
//
//
//        System.out.println("Welcome!");
//        System.out.println("1. Register");
//        System.out.println("2. Login");
//        System.out.println("3. Exit");
//        System.out.print("Choose an option: ");
//        Scanner scanner = new Scanner(System.in);
//        int choice = Integer.parseInt(scanner.next());
////        scanner.nextLine();
////        scanner.close();
//        switch (choice) {
//            case 1:
//                System.out.println("You chose to register.");
////                user_ctr.create_acc();
//                break;
//            case 2:
//                System.out.println("You chose to login.");
//
//                user_ctr.login();
//                break;
//            case 3:
//                System.out.println("Exiting...");
////                scanner.close(); // Close the scanner before exiting
//                return;
//            default:
//                System.out.println("Invalid choice!");
//                break;
//        }
//    }
//
//    public static void secondmenu(){
//
//        System.out.println("Welcome to second menu!");
//        System.out.println("1. display products");
//        System.out.println("2. choose product");
//        System.out.println("3. display order");
//        System.out.println("4. purchase order");
//        System.out.println("5. view inbox");
//        System.out.println("6. logout");
//        System.out.print("Choose an option: ");
//        Scanner scanner = new Scanner(System.in);
//        int choice = Integer.parseInt(scanner.next());
////        scanner.close();
//        switch (choice) {
//            case 1:
//                product_CTR.display();
//                break;
//            case 2:
//                product_CTR.choose_product();
//                break;
//            case 3:
//                Order_ctr.display_order();
//                break;
//            case 4:
//                Order purchased = Order_ctr.purchase_order();
//                if(purchased == null) break;
//                String msg = notification_system.create_notif(user_ctr.customer.username,purchased.products.get(0).name);
//                user_ctr.customer.notifications.add(msg);
//                break;
//            case 5:
//                user_ctr.inbox();
//                break;
//            case 6:
//                user_ctr.customer = null;
//                break;
//            default:
//                System.out.println("Invalid choice!");
//                break;
//        }
//
//    }
//
//}
