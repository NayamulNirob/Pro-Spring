package org.neyamul.securitydemo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasRole;

@RestController
@RequestMapping("/api/greetings")
public class GreetingsController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/admin")
    public String admin() {
        return "Hello, Admin!";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping("/user")
    public String user() {
        return "Hello, User!";
    }
}
