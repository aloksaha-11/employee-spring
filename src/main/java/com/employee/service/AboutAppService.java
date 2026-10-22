package com.employee.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AboutAppService {

/*   @Autowired
    private EmployeeDao dao;

    public void add(EmployeePojo p) {
        normalize(p);
        dao.insert(p);
    } */
        @Value("${app.name}")
        private String name;
        @Value("${app.version}")
        private String version;

        public String getName() {
            return name;

        }

        public String getVersion() {
            return version;

        }
}
    /*public void delete(int id) {
        dao.delete(id);        
    }

    public EmployeePojo get(int id) throws ApiException {
        EmployeePojo p = getCheck(id);
        return p;        
    }

      
    public List<EmployeePojo> getAll() {
        return dao.selectAll();
    }

    public void update(int id, EmployeePojo p) throws ApiException {
     normalize(p);
     getCheck(id);
     dao.update(id, p); 
    }

    public EmployeePojo getCheck(int id) throws ApiException {
        EmployeePojo p = dao.select(id);
        if(p == null) {
            throw new ApiException("Employee with given ID does not exist, id:" + id);
        }
        return p;
    }

    private static void normalize(EmployeePojo p) {
        p.setName(p.getName().toLowerCase().trim());
    }*/

