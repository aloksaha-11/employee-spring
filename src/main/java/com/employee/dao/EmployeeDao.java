package com.employee.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.pojo.EmployeePojo;

@Repository
public class EmployeeDao {
    /* private HashMap<Integer, EmployeePojo> rows;
    private int lastId; */
    
    private static String delete_row = "delete from EmployeePojo where id=:id";
    private static String select_id = "select from EmployeePojo where id=:id";
    private static String select_all = "select from EmployeePojo"; 

    @Autowired
    EntityManager em;
    
    /* @PostConstruct
    public void init() {
        rows = new HashMap<Integer, EmployeePojo>();
    } */

    public void insert(EmployeePojo p) {
        /*lastId++;
        p.setId(lastId);
        rows.put(lastId, p); */
        em.persist(p);
        
    }

    public void delete(int id) {
        /* rows.remove(id); */
        TypedQuery<EmployeePojo> query = createQuery(delete_row, EmployeePojo.class);
        query.setParameter("id", id);
        int result = query.executeUpdate();
        return result;
        
    }

    public EmployeePojo select(int id) {
        /* return rows.get(id); */
        TypedQuery<EmployeePojo> query = createQuery(select_id, EmployeePojo.class);
        query.setParameter("id", id);
        EmployeePojo result = query.getSingleResult();
        return results;
    }

    public List<EmployeePojo> selectAll() {
        /* ArrayList<EmployeePojo> list = new ArrayList<EmployeePojo>();
        list.addAll(rows.values());
        return list; */
        TypedQuery<EmployeePojo> query = createQuery(select_all, EmployeePojo.class);
        /* query.setParameter("id", id); */
        List<EmployeePojo> results = query.getResultList();
        return results;
    }

    public void update(int id, EmployeePojo p) {
        /* rows.put(id,p); */
        p.setId(id);
        
    }

}
