package io.sample.springdemo;

import io.sample.springdemo.domain.Organization;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeApp {
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
    
        Organization organization = (Organization) context.getBean("myorg");
        Organization organization1 = (Organization) context.getBean("myorg");
        organization1.setPostalCode("787878");
    
        System.out.println(organization.coporateSlogan());
        System.out.println(organization);
        System.out.println(organization1);
        if (organization == organization1) {
            System.out.println("Singleton scope test: same instance");
        }
        System.out.println(organization.corporateService());
        context.close();
    }
}