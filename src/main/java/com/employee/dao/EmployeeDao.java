package com.employee.dao;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employee.pojo.EmployeePojo;

@Repository
public class EmployeeDao {
    
    private static final String delete_id = "delete from EmployeePojo p where p.id=:id";
    private static final String select_id = "select p from EmployeePojo p where p.id=:id";
    private static final String select_all = "select p from EmployeePojo p";

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void insert(EmployeePojo p) {
        em.persist(p);
    }

    @Transactional
    public int delete(int id) {
        Query query = getQuery(delete_id);
        query.setParameter("id", id);
        return query.executeUpdate();
    }

    public EmployeePojo select(int id) {
        TypedQuery<EmployeePojo> query = getQuery(select_id);
        query.setParameter("id", id);
        List<EmployeePojo> list = query.getResultList();
        return list.isEmpty() ? null : list.get(0);
    }

    public List<EmployeePojo> selectAll() {
        TypedQuery<EmployeePojo> query = getQuery(select_all);
        return query.getResultList();
    }

    @Transactional
    public void update(EmployeePojo p) {
        em.merge(p);
    }

    @Transactional
    public void update(int id, EmployeePojo p) {
        p.setId(id);
        em.merge(p);
    }

    TypedQuery<EmployeePojo> getQuery(String jpql){
        return em.createQuery(jpql, EmployeePojo.class);
    }
}
