package com.employee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Employee API", description = "Employee greeting endpoints")
@RestController
public class ApiController {

    @Operation(summary = "Say hello to the supplied user")
    @RequestMapping(path= "/api/say-hello", method = RequestMethod.POST)
    public UserData sayHello(@RequestBody UserForm userform) {
        UserData data = new UserData();
        data.setName(userform.getName());
        data.setMessage("Howdy!");
        return data;
    }

    @Operation(summary = "Say hello to the default user")
    @RequestMapping(path= "/api/say-hello2", method = RequestMethod.GET)
    public UserData sayHello2() {
        UserData data = new UserData();
        data.setName("Default user");
        data.setMessage("Howdy!");
        return data;
    }
    
}
