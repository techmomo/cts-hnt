package com.mohsinkd786.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //@PreAuthorize("")
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
}


// POST api - to generate JWT
// POST/GET api - to validate JWT via header


