package com.nayamul.ecomarceapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Hello {

    @GetMapping("view")
    public String hello() {
        return "Hello World";
    }
}
