package com.employee.controller;

import com.employee.model.AboutApp;
import com.employee.service.AboutAppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "About App")
@RestController

public class AboutAppController {

    @Autowired
    private AboutAppService service;

    @Operation(summary = "Gives application name and version")
    @GetMapping("/api/about")
    public AboutApp getDetails() {
        AboutApp d = new AboutApp();
        d.setName(service.getName());
        d.setVersion(service.getVersion());
        return d;
    }
}

