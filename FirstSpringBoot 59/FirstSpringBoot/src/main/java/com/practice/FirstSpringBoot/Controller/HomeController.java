package com.practice.FirstSpringBoot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
@RequestMapping("/home")
    public String home(){
        return "index";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }
}
