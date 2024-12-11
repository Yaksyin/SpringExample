package com.kopi.learning_spring_yaksyin.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/greeting/{coffe}")
    public String greeting(@PathVariable String coffe){
        return String.format("Hello, %s!",coffe);
    }
}
