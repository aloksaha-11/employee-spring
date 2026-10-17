package com.employee.spring;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*This class is a hook for Spring configuration without any <code>web.xml</code> configuration */

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { SpringConfig.class};
    } 

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
