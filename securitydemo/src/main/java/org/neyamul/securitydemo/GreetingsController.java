package org.neyamul.securitydemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greetings")
public class GreetingsController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
