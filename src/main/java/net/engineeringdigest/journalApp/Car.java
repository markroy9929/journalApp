package net.engineeringdigest.journalApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // @Bean bna dega
public class Car {

    @Autowired  // Dependency injection
    private Dog dog;  // Field injection

    @GetMapping("/ok")
    public String ok() {
        return dog.fun();
    }
}
