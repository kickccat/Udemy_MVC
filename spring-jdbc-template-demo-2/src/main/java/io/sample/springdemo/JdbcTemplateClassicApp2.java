package io.sample.springdemo;

import io.sample.springdemo.dao.OrganizationDao;
import io.sample.springdemo.daoimpl.OrganizationDaoImpl;
import io.sample.springdemo.domain.Organization;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcTemplateClassicApp2 {
    
    public static void main(String[] args) {
        // Create the application context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
    
        // Create the bean
        OrganizationDao dao = (OrganizationDaoImpl) context.getBean("orgDao");
        
        // List organizations
        DaoUtils.createSeedData(dao);
        List<Organization> organizations = dao.getAllOrganizations();
        DaoUtils.printOrganizations(organizations, DaoUtils.readOperation);
    
        // Create the organization
        Organization organization = new Organization("General Electric", 1978, "98989", 5776, "Imagination at work");
        boolean isCreated = dao.create(organization);
        DaoUtils.printSuccessFailure(DaoUtils.createOperation, isCreated);
        DaoUtils.printOrganizations(dao.getAllOrganizations(), DaoUtils.readOperation);
    
        // Get a single organization
        Organization org2 = dao.getOrganization(1);
        DaoUtils.printOrganization(org2, "getOrganization");
        
        // Update a slogan for an organization
        Organization org3 = dao.getOrganization(2);
        org3.setSlogan("We build ** awesome ** driving machines!");
        boolean isUpdated = dao.update(org3);
        DaoUtils.printSuccessFailure(DaoUtils.updateOperation, isUpdated);
        DaoUtils.printOrganization(dao.getOrganization(2), DaoUtils.updateOperation);
        
        // Delete an organization
        boolean isDeleted = dao.delete(dao.getOrganization(3));
        DaoUtils.printSuccessFailure(DaoUtils.deleteOperation, isDeleted);
        DaoUtils.printOrganizations(dao.getAllOrganizations(), DaoUtils.deleteOperation);
        
        // Cleanup
        dao.cleanup();
        DaoUtils.printOrganizationCount(dao.getAllOrganizations(), DaoUtils.cleanupOperation);
        
        // Close the application context
        context.close();
    }
}
