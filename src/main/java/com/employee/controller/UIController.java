package com.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {
    
    @GetMapping("/")
    public String index() {
        return "forward:/html/index.html";
    }

    @GetMapping({"/ui/home", "/ui/home.html"})
    public String home() {
        return "forward:/html/home.html";
    }

    @GetMapping({"/ui/features", "/ui/features.html"})
    public String features() {
        return "forward:/html/features.html";
    }

    @GetMapping({"/ui/pricing", "/ui/pricing.html"})
    public String pricing() {
        return "forward:/html/pricing.html";
    }

}
