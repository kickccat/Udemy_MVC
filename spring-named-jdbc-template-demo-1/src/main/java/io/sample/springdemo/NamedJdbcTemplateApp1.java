package io.sample.springdemo;

import io.sample.springdemo.dao.OrganizationDao;
import io.sample.springdemo.domain.Organization;
import io.sample.springdemo.service.DaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NamedJdbcTemplateApp1 {
    
    @Autowired
    private OrganizationDao dao;
    
    @Autowired
    private DaoUtils daoUtils;
    
    private void actionMethod() {
        
        // Create seed
        daoUtils.createSeedData(dao);
    
        // List organizations
        List<Organization> organizations = dao.getAllOrganizations();
        daoUtils.printOrganizations(organizations, daoUtils.readOperation);
    
        // Create the organization
        Organization organization = new Organization("General Electric", 1978, "98989", 5776, "Imagination at work");
        boolean isCreated = dao.create(organization);
        daoUtils.printSuccessFailure(daoUtils.createOperation, isCreated);
        daoUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.readOperation);
    
        // Get a single organization
        Organization org2 = dao.getOrganization(1);
        daoUtils.printOrganization(org2, "getOrganization");
    
        // Update a slogan for an organization
        Organization org3 = dao.getOrganization(2);
        org3.setSlogan("We build ** awesome ** driving machines!");
        boolean isUpdated = dao.update(org3);
        daoUtils.printSuccessFailure(daoUtils.updateOperation, isUpdated);
        daoUtils.printOrganization(dao.getOrganization(2), daoUtils.updateOperation);
    
        // Delete an organization
        boolean isDeleted = dao.delete(dao.getOrganization(3));
        daoUtils.printSuccessFailure(daoUtils.deleteOperation, isDeleted);
        daoUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.deleteOperation);
    
        // Cleanup
        dao.cleanup();
        daoUtils.printOrganizationCount(dao.getAllOrganizations(), daoUtils.cleanupOperation);
    
    }
    
    public static void main(String[] args) {
        // Create the application context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
        NamedJdbcTemplateApp1 mainApp = context.getBean(NamedJdbcTemplateApp1.class);
        mainApp.actionMethod();
//        // Create the bean
//        OrganizationDao dao = (OrganizationDaoImpl) context.getBean("orgDao");
        
        // Close the application context
        context.close();
    }
}
