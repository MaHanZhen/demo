package com.example.demo2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Controller 里面的方法都以 json
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        System.out.println("123");
        System.out.println("456");
        System.out.println("789");
        System.out.println("2333");
        System.out.println("bbiub");
        System.out.println("qaq");
        return "Hello World888";
    }
}
