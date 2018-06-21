package io.sample.springdemo;

import io.sample.springdemo.dao.OrganizationDao;
import io.sample.springdemo.daoimpl.OrganizationDaoImpl;
import io.sample.springdemo.domain.Organization;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class JdbcTemplateExceptionApp {
    
    public static void main(String[] args) {
    
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
    
        OrganizationDao dao = (OrganizationDaoImpl) context.getBean("orgDao");
        
        List<Organization> organizations = null;
        try {
            organizations = dao.getAllOrganizations();
        } catch (DataAccessException dae) {
            System.out.println("EXCEPTION MESSAGE: " + dae.getMessage());
            System.out.println("EXCEPTION CLASS: " + dae.getClass());
        }
    
        assert organizations != null;
        for (Organization organization : organizations) {
            System.out.println(organization);
        }
        
        context.close();
    }
}
