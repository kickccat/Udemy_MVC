package io.sample.springdemo;

import io.sample.springdemo.dao.OrganizationDao;
import io.sample.springdemo.daoimpl.OrganizationDaoImpl;
import io.sample.springdemo.domain.Organization;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcTemplateClassicApp1 {
    
    public static void main(String[] args) {
    
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
    
        OrganizationDao dao = (OrganizationDaoImpl) context.getBean("orgDao");
        List<Organization> organizations = dao.getAllOrganizations();
        for (Organization organization : organizations) {
            System.out.println(organization);
        }
        
        context.close();
    }
}
