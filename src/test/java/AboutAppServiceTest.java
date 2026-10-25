package com.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.employee.service.AboutAppService;

public class AboutAppServiceTest extends AbstractUnitTest {

    @Autowired
    private AboutAppService service;

    @Test
    public void testServiceApis() {
        assertEquals("Employee Application", service.getName());
        assertEquals("1.0", service.getVersion());
    }
}

