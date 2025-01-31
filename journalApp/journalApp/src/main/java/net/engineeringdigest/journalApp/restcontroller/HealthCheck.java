package net.engineeringdigest.journalApp.restcontroller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    public String healthCheck() {
        return "OK";
    }
}
