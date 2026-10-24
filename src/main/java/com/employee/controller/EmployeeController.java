package com.employee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.employee.pojo.EmployeePojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.model.EmployeeForm;
import com.employee.model.EmployeeData;
import com.employee.service.EmployeeService;
import com.employee.service.ApiException;

@Tag(name = "Employee API", description = "Employee endpoints")
@RestController

public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Operation(summary = "Adds an employee")
    @RequestMapping(path= "/api/employee", method = RequestMethod.POST)
    public void add(@RequestBody EmployeeForm form) {
        EmployeePojo p = convert(form);
        service.add(p);
    }

    @Operation(summary = "Deletes an employee")
    @RequestMapping(path= "/api/employee/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
    
    @Operation(summary = "Gets an employee by id")
    @RequestMapping(path= "/api/employee/{id}", method = RequestMethod.GET)
    public EmployeeData get(@PathVariable int id) throws ApiException {
        EmployeePojo p = service.get(id);
        return convert(p);
    }

    @Operation(summary = "Updates an employee")
    @RequestMapping(path= "/api/employee/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable int id, @RequestBody EmployeeForm f) throws ApiException {
        EmployeePojo p = convert(f);
        service.update(id, p);
    }

    @Operation(summary = "Get list of all employees")
    @RequestMapping(path= "/api/employee", method = RequestMethod.GET)
    public List<EmployeeData> getAll() {
        List<EmployeePojo> list = service.getAll();
        List<EmployeeData> list2 = new ArrayList<EmployeeData>();
        for(EmployeePojo p: list) {
            list2.add(convert(p));
        }
        return list2;
    }

    private static EmployeeData convert(EmployeePojo p) {
        EmployeeData d = new EmployeeData();
        d.setId(p.getId());
        d.setAge(p.getAge());
        d.setName(p.getName());
        return d;
    }

    private static EmployeePojo convert(EmployeeForm userForm) {
        EmployeePojo p = new EmployeePojo();
        p.setAge(userForm.getAge());
        p.setName(userForm.getName());
        return p;
    }

    /*@Operation(summary = "Say hello to the default user")
    @RequestMapping(path= "/api", method = RequestMethod.GET)
    public UserData sayHello2() {
        UserData data = new UserData();
        data.setName("Default user");
        data.setMessage("Howdy!");
        return data;
    }*/
    
}
