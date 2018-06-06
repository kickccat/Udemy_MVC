package io.sample;

import io.sample.springdemo.domain.Organization;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertiesWithAnnotationApp
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropertyConfig.class);
        Organization organization = (Organization) context.getBean("myorg");
    
        System.out.println(organization);
        System.out.println("Slogan: " + organization.corporateSlogan());
        
        context.close();
    }
}
