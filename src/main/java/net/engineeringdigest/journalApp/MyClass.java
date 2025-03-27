package net.engineeringdigest.journalApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// REST API stands for Representational State Transfer Application Programming Interface
// HTTP verb + URL
// HTTP verb: GET-read, PUT-modify, POST-create, DELETE     |  URL: endoint localhost:80/netflix/plans
@RestController
class MyClass {

    @GetMapping("abc")
    public String sayHello() {
        return "Hello";
    }
}
