package com.example.practice_springboot2;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/users")
    public String Firstfunc(){
        return "hello this is spring boot project";
    }
}
