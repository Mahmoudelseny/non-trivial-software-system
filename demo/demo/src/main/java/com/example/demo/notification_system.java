package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/notification")

public class notification_system {
    public static List<String> templates = new ArrayList<>();
    public static List<String> Messages = new ArrayList<>();


    notification_system(){
        templates = new ArrayList<>();
        Messages = new ArrayList<>();

    }
    public static void createTemplates(){

        String s = "Dear {x} , your booking of the {y}  is confirmed. thanks for using our store :) ";
        templates.add(s);

}
    public static String CreateNotification(String prodname,String username){

        String msg = "";
        String username1 = username;
        String prodname1=prodname;

        String template = templates.get(0);

        for(int i=0;i<template.length();i++){
            if(template.charAt(i) == '{'){
                if(template.charAt(i+1) == 'x')
                    msg += username1;
                if(template.charAt(i+1) == 'y')
                    msg += prodname1;
                i+=3;
            }
            else{
                msg += template.charAt(i);
            }
        }

        Messages.add(msg);
        return msg;

    }
@GetMapping("/ViewInbox")
    public ResponseEntity<List<String>>ViewInbox(){
        if(!Messages.isEmpty()){
          return ResponseEntity.ok(Messages);
        }else {
            return ResponseEntity.noContent().build();
        }
    }
}
