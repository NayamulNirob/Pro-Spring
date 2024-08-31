package com.nirob.springBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {

    @RequestMapping("/")
    public String Home() {
        return "index";
    }

    @RequestMapping("/1")
    public String Contact() {
        return "contact";
    }
}
