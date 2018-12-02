package com.tausif.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class GreetingRestController {

    @GetMapping("greeting")
    public String greeting(Principal principal){
        return "hello "+ principal.getName()+ " !";
    }
}
