package com.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.transaction.annotation.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.employee.pojo.EmployeePojo;
import com.employee.service.EmployeeService;

public class EmployeeServiceTest  extends AbstractUnitTest {

    @Autowired

    private EmployeeService service;

    @Test
    public void testAdd() {
        EmployeePojo p = new EmployeePojo();
        p.setName(" Alok Saha");
        service.add(p);
    }

    @Test
    public void testNormalize() {
        EmployeePojo p = new EmployeePojo();
        p.setName(" Alok Saha ");
        EmployeeService.normalize(p);
        assertEquals("alok saha", p.getName());

        // Call the add method of EmployeeService and assert the expected behavior
    }
}