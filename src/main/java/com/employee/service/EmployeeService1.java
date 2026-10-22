package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.pojo.EmployeePojo;

@Service
public class EmployeeService1 {
    
    @Autowired
    private EmployeeDao dao;

    public void addList(List<EmployeePojo> list) {
        for(EmployeePojo p: list) {
            dao.insert(p);
        }
    }
}

    /*public void delete(int id) {
        dao.delete(id);        
    }

    public EmployeePojo get(int id) {
        return dao.select(id);        
    }
    
    public List<EmployeePojo> getAll() {
        return dao.selectAll();
    }

    public void update(int id, EmployeeoPojo newPojo) {
     dao.update(id, newPojo);        
    }
    
}*/


