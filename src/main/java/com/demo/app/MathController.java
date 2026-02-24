package com.demo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class MathController {

    @Autowired
    private MathService mathService;

    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "ok");
        response.put("message", "Java Spring Boot App is running!");
        return response;
    }

    @GetMapping("/demo")
    public Map<String, Object> demo() {
        Map<String, Object> response = new HashMap<>();
        response.put("greet", mathService.greet("World"));
        response.put("add", mathService.add(10, 32));
        response.put("divide", mathService.divide(100, 4));
        return response;
    }

    @GetMapping("/add")
    public Map<String, Object> add(@RequestParam int a, @RequestParam int b) {
        Map<String, Object> response = new HashMap<>();
        response.put("result", mathService.add(a, b));
        return response;
    }
}
