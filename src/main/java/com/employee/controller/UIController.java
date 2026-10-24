package com.employee.controller;

import com.employee.model.InfoData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {

    @Value("${app.baseUrl:/employee-app}")
    private String baseUrl;
    
    @GetMapping("/")
    public String index() {
        return "forward:/html/index.html";
    }

    @GetMapping({"/ui/home", "/ui/home.html"})
    public ModelAndView home() {
        return mav("home");
    }

    @GetMapping({"/ui/features", "/ui/features.html"})
    public ModelAndView features() {
        return mav("features");
    }

    @GetMapping({"/ui/pricing", "/ui/pricing.html"})
    public ModelAndView pricing() {
        return mav("pricing");
    }

    private ModelAndView mav(String page) {
        ModelAndView mav = new ModelAndView(page);
        mav.addObject("Info", new InfoData());
        mav.addObject("baseUrl", baseUrl);
        return mav;
    }

}