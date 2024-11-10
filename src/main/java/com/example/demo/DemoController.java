package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello, " + name;
    }

    @PostMapping("/farewell")
    public String farewell(@RequestBody Person person) {
        return "Goodbye, " + person.getName() + "!";
    }

}
